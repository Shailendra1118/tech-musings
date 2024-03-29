package com.sports.rafael;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BasicOne {

    @Test
    public void sbTester() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello World!");
        sb.append("<br/>");
        System.out.println(sb);

        int a = 10;
        int b = 20;
        char ch = '*';
        System.out.println(a);
        LinkedList<Integer> list = new LinkedList<>();


    }
    @Test
    public void arrayIt() {
        char arr[] = {'a', 'b'};
        System.out.println(arr.length);
    }

    @Test
    public void largestNum() {
        int arr[] = {1,2,3,4};
        permute(arr, 0, 3);
    }

    private void permute(int[] arr, int left, int right) {
        if (left == right) {
            System.out.println("Got it");
            System.out.println(Arrays.toString(arr));
        } else {
            for(int i=left; i<right; i++) {
                swap(arr, left, i);
                permute(arr, left+1, right);
                swap(arr, left, i);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void forLoop() {
        String temp = "This is Sparta!";
        String arr[]  = temp.split(" ");
        for(String s : arr){
            System.out.println(s);
        }
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void divide() {
        int a = 1;
        int b = 2;
        System.out.println(a/b);
        System.out.println(a%b);
    }

    @Test
    public void listForEach() {
        List<Integer> list = new ArrayList<>();
        for(int i : list) {
            System.out.println("i: "+i);
        }
    }

    @Test void testArrayTwoD() {
        Integer[] arr = new Integer[2];
        Integer[] arr2 = {1,2};
        LinkedList<Integer[]> ll = new LinkedList<>();
        ll.add(new Integer[]{100, 200});

        Object intArray = Array.newInstance(Integer.class, 5);
        String[] intArray2 = new String[5];
        intArray2[0] = "Shailendra";
        System.out.println(intArray2.getClass().getCanonicalName());
        System.out.println(intArray.getClass().getCanonicalName());


        List list = new ArrayList();
        list.add(Integer.valueOf(10));
        Integer val = (Integer)list.get(0);
        System.out.println("Value: "+val);

        list.stream().forEach(i-> {
            i = (Integer)i+10;
            System.out.println("Stream: "+i);
        });


    }


    @Test
    public void testLinkedList() {
        List<Integer> list = new ArrayList<>();
        list.add(199); // need to populate, otherwise to Array will be empty without any allocation
        list.add(299);
        list.add(399);
        Integer[] arr = list.toArray(new Integer[0]);
        int len = arr.length;
        System.out.println("Array len: "+len);
//        arr[0] = 199;
//        arr[1] = 299;
//        arr[2] = 399;

        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        for(int i=1; i<arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            prev.next = node;
            prev = node;
        }

        //print linkedlist
        while(head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println("null");

    }

    public class ListNode {
          int val;
          ListNode next;
          public ListNode() {}
          public ListNode(int val) { this.val = val; }
          public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    @Test
    public void testCharArray() {
          Stack<Character> stack = new Stack<>();
          stack.push('c');
          char c = 'c';
          System.out.println(stack.peek() == c);
          Deque<Character> deq = new LinkedList<>();
          deq.push('c');
          deq.push('d');
          deq.push('e');
          System.out.println(deq.getFirst());
    }

    @Test
    public void recurseNestedList() {
        String temp = "This is Sparta!";
        String arr[]  = temp.split(" ");
        for(String s : arr){
            System.out.println(s);
        }
        System.out.println(Arrays.toString(arr));
        Map<Integer,Integer> map = new TreeMap<>();
        map.getOrDefault(100,0);
    }


    @Test
    public void testPalindromicString() {
        String input = "madam";
        System.out.println(isPalindrome(input, 0));
    }

    private boolean isPalindrome(String input, int start) {
        if(start >=input.length()/2)
            return true; //if it reaches till here that means all is good
        if(input.charAt(start) != input.charAt(input.length()-start-1))
            return false;
        return isPalindrome(input, start+1); //NOT start++ ie. start = start+1
    }

    @Test
    public void testCollectionSwap() {
        int[] nums = {1,2,3,4,5};
        List<Integer> list =
                Arrays.stream(nums).mapToObj(i->i).collect(Collectors.toList());
        System.out.println(list);

    }

}
