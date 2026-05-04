package com.sports.rafael.datas;

import java.util.LinkedHashMap;
import java.util.Map;

public class JLRU {
    public static void main(String[] args) {
        LinkedHashMap<String, String> cache = new LinkedHashMap(2, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 2;
                //return super.removeEldestEntry(eldest);
            }
        };

        cache.put("one", "1");
        cache.put("two", "2");
        cache.put("3", "three");

        System.out.println(cache);
    }
}

