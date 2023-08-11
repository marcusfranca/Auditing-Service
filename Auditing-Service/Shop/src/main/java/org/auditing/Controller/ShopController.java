package org.auditing.Controller;

import org.auditing.EventCreate.ShopEventCreate;
import org.auditing.Model.Shop;
import org.auditing.Repository.ShopRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/shop")
@RestController
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public Shop CreateProduct(@RequestBody Shop shop){
        shopRepository.save(shop);
        ShopEventCreate shopEventCreate = new ShopEventCreate(shop.getId(), shop.getName(), shop.getValue());
        rabbitTemplate.convertAndSend("shop.v1.product-created", "", shopEventCreate);
        return shop;
    }
}
