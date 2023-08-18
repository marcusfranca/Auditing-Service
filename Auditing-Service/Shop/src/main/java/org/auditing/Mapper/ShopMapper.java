package org.auditing.Mapper;

import lombok.RequiredArgsConstructor;
import org.auditing.Model.Shop;
import org.auditing.dto.PostShopDto;
import org.auditing.dto.ShopDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component // ver sobre esse annotation
public class ShopMapper {

    private final ModelMapper mapper;

    public ShopDto entityToDto(Shop shop){
        return mapper.map(shop, ShopDto.class);
    }

    public Shop dtoToEntity(ShopDto shopDto){
        return  mapper.map(shopDto, Shop.class);
    }
    public Shop PostDtoToEntity(PostShopDto postShopDto){
        return  mapper.map(postShopDto, Shop.class);
    }
    public PostShopDto entityToPostDto(Shop shop){
        return mapper.map(shop, PostShopDto.class);
    }
}
