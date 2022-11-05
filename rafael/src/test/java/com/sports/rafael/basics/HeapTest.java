package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class HeapTest {

    @Test
    public void duplicateTest() {
        PriorityQueue<Pair<Integer>> heap =
                new PriorityQueue<>((a,b) -> Integer.valueOf(b.val) - a.val);

        PriorityQueue<Map.Entry<Integer, Integer>> pq
                = new PriorityQueue<>((a,b) ->  b.getValue() - a.getValue());

        heap.add(new Pair(1,3));
        heap.add(new Pair(2,2));
        heap.add(new Pair(1,2));

        Map<Integer,Integer> map = new HashMap<>();
        map.put(2,6666);
        map.put(77,6666);
        map.put(3,6666);
        map.put(75,6666);
        map.entrySet().forEach(e -> pq.add(e));
        System.out.println(pq);


    }

    class Pair<T>{
        public T freq;
        public T val;
        public Pair(T freq, T val){
            this.freq = freq;
            this.val = val;
        }
        public String toString(){
            return this.freq+":"+this.val;
        }
    }


    @Test
    public void testLinkedHashMap() {
        Map<Character,Integer> map = new HashMap<>();
        map.put('c',10);
        map.put('d',3);
        Map<Character,Integer> sorted = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldV,newV) -> oldV, LinkedHashMap::new));
        System.out.println(sorted);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> e : sorted.entrySet()){
            int counter = e.getValue().intValue();
            for(int i=counter; i>0; i--){
                sb.append(e.getKey());
            }
        }

    }

    @Test
    public void testArray() {
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            System.out.println(arr[i]);
        }
    }


    @Test
    public void testStream() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(4);

        int res = list.stream().filter(n -> n%2 !=0).map(n -> n*n).reduce((a,b) -> a+b).get();
        System.out.println(res);

    }

    final class XImmutable {
        private int id;
        private final String name;
        //private final Employee emp;
        public XImmutable(String name){
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * Employee - name, age , city - Find employee who has same name and age --> duplicat?
     * select * from Employee e1 left outer join Employee e2 on e1.name = e2.name where e1.age = e2.age;
     */

}
