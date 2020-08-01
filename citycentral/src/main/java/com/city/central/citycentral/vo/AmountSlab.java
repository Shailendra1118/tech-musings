package com.city.central.citycentral.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AmountSlab {

    private long startAmt;
    private long endAmt;
    private Discount discount;

}
