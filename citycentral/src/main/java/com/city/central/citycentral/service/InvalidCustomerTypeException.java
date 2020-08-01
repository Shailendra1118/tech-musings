package com.city.central.citycentral.service;

public class InvalidCustomerTypeException extends RuntimeException {

    public InvalidCustomerTypeException(){
        super("Invalid customer type");
    }
}
