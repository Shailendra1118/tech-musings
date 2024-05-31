package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.endpoint.web.Link;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int[] arr = new int[10];
        for(int i=0; i<3; i++){
            System.out.println(arr[i]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //pq.addAll(Arrays.asList(arr));
        //arr = new int[]{3, 2, 1, 5, 6}; this is compilation error, initialization is only allow when
        // declaring arr = new int[]{.....}
        arr = new int[]{3,2,1,5,6};
        List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
        pq.addAll(list);
        System.out.println(pq.poll());

        PriorityQueue<String> heap = new PriorityQueue<>();
        heap.offer("Shailendra");
        heap.offer("Yadav");
        heap.offer("Yadav");
        heap.stream().forEach(s-> System.out.println(s));
        System.out.println(Arrays.toString(heap.toArray()));
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

    @Test
    public void topKFrequentWord() {
        PriorityQueue<Word> mxHeap = //new PriorityQueue<>((w1,w2) -> w2.count - w1.count);
                new PriorityQueue<>((w1, w2) -> (w2.count < w1.count) ? -1 : ((w2.count == w1.count) ? w1.value.compareTo(w2.value) : 1));
        //(x < y) ? -1 : ((x == y) ? 0 : 1)
        //Integer v = new Integer(10);
        //System.out.println(v.compareTo(11));
        String[] words = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};

        Map<String, Integer> fMap = new HashMap<>();
        for(String str : words) {
            fMap.put(str, fMap.getOrDefault(str, 1)+1);
        }
        fMap.entrySet().forEach(e -> mxHeap.offer(new Word(e.getKey(), e.getValue())));
        int k = 4;
        List<String> res = new ArrayList<>();
        while (k > 0 ) {
            res.add(mxHeap.poll().value);
            k--;
        }

        System.out.println(res);
    }

    class Word{
        String value;
        int count;
        public Word(String value, int count) {
            this.value = value;
            this.count = count;
        }
        public String toString() {
            return this.value+":"+this.count;
        }
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

    @Test
    public void testLL() {
        Deque<Character> stack = new LinkedList<>();
        stack.push('A');
        StringBuilder sb = new StringBuilder();
        sb.append('A');
        sb.append('B');
        sb.append('Z');
        System.out.println(sb);
        sb.setLength(0);
        System.out.println(sb);

    }

    @Test
    public void testUnixFileSys() {
        String input = "/home/user/Documents/../Pictures";
        input = "/.../a/../b/c/../d/./";
        //input =  "/home//foo/";
        //input = "/../";
        input = "/a/../../b/../c//.//";
        input = "/a//b////c/d//././/..";
        Deque<String> stack = new LinkedList<>();
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chars.length; i++) {
            char cur = chars[i];
            if (cur == '/' && !stack.isEmpty()) {
                //case to check top-most values
                while (!stack.isEmpty() && !stack.peek().equals("/")) {
                    sb.append(stack.pop());
                }
                String word = sb.toString();
                sb.setLength(0);
                if (word.equals("..")) {
                    stack.pop(); //remove last '/'
                    if (stack.isEmpty()) {
                        //after removing /
                        stack.push("/");
                    }
                    while(!stack.isEmpty() && !stack.peek().equals("/")) {
                        stack.pop();
                    }
                } else if (! (word.equals(".") || word.equals(""))){
                    stack.push(word);
                    stack.push("/");
                }
            } else {
                stack.push(cur+"");
            }
        }

        if (stack.peek() == "/") {
            stack.pop();
        }
//        if (stack.isEmpty()) {
//            stack.push("/");
//        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());

    }
}
