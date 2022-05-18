package com.sports.rafael.datas;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUTest {


    @Test
    public void basic() {
            LinkedList<Integer> list = new LinkedList<>();
            //Iterator<Integer> iter = list.iterator();
            //Integer curr = iter.next();
            //int res = list.get(curr);
            int arr[][] = {{1,2,3,4}, {4, 9,5,6,7}};
            for(int[] temp : arr) {
                System.out.println(Arrays.toString(temp));
                int[] temp1 = Arrays.copyOfRange(temp, 2, 3);
                System.out.println(Arrays.toString(temp1));
            }

    }

    @Test
    public void testHE() {
            // Write your code here
            int[] A = {2,4,-2,-2,3,7};
            int[][] queries = {{1,4,6}, {2,3,5},{1,2,3}};

            long[] result = new long[queries[0].length];

            int resIndex = 0;
            for(int[] arr : queries) {
                int gap = arr[0];
                int start = arr[1];
                int end = arr[2];
                int[] temp = Arrays.copyOfRange(A, start-1, end);
                Arrays.sort(temp);
                int i = 0;
                while(i<temp.length-gap) {
                    i++;
                }
                long prod = 1;
                i--;
                while(i<temp.length){
                    prod = prod * temp[i];
                    i++;
                }
                result[resIndex++] = prod;
            }

            for(int x=0; x<4; x++) System.out.println("after inline forloop");
                System.out.println("adslkjasdf");
            System.out.println(Arrays.toString(result));



    }

    @Test
    public void testLRU() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.put(4, "Four");
        cache.get(2);

        System.out.println("Size:"+cache.size());
        cache.display();
    }

    @Test
    public void testXLRU() {
        XLRUCache cache = new XLRUCache(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.put(4, "Four");
        cache.get(2);
        cache.get(3);

        System.out.println("Size:"+cache.size());
        cache.display();
    }
}
