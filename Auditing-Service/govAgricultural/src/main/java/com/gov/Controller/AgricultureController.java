package com.gov.Controller;

import com.gov.Dto.AgriculturalEvents.AgriculturalEventCreate;
import com.gov.Dto.AgricultureDto;
import com.gov.Mapper.AgriculturalMapper;
import com.gov.Service.Interface.IAgricultureService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gov.Config.RabbitMQConfig.AGRICULTURAL_EXCHANGE_NAME;

@RequestMapping("agricultural/v1/")
@RestController
@RequiredArgsConstructor
public class AgricultureController {

    private final AgriculturalMapper mapper;

    private final IAgricultureService agricultureService;

    private final RabbitTemplate rabbitTemplate;
    @PostMapping
    public ResponseEntity<AgricultureDto> postLandAgriculture(@RequestBody AgricultureDto agricultureDto){
       var entity =  agricultureService.postLandAgriculture(agricultureDto);
       var dto = mapper.entityToDto(entity);
        AgriculturalEventCreate agriculturalEventCreate = new AgriculturalEventCreate(entity.getId(), entity.getPlaceOfLand(), entity.getValueOfLand(), entity.getLocalDateTimeBuy());
        rabbitTemplate.convertAndSend(AGRICULTURAL_EXCHANGE_NAME, "", agriculturalEventCreate);
        return ResponseEntity.ok(dto);
    }
}
