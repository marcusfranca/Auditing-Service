package com.gov.Mapper;

import com.gov.Dto.AgricultureDto;
import com.gov.Model.Agriculture;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AgriculturalMapper {
    private final ModelMapper mapper;

    public Agriculture dtoToEntity(AgricultureDto agricultureDto){
        return mapper.map(agricultureDto, Agriculture.class);
    }

    public AgricultureDto entityToDto(Agriculture agriculture){
        return mapper.map(agriculture, AgricultureDto.class);
    }
}
