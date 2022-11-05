package com.sports.rafael;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerSorts {

    @Test
    public void testSort(){

        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        List<Interval> list = new ArrayList<>();
        for(int[] arr : intervals){
            list.add(new Interval(arr[0], arr[1]));
        }

        list = list.stream().sorted((x,y) -> Integer.valueOf(x.end).compareTo(y.end)).collect(Collectors.toList());
        System.out.println(list);
    }

    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        public String toString(){
            return "["+this.start+","+this.end+"]";
        }
    }
}
