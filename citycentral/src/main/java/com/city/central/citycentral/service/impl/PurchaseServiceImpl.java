package com.city.central.citycentral.service.impl;

import com.city.central.citycentral.service.PurchaseService;
import com.city.central.citycentral.vo.CustomerType;
import com.city.central.citycentral.vo.PurchaseDetails;
import org.springframework.stereotype.Component;

@Component
public class PurchaseServiceImpl implements PurchaseService {
    @Override
    public PurchaseDetails getPurchaseAmount() {

        return PurchaseDetails.builder().customerType(CustomerType.PREMIUM)
                .amount(9000).build();
    }
}
