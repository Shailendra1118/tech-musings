package com.city.central.citycentral.service.discount.impl;

import com.city.central.citycentral.service.discount.DiscountCalculator;
import com.city.central.citycentral.vo.AmountSlab;
import com.city.central.citycentral.vo.Discount;
import com.city.central.citycentral.vo.PurchaseDetails;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PremiumCustomerMaxDiscountCalculator implements DiscountCalculator {

    private DiscountCalculator nextDiscountCalculator;
    private static final AmountSlab slab = AmountSlab.builder().startAmt(12000)
            .discount(Discount.THIRTY_PERCENT).build();

    @Override
    public double calculate(PurchaseDetails purchaseDetails, double discountAmtTillNow) {
        log.info("Discount before Max slab={}", discountAmtTillNow);
        double discountHere = 0;
        if(purchaseDetails.getAmount() >= slab.getStartAmt()){
            //discount is applicable
            discountHere = slab.getDiscount().getValue() * (purchaseDetails.getAmount()-slab.getStartAmt())/100;
            log.info("Discount in Max slab={}", discountHere);
            //No next calculator
        }
        return discountAmtTillNow + discountHere;
    }

    @Override
    public void setNextCalculator(DiscountCalculator discountCalculator) {
        // no next calculator
    }
}
