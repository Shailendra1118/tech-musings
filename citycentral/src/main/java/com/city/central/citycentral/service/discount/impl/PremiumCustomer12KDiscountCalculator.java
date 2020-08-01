package com.city.central.citycentral.service.discount.impl;

import com.city.central.citycentral.service.discount.DiscountCalculator;
import com.city.central.citycentral.vo.AmountSlab;
import com.city.central.citycentral.vo.Discount;
import com.city.central.citycentral.vo.PurchaseDetails;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PremiumCustomer12KDiscountCalculator implements DiscountCalculator {

    private DiscountCalculator nextDiscountCalculator;
    private static final AmountSlab slab = AmountSlab.builder().startAmt(8000).endAmt(12000)
            .discount(Discount.TWENTY_PERCENT).build();

    @Override
    public double calculate(PurchaseDetails purchaseDetails, double discountAmtTillNow) {

        if(purchaseDetails.getAmount() >= slab.getEndAmt()){
            //discount is applicable
            double discountHere = slab.getDiscount().getValue() * (slab.getEndAmt()-slab.getStartAmt())/100;
            log.info("Discount with 12K Slab={}", discountHere);
            //pass on to next calculator
            return nextDiscountCalculator.calculate(purchaseDetails, discountAmtTillNow + discountHere);
        }
        return discountAmtTillNow;
    }

    @Override
    public void setNextCalculator(DiscountCalculator discountCalculator) {
        this.nextDiscountCalculator = discountCalculator;
    }
}
