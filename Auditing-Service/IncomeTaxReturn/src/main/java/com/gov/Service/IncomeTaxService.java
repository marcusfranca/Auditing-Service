package com.gov.Service;

import com.gov.Dto.PostDto;
import com.gov.Mapper.CustomerMapper;
import com.gov.Model.Customer;
import com.gov.Repository.IncomeTaxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncomeTaxService implements IIncomeTaxService {
    private final IncomeTaxRepository incomeTaxRepository;

    private final CustomerMapper mapper;
    @Override
    public Customer publicIncomeTax(PostDto postDto) {
        var customer = mapper.DtoToCustomer(postDto);
        return incomeTaxRepository.save(customer);
    }
}
