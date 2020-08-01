package com.city.central.citycentral.service;

import com.city.central.citycentral.vo.PurchaseDetails;
import org.springframework.stereotype.Component;


@Component
public interface BillingService {

    double getBill(PurchaseDetails purchaseDetails);
}
