package com.sports.rafael.basics;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CheckArrays {

    @Test
    public void testFormat() {
        List<Integer> list = new ArrayList<>(26);
        //list.forEach(i -> list.set(i, 0));
        //Collections.fill(list, 0);
        for (int i=0; i<25; i++) {
            list.add(0);
        }
        String msg = "123(3)";
        char[] arr = msg.toCharArray();
        char ch = arr[1];
        System.out.println(ch);
        char times = arr[4];
        list.set((ch-48), times-'0');
        System.out.println(list);
    }

    @Test
    public void test2DArrays() {
        int[][] arr = {{1,3}, {-2,2}};

        int temp[] = arr[0];
        System.out.println(Arrays.toString(temp));

        Queue<Point> queue = new PriorityQueue<>(2, Comparator.comparingInt(o -> o.distFromOrigin));
        queue.offer(new Point(3,3, 87));
        queue.offer(new Point(5,-1, 3));
        queue.offer(new Point(-2,4, 48));
        //queue.offer(new Point(3,3));
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
    }

    class Point{
        int x;
        int y;
        int distFromOrigin;
        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.distFromOrigin = dist;
        }
        public String toString() {
            return "("+x+","+y+"):"+distFromOrigin;
        }
    }
}
