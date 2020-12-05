package com.sports.rafael.pojo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Tiaa {

    public static void main(String[] args) {
        String str = "@#5t6e%&fgi";
        int i =0;
        char arr[] = str.toCharArray();
        int j = arr.length-1;
        while(i < j) {
            if(!Character.isDigit(arr[i]) && !Character.isDigit(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
            j--;
        }
        String res = String.valueOf(arr);
        System.out.println(res);
    }

    @Test
    public void groupThem() {
        List<String> list = Arrays.asList("ABC", "CD", "AB", "BAC", "AAA", "DC");
        Map<Set<Character>, List<String>> map = new HashMap<>();
        for(String s : list){
            Set<Character> key = new HashSet<>();
            List<Character> charList = s.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
            key.addAll(charList);
            if(map.containsKey(key)) {
                //System.out.println("Key: "+key);
                //map.get(key).forEach(val -> System.out.println(val));
                map.get(key).add(s);
            }else{
                List<String> nl = new ArrayList<>();
                nl.add(s);
                map.put(key, nl);
            }
        }

        System.out.println("Res: ");
        map.entrySet().forEach(e -> {
            System.out.println("Key: "+e.getKey());
            System.out.println("Value: "+Arrays.toString(e.getValue().toArray()));

        });
    }
}
