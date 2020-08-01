package com.city.central.citycentral.service.impl;

import com.city.central.citycentral.service.BillingService;
import com.city.central.citycentral.service.InvalidCustomerTypeException;
import com.city.central.citycentral.service.discount.impl.PremiumCustomerMinDiscountCalculator;
import com.city.central.citycentral.service.discount.impl.RegularCustomerMinDiscountCalculator;
import com.city.central.citycentral.vo.CustomerType;
import com.city.central.citycentral.vo.PurchaseDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BillingServiceImpl implements BillingService {

    @Autowired
    PremiumCustomerBilling premiumCustomerBilling;

    @Autowired
    RegularCustomerMinDiscountCalculator regularCustomerMinDiscountCalculator;

    @Autowired
    PremiumCustomerMinDiscountCalculator premiumCustomerMinDiscountCalculator;

    @Override
    public double getBill(PurchaseDetails purchaseDetails) {

        if(CustomerType.REGULAR.equals(purchaseDetails.getCustomerType())){
            double discount = regularCustomerMinDiscountCalculator.calculate(purchaseDetails, 0);
            log.info("Discount={} with amount={} for Regular Customer.", discount, purchaseDetails.getAmount());
            return purchaseDetails.getAmount() - discount;
        }else if(CustomerType.PREMIUM.equals(purchaseDetails.getCustomerType())){
            double discount = premiumCustomerMinDiscountCalculator.calculate(purchaseDetails, 0);
            log.info("Discount={} with amount={} for Premium Customer.", discount, purchaseDetails.getAmount());
            return purchaseDetails.getAmount() - discount;
        }else {
            throw new InvalidCustomerTypeException();
        }
    }
}
