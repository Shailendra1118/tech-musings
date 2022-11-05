package com.sports.rafael.basics.java.streams;

import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicsFunc {

    @Test
    public void shortCircuiting() {
        Stream<Integer> stream = Stream.iterate(2, i->i*2);
        List<Integer> list = stream.skip(2).limit(10).collect(Collectors.toList());
        list.forEach(n -> System.out.println(n));
    }


    @Test
    public void testStringSort(){
        var str = "shailendra";
        String res = str.chars().sorted().collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println(res);
    }

    @Test
    public void testBitWise() {
        char[] a = "abc".toCharArray();
        char[] b = "xyz".toCharArray();
        int res = Math.abs(a[0]-b[0])^Math.abs(a[1]-b[1])^Math.abs(a[2]-b[2]);
        System.out.println("Res: "+res);

        System.out.println(11^33);
        String str = "abc";

        char[] chars = str.toCharArray();
        int shift = chars[0];
        for(int i=0; i<chars.length; i++){
            int r = Math.abs(chars[i]-shift+26)%26;
            System.out.println("R: "+r);
            //System.out.println(Character.toChars(r));
            //chars[i] = (char) (Math.abs((int)chars[i]-shift)%26);
        }
        System.out.println(String.valueOf(chars));

    }
}
