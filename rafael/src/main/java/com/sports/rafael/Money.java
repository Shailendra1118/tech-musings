package com.sports.rafael;

import java.math.BigDecimal;
import java.util.Currency;

public final class Money {

    final private BigDecimal value;
    final private Currency currency;
    final private int DECIMALS = 2;

    private Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.value.setScale(DECIMALS);
        this.currency = currency;
    }

    public static Money getInstance(String value, String currencyCode) {
        BigDecimal val = new BigDecimal(value);
        return new Money(val, Currency.getInstance(currencyCode));
    }

    public BigDecimal getValue() {
        return new BigDecimal(String.valueOf(this.value));
    }

    public String getCurrency() {
        return this.currency.getCurrencyCode();
    }

    public String toString() {
        return this.value.toString()+" "+this.currency.getCurrencyCode();
    }

    public Money multiplyBy(int factor) {
        BigDecimal newVal = this.value.multiply(new BigDecimal(factor));
        return new Money(newVal, this.currency);
    }
}
