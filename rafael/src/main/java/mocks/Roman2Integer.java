package mocks;

import java.util.HashMap;
import java.util.Map;

public class Roman2Integer {
    public static void main(String[] args) {

        Map<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        String s = "LVIII";
        char[] roman = s.toCharArray();
        int i=0, res = 0;
        while(i < roman.length) {
            if((i+1 < roman.length && map.get(roman[i]) >= map.get(roman[i+1])) || i == roman.length-1) {
                res = res + map.get(roman[i]);
            }else{
                res = res + (map.get(roman[i+1]) - map.get(roman[i]));
                i++;
            }
            i++;
        }

        System.out.println("RES: "+res);

    }
}
