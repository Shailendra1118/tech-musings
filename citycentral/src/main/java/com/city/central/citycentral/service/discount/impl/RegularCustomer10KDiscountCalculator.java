package com.city.central.citycentral.service.discount.impl;

import com.city.central.citycentral.service.discount.DiscountCalculator;
import com.city.central.citycentral.vo.AmountSlab;
import com.city.central.citycentral.vo.Discount;
import com.city.central.citycentral.vo.PurchaseDetails;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegularCustomer10KDiscountCalculator implements DiscountCalculator {

    private DiscountCalculator nextDiscountCalculator;
    private static final AmountSlab slab = AmountSlab.builder().startAmt(5000).endAmt(10000)
            .discount(Discount.TEN_PERCENT).build();

    @Override
    public double calculate(PurchaseDetails purchaseDetails, double discountAmtTillNow) {
        log.info("Discount before 10K slab={}", discountAmtTillNow);
        if(purchaseDetails.getAmount() >= slab.getEndAmt()){
            //discount is applicable
            double discountWith10KSlab = slab.getDiscount().getValue() * (slab.getEndAmt()-slab.getStartAmt())/100;
            log.info("Discount for 10K slab={}", discountWith10KSlab);

            //pass on to next calculator
            return nextDiscountCalculator.calculate(purchaseDetails, discountAmtTillNow + discountWith10KSlab);
        }
        return discountAmtTillNow;
    }

    @Override
    public void setNextCalculator(DiscountCalculator discountCalculator) {
        this.nextDiscountCalculator = discountCalculator;
    }
}
