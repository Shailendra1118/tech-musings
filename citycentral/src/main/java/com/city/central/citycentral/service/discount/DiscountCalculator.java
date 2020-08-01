package com.city.central.citycentral.service.discount;

import com.city.central.citycentral.vo.PurchaseDetails;

public interface DiscountCalculator {

    double calculate(PurchaseDetails purchaseDetails, double discountTillNow);

    void setNextCalculator(DiscountCalculator discountCalculator);
}
