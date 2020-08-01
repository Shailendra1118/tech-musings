package com.city.central.citycentral.service.discount.impl;

import com.city.central.citycentral.service.discount.DiscountRule;
import com.city.central.citycentral.vo.AmountSlab;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultDiscountRule implements DiscountRule {

    @Override
    public double getDiscount(AmountSlab slab) {
        return slab.getDiscount().getValue() * (slab.getEndAmt()-slab.getStartAmt())/100;
    }
}
