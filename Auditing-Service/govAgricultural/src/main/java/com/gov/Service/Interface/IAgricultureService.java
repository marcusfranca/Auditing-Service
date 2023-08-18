package com.gov.Service.Interface;

import com.gov.Dto.AgricultureDto;
import com.gov.Model.Agriculture;

public interface IAgricultureService {
    Agriculture postLandAgriculture(AgricultureDto agricultureDto);
}
