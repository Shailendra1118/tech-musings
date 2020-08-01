package com.city.central.citycentral.vo;

public enum CustomerType {

    REGULAR("Regular"),
    PREMIUM("Premium");

    private String value;

    CustomerType(String value){
        this.value = value;
    }
}
