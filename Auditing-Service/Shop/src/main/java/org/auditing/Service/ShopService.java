package org.auditing.Service;

import lombok.RequiredArgsConstructor;
import org.auditing.Mapper.ShopMapper;
import org.auditing.Model.Shop;
import org.auditing.Repository.ShopRepository;
import org.auditing.dto.ShopDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService implements IShopService {

    @Autowired
    ShopRepository shopRepository;

    private final ShopMapper shopMapper;

    @Override
    public List<Shop> listShop() {
        return shopRepository.findAll();
    }

    @Override
    public Shop GetByShop(Long id) {
       return shopRepository.findById(id).orElseThrow(); // vai mandar um 500, depois tratar esse cara.
    }

    @Override
    public Shop postShop(ShopDto shop) {
        var ShopEntity = shopMapper.dtoToEntity(shop);
        return shopRepository.save(ShopEntity);
    }

    @Override
    public Shop putShop(ShopDto shop, Long id) {
        GetByShop(id);
        try{
            Shop shopEntity = new Shop();
            shopEntity.setId(shop.getId());
            shopEntity.setName(shop.getName());
            shopEntity.setValue(shop.getValue());
            shopRepository.save(shopEntity);
            return shopEntity;
        }catch (Exception ex){
             ex.getMessage();
             return null;
        }
    }

    @Override
    public Shop deleteShop(ShopDto shop, Long id) {
        GetByShop(id);
        var ShopEntity = shopMapper.dtoToEntity(shop);
        try{
            shopRepository.delete(ShopEntity);
            return null;
        }catch (Exception ex){
            ex.getMessage();
            return ShopEntity;
        }
    }
}
