package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class FleetCars {

    @Test
    public void testDivide() {
        double a = 5;
        double b = 2;
        System.out.println(a/b);
        System.out.println(a%b);
    }

    @Test
    public void testFleets() {
        int target = 10;
        int[] position = {6,8};
        int[] speed = {3,2};
        int res = carFleet(target, position, speed);
        System.out.println(res);
    }


    public int carFleet(int target, int[] position, int[] speed) {
        //greedy approach
        // sort the cars according to closer to destination
        int[][] cars = new int[position.length][2];
        for(int i=0; i<position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b)-> Integer.compare(b[0], a[0]));
        System.out.println(Arrays.deepToString(cars));

        Stack<Double> stack = new Stack<>();
        for(int i=0; i<cars.length; i++) {
            int dist = (target-cars[i][0]);
            double newVal = 0;
            if(! stack.isEmpty()) {
                newVal = dist/cars[i][1];
                if(stack.peek() < newVal) {
                    //greater means, arriving late
                    stack.push(newVal);
                }
            }else{
                stack.push(newVal);
            }

        }
        return stack.size();
    }

}


