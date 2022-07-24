package com.sports.rafael;

import org.junit.jupiter.api.Test;

public class CommerceTest {

    @Test
    public void testMoneyCreation() {
        Money eu = Money.getInstance("67.89", "EUR");
        Money usd = Money.getInstance("98.76", "USD");
        System.out.println(eu);
        System.out.println(usd);

        System.out.println(eu.multiplyBy(75));
        System.out.println(usd.multiplyBy(4));
    }
}
