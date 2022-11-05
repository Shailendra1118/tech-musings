package com.sports.rafael.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,4}, {0,0}}; // {8,10}, {15,18}};
        MergeIntervals obj = new MergeIntervals();
        int[][] res = obj.mergeOne(intervals);
        System.out.println(Arrays.deepToString(res));
    }

    public int[][] merge(int[][] intervals) {

        //assuming intervals are sorted with start-i
        int size = intervals.length;
        int[][] result = new int[size][2];

        int index = 0;
        result[0] = intervals[0];
        System.out.println("Result first: "+ Arrays.deepToString(result));
        for(int i=1; i<intervals.length; i++){
            if(result[index][1] >= intervals[i][0]){
                result[index] = new int[]{result[index][0], Math.max(result[index][1], intervals[i][1])};
                //index++;
                //i++;
            }else{
                index++;
                result[index] = intervals[i];
            }
            System.out.println("Result at "+i+"th: "+ Arrays.deepToString(result));
        }
        return result;

    }

    public int[][] mergeOne(int[][] intervals) {
        //assuming intervals are sorted with start-i
        int size = intervals.length;
        int[][] result = new int[size][2];
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.valueOf(a[0]).compareTo(b[0]));

        int index = 0;
        //result[0] = intervals[0];
        list.add(intervals[0]);
        System.out.println("List first: "+ list);
        for(int i=1; i<intervals.length; i++){
            if(list.get(index)[1] >= intervals[i][0]){
                list.set(index, new int[]{list.get(index)[0], Math.max(list.get(index)[1], intervals[i][1])});
                //index++;
                //i++;
            }else{
                index++;
                //result[index] = intervals[i];
                list.add(intervals[i]);
            }
            //System.out.println("Result at "+i+"th: "+ Arrays.deepToString(result));
        }
        result = list.toArray(value -> new int[0][0]);
        return result;


    }
}
