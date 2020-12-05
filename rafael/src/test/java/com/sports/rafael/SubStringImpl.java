package com.sports.rafael;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubStringImpl {
    public static void main(String[] args) {
        String input = "HelloFresh";
        String res = getSubString(input, 3, 6);
        System.out.println("Res: "+res);
    }

    public static String getSubString(String input, int start, int end) {
        char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=start-1; i<end-1; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }


    @Test
    public void testSubList() {
        List<String> l1 = Arrays.asList("Shailendra", "Aman", "Sumiran", "Shailendra", "Sumiran", "Ashish","Sumiran","Shailendra", "Vinayak");
        List<String> l2 = Arrays.asList("Sumiran", "Shailendra", "Vinayak");

        if(isSubList(l1, l2)) {
            System.out.println("Yes");
        }else
            System.out.println("No");

        assertTrue(isSubList(l2, l1));
    }

    private boolean isSubList(List<String> l1, List<String> l2) {
        List<String> longerList = l1.size() > l2.size() ? l1 : l2;
        List<String> shorterList = l1.size() < l2.size() ? l1 : l2;
        int i = 0, j =0;
        boolean started = false;
        for(; i<longerList.size();){
            String cur = longerList.get(i);
            for(; j<shorterList.size();){
                if(cur.equals(shorterList.get(j))) {
                    if(!started){
                        started = true;
                    }
                    i++;
                    j++;
                }else{
                    //not equal
                    if(started){
                        started = false;
                        j=0;
                    }
                    i++;
                }
                // break in both cases
                break;
            }
        }
        return started;
    }
}
