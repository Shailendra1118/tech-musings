package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class KSmallestInSortedMatrix {

    @Test
    public void testMatrix() {
        int[][] mat = {{1,5,9}, {10,11,13}, {12,13,15}};
        int K = 8;
        int res = kthSmallest(mat, K);
        System.out.println(res);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        Queue<Node> minHeap = new PriorityQueue<>(Math.min(rows, k));

        //fill till min of first item from rows
        for(int r=0; r <Math.min(rows, k); r++) {
            minHeap.offer(new Node(matrix[r][0], r, 0));
        }

        Node top = minHeap.peek();
        while(k > 0) {
            top = minHeap.poll();
            int row = top.row;
            int col = top.col;
            if(col+1 < rows) {
                minHeap.offer(new Node(matrix[row][col+1], row, col+1));
            }
            k--;
        }
        return top.val;
    }

    class Node implements Comparable<Node>{
        int val;
        int row;
        int col;

        public Node(int val, int r, int c) {
            this.val = val;
            this.row = r;
            this.col = c;
        }

        public int compareTo(Node node) {
            return Integer.compare(this.val, node.val);
        }
    }
}
