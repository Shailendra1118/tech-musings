package com.city.central.citycentral;

import com.city.central.citycentral.service.BillingService;
import com.city.central.citycentral.service.PurchaseService;
import com.city.central.citycentral.vo.PurchaseDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CitycentralApplication implements CommandLineRunner {

	@Autowired
	BillingService billingService;

	@Autowired
	PurchaseService purchaseService;

	public static void main(String[] args){
		SpringApplication.run(CitycentralApplication.class, args);
	}

	@Override
	public void run(String... args) {

		PurchaseDetails purchaseDetails = purchaseService.getPurchaseAmount();
		double postDiscountAmt = billingService.getBill(purchaseDetails);
		log.info("Payable after discount={}", postDiscountAmt);
	}
}
