package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class VanityNumbers {

    @Test
    public void testVanity() {

        List<String> numbers = new ArrayList<>();
        numbers.add("+14157088956");
        numbers.add("+17474824380");
        numbers.add("+919810155555");
        numbers.add("+15109926333");
        numbers.add("+1415123456");

        List<String> codes = new ArrayList<>();
        codes.add("TWLO");
        codes.add("CODE");
        codes.add("HTCH");

        List<String> res = vanity(codes, numbers);
        System.out.println("RES: "+res);


    }

    static List<String> vanity(List<String> codes, List<String> numbers) {
        Map<Character, Character> map = new HashMap<>();
        map.put('A', '2');
        map.put('B', '2');
        map.put('C', '2');
        map.put('D', '3');
        map.put('E', '3');
        map.put('F', '3');
        map.put('G', '4');
        map.put('H', '4');
        map.put('I', '4');
        map.put('J', '5');
        map.put('K', '5');
        map.put('L', '5');
        map.put('M', '6');
        map.put('N', '6');
        map.put('O', '6');
        map.put('P', '7');
        map.put('Q', '7');
        map.put('R', '7');
        map.put('S', '7');
        map.put('T', '8');
        map.put('U', '8');
        map.put('V', '8');
        map.put('W', '9');
        map.put('X', '9');
        map.put('Y', '9');
        map.put('Z', '9');

        //Map<String, String> codeToNumber = new HashMap<>();
        List<String> codeNumbers = new ArrayList<>();
        for (String code : codes) {
            char[] num = new char[code.length()];
            int i = 0;
            char[] arr = code.toCharArray();
            for (char ch : arr) {
                num[i++] = map.get(ch);
            }
            codeNumbers.add(new String(num));
        }
        System.out.println(codeNumbers);
        List<String> res = new ArrayList<>();
        for (String number : numbers) {
            for (String code : codeNumbers) {
                if (number.indexOf(code) >=0 ) {
                    res.add(number);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    @Test
    void testSetList() {
        Set<String> set = new TreeSet<>();
        List<String> list = new ArrayList<>();
        set.add("ABC");
        set.add("XKDF");
        set.add("8686");
        list.addAll(set);
        System.out.println(list);


    }

    @Test
    public void testStrings() {
        String s = "kshfdlsahdflas lkasjdflkajsdflkj laksdjflksjdf lksdjflkj lkj  lkjsadflkj lkjlkjl";
        System.out.println(s.substring(5));
    }

}
