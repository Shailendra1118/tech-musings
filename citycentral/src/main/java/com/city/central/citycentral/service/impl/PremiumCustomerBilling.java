package com.city.central.citycentral.service.impl;

import com.city.central.citycentral.service.CustomerBilling;
import org.springframework.stereotype.Component;

@Component
public class PremiumCustomerBilling implements CustomerBilling {

    @Override
    public double run(double purchaseAmt) {
        return 0;
    }
}
