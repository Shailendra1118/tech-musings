package com.sports.rafael.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MostCommonWord {
    // #819

    public static void main(String[] args) {
        //String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        String out = new MostCommonWord().mostCommonWord(paragraph, banned);
        System.out.println("Result: "+out);
    }

    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> map = new HashMap<>();
        paragraph = paragraph.replaceAll("[!,.?';]", " ");
        System.out.println(paragraph);
        String words[] = paragraph.split( " ");
        System.out.println("Words: "+Arrays.toString(words));
        for(String word : words) {
            boolean isBanned = false;
            word = removePunctuation(word);
            if(word.length() != 0) {
                for(String b : banned) {
                    if(b.equals(word)) {
                        isBanned = true;
                        break;
                    }
                }
                if(!isBanned) {
                    map.put(word, map.getOrDefault(word, 1) +1);
                }
            }

        }
        //sort by frequency
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        //alternative
        /* map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),
                        (oldVal, newVal) -> oldVal, LinkedHashMap::new)); */
        //sortedMap.forEach((s, integer) -> System.out.println("K:"+s+" V:"+integer));
        sortedMap.entrySet().forEach(e -> System.out.println(e));
        String result = sortedMap.entrySet().iterator().next().getKey();
        return result;

    }

    private String removePunctuation(String word) {
        System.out.println("Got: "+word);
        word = word.toLowerCase().trim();

        char[] arr = word.toCharArray();
        if(arr.length > 0 && (arr[word.length()-1] == '.' || arr[word.length()-1] == ',')) {
            word = word.substring(0,word.length()-1);
        }
        System.out.println("Returning: "+word);
        return word;
    }
}
