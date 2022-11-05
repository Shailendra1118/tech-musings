package com.sports.rafael.basics.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CoreOne {

    @Test
    public void testLinkedHM() {
        Map<Integer, Integer> map = new LinkedHashMap<>(10, 0.75f, true);
        map.put(1,200);
        map.put(3,100);
        map.put(3, 200);
        map.get(1);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" :: "+entry.getValue());
        }

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(100);

        Stack<Integer> stk = new Stack<>();
        stk.add(100);
        System.out.println(stk);
    }

    @Test
    public void testHMap() {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(500,5);
        map.put(30,4);
        map.put(11,2);
        map.put(244,2);

        List<Map.Entry<Integer,Integer>> sortedByValue =
                map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(sortedByValue);
    }

    @Test
    public void testTree() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(100);
        queue.add(200);
        queue.add(400);
        queue.remove(); //removeFirst
        System.out.println(queue);
        queue.element();

        Set<Integer> tree = new TreeSet<>();
        tree.add(100);
        tree.add(90);
        tree.add(200);
        System.out.println(tree);
        tree.remove(90);
        System.out.println("Post removal: "+tree);

    }

    @Test
    public void testLinkedList() {
        List<Integer> list = new LinkedList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.remove(1);
        list.remove(Integer.valueOf(300));
        System.out.println(list);


        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(100); //same as queue, add from the tail, addLast(x)
        ll.addFirst(200);
        ll.addLast(300);
        System.out.println(ll);

        Deque<Integer> deq = new LinkedList<>();

    }


    @Test
    public void testStreamFilter() {
        int nums[] = {2,2,3,3,3,4};
        int toCompare = nums[2];

        int updatedNums[] = Arrays.stream(nums).filter(x -> Math.abs(x-nums[5])!=1).toArray();
        System.out.println(Arrays.toString(updatedNums));

        Queue<Integer> que = new LinkedList<>();
        que.add(10);
        que.add(20);
        int a = 0;
        for(int i : que) {
            System.out.println(i);
            //que.poll();
            a += 10;  // =+ is not valid
            System.out.println("sdf+ "+a);
        }

        int zero = -0;
        StringBuilder sb= new StringBuilder();
        sb.append("34");
        sb.append("23");
        System.out.println(Integer.valueOf(sb.reverse().toString()));
    }


    @Test
    public void testCents() {
        String amount = "$1923";
        String withoutDollar = amount.substring(1);
        System.out.println(withoutDollar);
        String[] arr = withoutDollar.split("\\.");
        System.out.println(Arrays.toString(arr));
       System.out.println(arr[1]);

    }

    @Test
    public void testConversion() {
        String str = "234";
        int d = str.charAt(0)-'0';
        System.out.println(str.charAt(0));
        System.out.println(d);

        "ABC".chars().mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.toList()).forEach(list -> System.out.println(list));

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        "234".chars().mapToObj(c -> Integer.valueOf(c-'0'))
                .map(n -> map.get(n))
                .collect(Collectors.toList()).forEach(list -> System.out.println(list));

    }


    @Test
    public void testStack(){
        Stack<Integer> stck = new Stack<>();
        //stck.pop();
        boolean isNumeric = "-1".chars().allMatch( Character::isDigit );
        System.out.println(isNumeric);
        int[][] arr = new int[10][10];
        System.out.println(Arrays.deepToString(arr));

        String str = "1A";
        int val = str.charAt(0)-'0';
        System.out.println(val);

        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        Integer[] arrInt = list.toArray(new Integer[0]);
        int[] intArr = Arrays.stream(arrInt).mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(intArr));
    }

    @Test
    public void testIntHex() {
        int a = 10;
        long unsignedValue = a & 0xffffffffL;
        System.out.println("unsignedValue: "+unsignedValue);
    }


    @Test
    public void testNums() {
        int input[] = {3,1,2,3,6,4};
        int[] res = findCorruptPair(input);
        System.out.println(Arrays.toString(res));
    }

    public int[] findCorruptPair(int[] nums) {

        // Write your code here

        int[] temp = new int[nums.length+1];
        int duplicate = -1;

        for(int i=0; i<nums.length; i++) {
            if(temp[i] != 0 && temp[nums[i]] != i) {
                duplicate = nums[i];
                break;
            }else{
                temp[nums[i]-1] = nums[i];
            }
        }

        int missing = -1;
        for(int i=1; i<nums.length; i++) {
            if(temp[i] == 0)
                missing = i;
        }


        return new int[]{missing, duplicate};
    }

}
