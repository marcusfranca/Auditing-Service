package com.gov.Service;

import com.gov.Dto.AgricultureDto;
import com.gov.Mapper.AgriculturalMapper;
import com.gov.Model.Agriculture;
import com.gov.Repository.IAgricultureRepository;
import com.gov.Service.Interface.IAgricultureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AgricultureService implements IAgricultureService {
    private final AgriculturalMapper mapper;
    private final IAgricultureRepository agricultureRepository;
    @Override
    public Agriculture postLandAgriculture(AgricultureDto agricultureDto) {
        var entity = mapper.dtoToEntity(agricultureDto);
        return agricultureRepository.save(entity);
    }
}
