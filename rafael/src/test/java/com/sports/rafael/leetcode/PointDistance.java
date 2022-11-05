package com.sports.rafael.leetcode;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PointDistance {
    public static void main(String[] args) {
        PointDistance obj = new PointDistance();
        //int[][] input = {{3,3}, {5,-1}, {-2,4}};
        int[][] input = {{2,10},{-9,-9},{0,8},{-2,-2},{8,9},{-10,-7},{-5,2},{-4,-9}};
        int[][] res = obj.kClosest(input, 7);
        System.out.println(Arrays.deepToString(res));
    }

    private int getDistanceFromOrigin(Point x){
        int xPart = (x.x-0)*(x.x-0);
        int yPart = (x.y-0)*(x.y-0);
        double res = Math.sqrt(xPart+yPart);
        System.out.println("Dist for origin for point: "+x+" is: "+res);
        return (int)res;
    }

    class Point{
        int x;
        int y;
        double distFromOrigin;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "("+x+","+y+"):"+distFromOrigin;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> heap = new PriorityQueue<>(Comparator.comparingDouble(o -> o.distFromOrigin));
        //Point origin = new Point(0, 0);
        for(int i=0; i<points.length; i++){
            Point point = new Point(points[i][0], points[i][1]);
            int dist = getDistanceFromOrigin(point);
            point.distFromOrigin = dist;
            heap.offer(point);
        }

        int[][] res = new int[k][];
        for(int i=0; i<k; i++){
            Point p = heap.remove();
            res[i] = new int[]{p.x,p.y};
        }
        return res;
    }
}
