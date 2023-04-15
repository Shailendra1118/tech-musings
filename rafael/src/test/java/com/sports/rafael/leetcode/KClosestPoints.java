package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPoints {

    @Test
    public void testKClosestPoint() {
        int[][] points = {{1,3}, {-2,2}};
        int K = 1;
        int[][] res = kClosest(points, K);
        System.out.println(Arrays.deepToString(res));
    }

    public int[][] kClosest(int[][] points, int k) {
        //max heap
        Queue<PointD> distance = new PriorityQueue<>(
                (p1, p2) -> Integer.compare(p2.distToOrigin, p1.distToOrigin));
        for(int[] point : points) {
            PointD pointD = findDistToOrigin(point);
            distance.offer(pointD);
            if(distance.size() > k) {
                distance.poll();
            }
        }

        int kPoints = distance.size();
        int[][] res = new int[kPoints][];
        for(int i=0; i<kPoints; i++) {
            PointD point = distance.poll();
            res[i] = new int[]{point.x, point.y};
        }
        return res;

    }

    private PointD findDistToOrigin(int[] point) {
        int dist = point[0]*point[0] + point[1]*point[1]; //x^2 + y^2
        return new PointD(point[0], point[1], dist);
    }

    class PointD {
        int x=0;
        int y=0;
        int distToOrigin = 0;
        PointD(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distToOrigin = distance;
        }
    }
}
