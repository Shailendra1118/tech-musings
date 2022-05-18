package com.sports.rafael.ques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumbers {

    public static void main(String[] args) {

        PhoneNumbers obj = new PhoneNumbers();
        Map<String, String> map = new HashMap();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        String digits = "234";
        char nums[] = digits.toCharArray();
        List<String> res = new ArrayList<>();
        obj.util(map, "", nums, 0, res);

        System.out.println(res);
    }

    private void util(Map<String,String> map, String str, char nums[], int current, List<String> res) {

        if(current == nums.length){
            res.add(str);
            return;
        }
        String chars = map.get(String.valueOf(nums[current])); // "abc"

        for(int i=0; i<chars.length(); i++){
            util(map, str+chars.charAt(i), nums, current+1, res);
        }
    }


}
