package com.city.central.citycentral.service;

import com.city.central.citycentral.service.discount.impl.PremiumCustomerMinDiscountCalculator;
import com.city.central.citycentral.service.discount.impl.RegularCustomerMinDiscountCalculator;
import com.city.central.citycentral.service.impl.BillingServiceImpl;
import com.city.central.citycentral.vo.CustomerType;
import com.city.central.citycentral.vo.PurchaseDetails;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BillingServiceImplTest {

    @MockBean
    RegularCustomerMinDiscountCalculator regularCustomerMinDiscountCalculator;

    @Mock
    PremiumCustomerMinDiscountCalculator premiumCustomerMinDiscountCalculator;

    @Autowired
    BillingServiceImpl billingService;


    //TODO
    @Test
    public void getBillTestForRegularCustomer(){
        PurchaseDetails purchaseDetails = PurchaseDetails.builder().customerType(CustomerType.REGULAR)
                .amount(15000).build();
        billingService.getBill(purchaseDetails);

    }

}
