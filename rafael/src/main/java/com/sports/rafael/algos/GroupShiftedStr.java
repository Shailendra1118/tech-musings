package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStr {
    public static void main(String[] args) {
        GroupShiftedStr obj = new GroupShiftedStr();
        String[] input = {"abc","bcd","acef","xyz","az","ba","a","z"};
        var res = obj.groupStrings(input);
        res.stream().forEach(list -> System.out.println(list));

    }

    public List<List<String>> groupStrings(String[] strings) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strings) {
            String hash = calculate(str);
            if(map.get(hash) == null) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(str);
        }

        for(var entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private String calculate(String str){
        char[] chars = str.toCharArray();
        int shift = chars[0];
        for(int i=0; i<chars.length; i++){
            chars[i] = (char) (Math.abs((int)chars[i]-shift)%26);
        }
        System.out.println(String.valueOf(chars));
        return String.valueOf(chars);
    }
}
