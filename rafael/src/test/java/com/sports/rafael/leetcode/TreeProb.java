package com.sports.rafael.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeProb {

    static class TreeNode{
        int val;
        int color;
        TreeNode(int val, int c){
            this.val = val;
            this.color = c;
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int edges[][] = {{3,2},{3,1},{2,4},{2,5}};
        int color[] = {1,1,2,2,1};
        int Q = 5;
        int queries[] = {2,4,5,1};
        int res[] = solve(N, edges, color, Q, queries );
        System.out.println(Arrays.toString(res));
    }

    static void addEdge(List<List<TreeNode>> tree, int u, int v, int color[]){
        tree.get(u-1).add(new TreeNode(v, color[v-1]));
        tree.get(v-1).add(new TreeNode(u, color[u-1]));
    }

    static int[] solve(int N, int[][] edges, int[] color, int Q, int[] queries){


        // Write your code here
        List<List<TreeNode>> tree = new ArrayList<>();

        for(int i=0; i<N; i++){
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(i+1, color[i]));
            tree.add(list);
        }
        for(int i=0; i<edges.length; i++){
            addEdge(tree, edges[i][0], edges[i][1], color);
        }

        //queries
        int totalMarked = 0;
        boolean marked[] = new boolean[N];
        int res[] = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int curMarked = 0;
            int q = queries[i];
            if(!marked[q-1]) {
                marked[q-1] = true;
                curMarked++;
            }
            List<TreeNode> nodeList = tree.get(q-1);
            int col = nodeList.get(0).color;
            for(int j=1; j<nodeList.size(); j++){
                if(nodeList.get(j).color == col){
                    if(! marked[nodeList.get(j).val-1]) {
                        marked[nodeList.get(j).val-1] = true;
                        curMarked++;
                    }
                }
            }

            totalMarked += curMarked;
            res[i] = totalMarked;
        }

        return res;
    }
}


