package com.city.central.citycentral.config;

import com.city.central.citycentral.service.discount.impl.PremiumCustomer12KDiscountCalculator;
import com.city.central.citycentral.service.discount.impl.PremiumCustomer8KDiscountCalculator;
import com.city.central.citycentral.service.discount.impl.PremiumCustomerMaxDiscountCalculator;
import com.city.central.citycentral.service.discount.impl.PremiumCustomerMinDiscountCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BillingConfigPremiumCustomer {

    @Bean
    public PremiumCustomerMinDiscountCalculator premiumCustomerMinDiscountCalculator(){
        PremiumCustomerMinDiscountCalculator premiumCustomerMinDiscountCalculator = new PremiumCustomerMinDiscountCalculator();
        premiumCustomerMinDiscountCalculator.setNextCalculator(premiumCustomer8KDiscountCalculator());
        return premiumCustomerMinDiscountCalculator;
    }

    @Bean
    public PremiumCustomer8KDiscountCalculator premiumCustomer8KDiscountCalculator(){
        PremiumCustomer8KDiscountCalculator premiumCustomer8KDiscountCalculator =
                new PremiumCustomer8KDiscountCalculator();
        premiumCustomer8KDiscountCalculator.setNextCalculator(premiumCustomer12KDiscountCalculator());
        return premiumCustomer8KDiscountCalculator;
    }

    @Bean
    public PremiumCustomer12KDiscountCalculator premiumCustomer12KDiscountCalculator(){
        PremiumCustomer12KDiscountCalculator premiumCustomer12KDiscountCalculator =
                new PremiumCustomer12KDiscountCalculator();
        premiumCustomer12KDiscountCalculator.setNextCalculator(premiumCustomerMaxDiscountCalculator());
        return premiumCustomer12KDiscountCalculator;
    }

    @Bean
    public PremiumCustomerMaxDiscountCalculator premiumCustomerMaxDiscountCalculator(){
        PremiumCustomerMaxDiscountCalculator premiumCustomerMaxDiscountCalculator = new PremiumCustomerMaxDiscountCalculator();
        return premiumCustomerMaxDiscountCalculator;
    }
}
