package com.city.central.citycentral.vo;

public enum Discount {

    ZERO_PERCENT(0),
    TEN_PERCENT(10),
    FIFTEEN_PERCENT(15),
    TWENTY_PERCENT(20),
    THIRTY_PERCENT(30);

    private int value;
    Discount(int value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
