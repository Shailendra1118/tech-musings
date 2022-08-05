package com.sports.rafael.ex.slovians;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ISINGeneratorTest {

    @Test
    public void testISINPrefix() {
        ISINGenerator generator = new ISINGenerator();
        String prefix = generator.getISINPrefix();
        System.out.println("Prefix:"+prefix);
        assertTrue(Character.isUpperCase(prefix.charAt(0)), "Message is not uppercase");
        assertTrue(Character.isUpperCase(prefix.charAt(1)), "Message is not uppercase");
        assertTrue(prefix.length() ==2, "Prefix should be of length 2");
    }

    @Test
    public void testISINProperties() {
        ISINGenerator generator = new ISINGenerator();
        String ISIN = generator.next();
        assertNotNull(ISIN);
    }

    @Test
    public void test9AlphaNumerics() {
        ISINGenerator generator = new ISINGenerator();
        String numerics = generator.get9Alphanumerics();
        System.out.println("Numeric: "+numerics);
        assertTrue(numerics.length() == 9, "Numerics should be of length 9");
    }

    @Test
    public void testCheckDigit() {
        ISINGenerator generator = new ISINGenerator();
        String digit = generator.getCheckDigit("DA123456789");
        assertTrue(digit.length() == 1);
        assertTrue(Character.isDigit(digit.charAt(0)));
        assertTrue(digit.equals("7"));
    }

}
