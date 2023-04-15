package com.sports.rafael.basics.java;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class Core {

    @Test
    public void testIterator() {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder sb1 = new StringBuilder("Java");
        StringBuilder sb2 = new StringBuilder("Python");
        StringBuilder sb3 = new StringBuilder("Scala");
        StringBuilder sb4 = new StringBuilder("Angular");
        list.add(sb1);
        list.add(sb2);
        list.add(sb3);
        list.add(sb4);
        list.remove(1);

        //for(StringBuilder sb : list) {
        //    System.out.println(sb);
            //list.remove(sb3); // ConcurrentModificationException
        //}
        for(StringBuilder sb : list)
            System.out.println(sb);
        list.remove(sb3);
        list.remove(new StringBuilder("Angular"));

        System.out.println("-----");
        for(StringBuilder sb : list)
            System.out.println(sb);

    }


    @Test
    public void nullCheck() {

        System.out.println(testMethod("Shailendra"));
        System.out.println(testMethod("Singh"));
        System.out.println(testMethod(null));

        //Unary operator
        int i = 10;
        testMethod1(i++);
        System.out.println("i after the call: "+i);

        System.out.println("Pre-increment ---");
        testMethod1(++i);
        System.out.println("i after the call: "+i);

        int j = 100;
        System.out.println("From testMethod2:"+ testMethod2(j++));

    }

    private boolean testMethod(String str) {
        try{
            return str.length() > 5;
        }catch(NullPointerException npe) {
            System.out.println("NPE !!");
            return false;
        }
    }

    private void testMethod1(int i) {
        System.out.println("Got i: "+i);

    }

    private int testMethod2(int i) {
        System.out.println("testMethod2: "+i);
        return i++;
    }


    @Test
    public void checkMaps() {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        map1.put('c', 1);
        map1.put('d', 2);

        map2.put('c', 1);
        map2.put('d', 2);
        String str = "Shailendra";
        for(char ch : str.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        System.out.println(map2);
        System.out.println(map1.equals(map2));

        int arr1[] = new int[10];
        int arr2[] = new int[10];
        System.out.println("Array equal....");
        arr1[0] = 1;
        arr1[1] = 2;
        arr2[0] = 1;
        arr2[1] = 3;
        System.out.println(arr1.equals(arr2));
        System.out.println(matches(arr1, arr2));


    }

    private boolean matches(int s1Map[], int s2Map[]) {
        for(int i=0; i<s1Map.length; i++) {
            if(s1Map[i] != s2Map[i])
                return false;
        }
        return true;
    }

    @Test
    public void twoDArray() {
        int intervals[][] = {{1,4}, {3,6}, {2,8}};
        System.out.println(intervals[0][0]);
        //Integer[] intObj = Arrays.stream(interval).boxed().toArray(Integer[] :: new);
        //intObj = IntStream.of(interval).boxed().toArray(Integer[] :: new);

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] < b[0]) {
                return -1;
            }else if(a[0] > b[0])
                return +1;
            else
                return 0;
        });
        for(int arr[] : intervals)
            System.out.println(Arrays.toString(arr));

        int updated = 0;
        for(int i=0; i<intervals.length-1; i++) {
            if(intervals[i+1][1] <= intervals[i][1]) {
                updated++;
                intervals[i+1][1] = intervals[i][1];
                intervals[i+1][0] = intervals[i][0];
            }
        }
        System.out.println("Updated :: "+updated);
    }

    @Test
    public void weeklyTest() {
        Character d = Character.valueOf('d');
        Character a = Character.valueOf('a');
        int res = a.compareTo(d);
        System.out.println(res);
        char c = 'a';
        String roes = String.valueOf('a');

    }

    @Test
    public void testMod() {
        //System.out.println(0%0); Divide by Zero ArithmaticException
        Map<String,String> map = Map.ofEntries(java.util.Map.entry("Shailendra", "Yadav"),
                java.util.Map.entry("Aman", "Chugh"));
        System.out.println(map);

        Map<String,Integer> map1 = Map.of("Shailendra", 100, "Aman", 98);
        System.out.println(map1);
    }

    @Test
    public void testArrayInit() {
        //System.out.println(new[] String{"1","2"});
        System.out.println(new String[]{"1","2"}); //bracket should come just before {} braces
    }

    @Test
    public void testSplit() {
        String input = "string";
        List<String> list = Arrays.stream(input.split("")).collect(Collectors.toList());
        //System.out.println(Arrays.toString(arr));
        System.out.println(list);
    }


    @Test
    public void testPhoneNumberCombo() {
        String digits = "";
        Map<String, List<String>> map = new HashMap<>();
        map.put("1", List.of(""));
        map.put("2", List.of("a","b","c"));
        map.put("3", List.of("d","e","f"));
        map.put("4", List.of("g","h","i"));
        map.put("5", List.of("j","k","l"));
        map.put("6", List.of("m","n","o"));
        map.put("7", List.of("p","q","r","s"));
        map.put("8", List.of("t","u","v"));
        map.put("9", List.of("w","x","y","z"));

        String[] input = digits.split("");
        if(input.length == 0)
            System.out.println(new ArrayList<>());

        System.out.println(Arrays.toString(input));
        List<List<String>> list = new ArrayList<>();
        for(int i=0; i<input.length; i++) {
            list.add(map.get(input[i]));
        }

        List<String> temp = new ArrayList<>();
        temp = list.get(0);
        int idx = 1;
        while(idx < input.length) {

            List<String> list1 = temp;
            List<String> list2 = list.get(idx);

            //create collection
            List<String> mergedList = new ArrayList<>();
            for(int i=0; i<list1.size(); i++) {
                for(int j=0; j<list2.size(); j++) {
                    mergedList.add(list1.get(i)+list2.get(j));
                }
            }
            temp = mergedList;
            idx++;
        }
        System.out.println(temp);
    }

    @Test
    public void testRandom() {
        System.out.println("Hello Random");
        int min = 50; // Minimum value of range
        int max = 100; // Maximum value of range
        int random_int = (int)(Math.random() * (max - min + 1) + min);
        // Printing the generated random numbers
        System.out.println(random_int);



        Set<Integer> set = new HashSet<>();
        set.add(100);
        set.add(240);
        set.add(9);
        System.out.println(set.toString());

        Random random = new Random();
        int val = random.nextInt(set.size());
        System.out.println("Random Nxt Ind: "+val);

        int count = 0;
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            int setVal = iter.next();
            if(count == val) {
                System.out.println("Found:" +setVal);
                break;
            }
            count++;
        }
    }

    @Test
    public void testArray() {
        int[][] arr = new int[2][2];
        arr[1][0] = 500;
        arr[1][1] = 5;

        arr[0][0] = 800;
        arr[0][1] = 8;
        //Arrays.sort(arr, (a,b) -> Integer.valueOf(a[0]).compareTo(b[0]));
        Arrays.sort(arr, (a,b) -> Integer.compare(b[0], a[0]));
        //Comparator.compareInt(a -> a[0]) works for ascending order only
        System.out.println(Arrays.deepToString(arr));

        int[][] sorted =
                Arrays.stream(arr).sorted((a,b) -> Integer.valueOf(a[0]).compareTo(b[0]))
                        .toArray(int[][] :: new);
        //System.out.println(Arrays.deepToString(sorted));
    }
}
