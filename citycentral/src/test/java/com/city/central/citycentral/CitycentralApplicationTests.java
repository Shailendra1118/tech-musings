package com.city.central.citycentral;

import com.city.central.citycentral.service.BillingService;
import com.city.central.citycentral.vo.CustomerType;
import com.city.central.citycentral.vo.PurchaseDetails;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CitycentralApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	BillingService billingService;

	@Test
	public void testRegularCustomerCoveringAllSlabs(){
		PurchaseDetails details = PurchaseDetails.builder().customerType(CustomerType.REGULAR).amount(15000).build();
		double postDisc = billingService.getBill(details);
		log.info("Bill={}", postDisc);
		Assert.assertTrue("Wrong Bill for regularCustomer with 15000", postDisc == 13500.0);
	}

	@Test
	public void testRegularCustomerTillSecondSlab(){
		PurchaseDetails details = PurchaseDetails.builder().customerType(CustomerType.REGULAR).amount(10000).build();
		double postDisc = billingService.getBill(details);
		log.info("Bill={}", postDisc);
		Assert.assertTrue("Wrong Bill for regularCustomer with 9500.0", postDisc == 9500.0);
	}

	@Test
	public void testRegularCustomerWithMinimumAmt(){
		PurchaseDetails details = PurchaseDetails.builder().customerType(CustomerType.REGULAR).amount(5000).build();
		double postDisc = billingService.getBill(details);
		log.info("Bill={}", postDisc);
		Assert.assertTrue("Wrong Bill for regularCustomer with Minimum 5000.0", postDisc == 5000.0);
	}

	@Test
	public void testPremiumCustomerCoveringAllSlabs(){
		PurchaseDetails details = PurchaseDetails.builder().customerType(CustomerType.PREMIUM).amount(20000).build();
		double postDisc = billingService.getBill(details);
		log.info("Bill={}", postDisc);
		Assert.assertTrue("Wrong Bill for Premium Customer with 20000", postDisc == 15800.0);
	}

	@Test
	public void testRegularCustomerTill8K(){
		PurchaseDetails details = PurchaseDetails.builder().customerType(CustomerType.PREMIUM).amount(8000).build();
		double postDisc = billingService.getBill(details);
		log.info("Bill={}", postDisc);
		Assert.assertTrue("Wrong Bill for regularCustomer with 9500.0", postDisc == 7000.0);
	}

	@Test
	public void testRegularCustomerTill12K(){
		PurchaseDetails details = PurchaseDetails.builder().customerType(CustomerType.PREMIUM).amount(12000).build();
		double postDisc = billingService.getBill(details);
		log.info("Bill={}", postDisc);
		Assert.assertTrue("Wrong Bill for regularCustomer with Minimum 5000.0", postDisc == 10200.0);
	}

}
