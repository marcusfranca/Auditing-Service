package org.auditing.Controller;

import lombok.RequiredArgsConstructor;
import org.auditing.dto.EventCreate.ShopEventCreate;
import org.auditing.Mapper.ShopMapper;
import org.auditing.Model.Shop;
import org.auditing.Service.IShopService;
import org.auditing.dto.PostShopDto;
import org.auditing.dto.ShopDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.auditing.Config.RabbitMQConfig.SHOP_EXCHANGE_NAME;

@RequestMapping("/v1/shop")
@RestController
@RequiredArgsConstructor
public class ShopController {

    private final IShopService shopService;

    private final RabbitTemplate rabbitTemplate;

    private final ShopMapper shopMapper;

    private static final String SHOP_CREATED_ROUTING_KEY = "shop.v1.product-created";
    private static final String SHOP_UPDATE_ROUTING_KEY = "shop.v1.product-update";
    private static final String SHOP_DELETE_ROUTING_KEY = "shop.v1.product-delete";
    @GetMapping
    public ResponseEntity<List<Shop>> listShop() {
        return ResponseEntity.ok(shopService.listShop());
    }

    @GetMapping("{id}")
    public ResponseEntity<Shop> GetByProduct(@PathVariable Long id) {
        return ResponseEntity.ok(shopService.GetByShop(id));
    }

    @PostMapping
    public ResponseEntity<PostShopDto> CreateProduct(@RequestBody PostShopDto shop) {
        var entity = shopService.postShop(shop);
        var dto = shopMapper.entityToPostDto(entity);
        ShopEventCreate shopEventCreate = new ShopEventCreate(shop.getId(), shop.getName(), shop.getValue());
        rabbitTemplate.convertAndSend(SHOP_EXCHANGE_NAME, SHOP_CREATED_ROUTING_KEY, shopEventCreate);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ShopDto> PutProduct(@RequestBody ShopDto shop, @PathVariable Long id) {
        var putProduct = shopService.putShop(shop, id);
        if (putProduct != null) {
            var dto = shopMapper.entityToDto(putProduct);
            ShopEventCreate shopEventCreate = new ShopEventCreate(shop.getId(), shop.getName(), shop.getValue());
            rabbitTemplate.convertAndSend(SHOP_EXCHANGE_NAME, SHOP_UPDATE_ROUTING_KEY, shopEventCreate);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //endpont para put approved

    @DeleteMapping("{id}")
    public ResponseEntity<ShopDto> DeleteProduct(@RequestBody ShopDto shop, @PathVariable Long id) {
        var entity = shopService.deleteShop(shop, id);
        if (entity == null) {
            ShopEventCreate shopEventCreate = new ShopEventCreate(shop.getId(), shop.getName(), shop.getValue());
            rabbitTemplate.convertAndSend(SHOP_EXCHANGE_NAME, SHOP_DELETE_ROUTING_KEY, shopEventCreate);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
