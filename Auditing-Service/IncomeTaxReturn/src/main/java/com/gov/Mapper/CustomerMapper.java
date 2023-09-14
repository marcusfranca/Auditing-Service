package com.gov.Mapper;

import com.gov.Dto.PostDto;
import com.gov.Model.Customer;
import configMapper.MapperConfig;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerMapper extends MapperConfig {
    private final ModelMapper mapper;

    public PostDto CustomerToDto(Customer customer){
        return mapper.map(customer, PostDto.class);
    }
    public Customer DtoToCustomer(PostDto postDto){
        return mapper.map(postDto, Customer.class);
    }
}
