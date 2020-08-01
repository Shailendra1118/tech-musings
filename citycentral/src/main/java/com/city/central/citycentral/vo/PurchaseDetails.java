package com.city.central.citycentral.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseDetails {

    private CustomerType customerType;
    private long amount;

}
