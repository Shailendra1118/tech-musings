package com.city.central.citycentral.service.discount;

import com.city.central.citycentral.vo.AmountSlab;

public interface DiscountRule {

    double getDiscount(AmountSlab amountSlab);


}
