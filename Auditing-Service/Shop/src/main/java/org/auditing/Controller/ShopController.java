package org.auditing.Controller;

import lombok.RequiredArgsConstructor;
import org.auditing.EventCreate.ShopEventCreate;
import org.auditing.Mapper.ShopMapper;
import org.auditing.Model.Shop;
import org.auditing.Repository.ShopRepository;
import org.auditing.Service.IShopService;
import org.auditing.dto.ShopDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/shop")
@RestController
@RequiredArgsConstructor
public class ShopController {

    @Autowired
    private IShopService shopService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final ShopMapper shopMapper;

    @GetMapping
    public ResponseEntity<List<Shop>> listShop() {
        return ResponseEntity.ok(shopService.listShop());
    }

    @GetMapping("{id}")
    public ResponseEntity<Shop> GetByProduct(@PathVariable Long id) {

        return ResponseEntity.ok(shopService.GetByShop(id));
    }

    @PostMapping
    public ResponseEntity<ShopDto> CreateProduct(@RequestBody ShopDto shop) {
        var entity = shopService.postShop(shop);
        var dto = shopMapper.entityToDto(entity);
        ShopEventCreate shopEventCreate = new ShopEventCreate(shop.getId(), shop.getName(), shop.getValue());
        rabbitTemplate.convertAndSend("shop.v1.product-created", "", shopEventCreate);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ShopDto> PutProduct(@RequestBody ShopDto shop, @PathVariable Long id) {
        var putProduct = shopService.putShop(shop, id);
        if (putProduct != null) {
            var dto = shopMapper.entityToDto(putProduct);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ShopDto> DeleteProduct(@RequestBody ShopDto shopDto, @PathVariable Long id) {
        var entity = shopService.deleteShop(shopDto, id);
        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
