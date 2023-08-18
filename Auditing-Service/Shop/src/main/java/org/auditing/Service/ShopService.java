package org.auditing.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.auditing.Mapper.ShopMapper;
import org.auditing.Model.Shop;
import org.auditing.Repository.ShopRepository;
import org.auditing.dto.PostShopDto;
import org.auditing.dto.ShopDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ShopService implements IShopService {


    private final ShopRepository shopRepository;

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
    public Shop postShop(PostShopDto shop) {
        var ShopEntity = shopMapper.PostDtoToEntity(shop);
        ShopEntity.setIsApproval(false);
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
            shopEntity.setIsApproval(false);
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
