package com.gov.Service;

import com.gov.Dto.PostDto;
import com.gov.Model.Customer;

public interface IIncomeTaxService {
    Customer publicIncomeTax(PostDto postDto);
}
