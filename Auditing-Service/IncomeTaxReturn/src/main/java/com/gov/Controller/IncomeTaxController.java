package com.gov.Controller;

import com.gov.Dto.Event.IncomeEventCreate;
import com.gov.Dto.PostDto;
import com.gov.Mapper.CustomerMapper;
import com.gov.Service.IncomeTaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gov.Config.RabbitMQConfig.INCOME_TAX_EXCHANGE_NAME;

@RestController
@RequestMapping("incometax/v1/")
@RequiredArgsConstructor
public class IncomeTaxController {


    private final RabbitTemplate rabbitTemplate;

    private final IncomeTaxService incomeTaxService;

    private final CustomerMapper mapper;

    private static final String INCOME_TAX_EVENT_HEADER_NAME = "imcometax.event.type";
    private static final String INCOME_TAX_CREATE_EVENT_HEADER_NAME = "incometax.create";


    @PostMapping
    public ResponseEntity<PostDto> create(@RequestBody PostDto postDto) { // retorno Dto
        var customer = incomeTaxService.publicIncomeTax(postDto);
        var dto = mapper.CustomerToDto(customer);

        IncomeEventCreate incomeEventCreate = new IncomeEventCreate(postDto.getName(), postDto.getCpf(), postDto.getValue());
        MessagePostProcessor message = message1 -> {
            MessageProperties messageProperties = message1.getMessageProperties();
            messageProperties.setHeader(INCOME_TAX_EVENT_HEADER_NAME, INCOME_TAX_CREATE_EVENT_HEADER_NAME);
            return message1;
        };
        rabbitTemplate.convertAndSend(INCOME_TAX_EXCHANGE_NAME, "", incomeEventCreate, message);
        return ResponseEntity.ok(dto);
    }
}
