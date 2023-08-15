package org.auditing.Service;

import org.auditing.Model.Shop;
import org.auditing.dto.ShopDto;

import java.util.List;

public interface IShopService {

    public List<Shop> listShop();
    public Shop GetByShop(Long id);
    public Shop postShop(ShopDto shop);
    public Shop putShop(ShopDto shop, Long id);

    public Shop deleteShop(ShopDto shop, Long id);

}
