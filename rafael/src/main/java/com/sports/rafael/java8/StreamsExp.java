package com.sports.rafael.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamsExp {

    public static void main(String[] args) {
        String a = "abc";
        Set<Character> set = new HashSet<>();
        a.chars().forEach(c-> set.add(Character.valueOf((char) c)));
        System.out.println("ABC chars:" +set);

        String b = "sfa";
        Set<Character> temp = new HashSet<>();
        b.chars().forEach(c-> temp.add(Character.valueOf((char) c)));
        //System.out.println("temp: "+temp);
        //System.out.println(temp.equals(set));

        temp.remove('f');
        //System.out.println(temp.equals(set));
        //System.out.println(temp);

        StreamsExp obj = new StreamsExp();
        List<Integer> res = obj.findAnagrams("cbaebabacd", "abc");
        res = obj.findAnagrams("adlbcdqsldaku", "dla");
        System.out.println("res: "+ res);


    }


    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res= new ArrayList<>();

        Set<Character> set = new HashSet<>();
        p.chars().forEach(c -> set.add(Character.valueOf((char) c)));

        int i = 0;
        int startedAt = 0;
        Set<Character> temp = new HashSet<>();

        while (i < p.length()) {
            temp.add(s.charAt(i));
            i++;
        }

       // while(i < (s.length() - p.length())) {
        while(i < s.length()) {
            if(temp.equals(set)){
                res.add(startedAt);
            }

            temp.remove(s.charAt(startedAt++));
            temp.add(s.charAt(i++));
            System.out.println("Temp: "+temp);
        }

        return res;


    }
}
