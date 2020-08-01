package com.city.central.citycentral.config;

import com.city.central.citycentral.service.discount.impl.RegularCustomer10KDiscountCalculator;
import com.city.central.citycentral.service.discount.impl.RegularCustomerMaxDiscountCalculator;
import com.city.central.citycentral.service.discount.impl.RegularCustomerMinDiscountCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BillingConfigRegularCustomer {

    @Bean
    public RegularCustomerMinDiscountCalculator regularCustomerMinDiscountCalculator(){
        RegularCustomerMinDiscountCalculator regularCustomerDiscountCal = new RegularCustomerMinDiscountCalculator();
        regularCustomerDiscountCal.setNextCalculator(regularCustomer10KDiscountCalculator());
        return regularCustomerDiscountCal;
    }

    @Bean
    public RegularCustomer10KDiscountCalculator regularCustomer10KDiscountCalculator(){
        RegularCustomer10KDiscountCalculator regularCustomer10KDiscountCalculator =
                new RegularCustomer10KDiscountCalculator();
        regularCustomer10KDiscountCalculator.setNextCalculator(regularCustomerMaxDiscountCalculator());
        return regularCustomer10KDiscountCalculator;
    }

    @Bean
    public RegularCustomerMaxDiscountCalculator regularCustomerMaxDiscountCalculator(){
        RegularCustomerMaxDiscountCalculator regularCustomerMaxDiscountCalculator = new RegularCustomerMaxDiscountCalculator();
        return regularCustomerMaxDiscountCalculator;
    }
}
