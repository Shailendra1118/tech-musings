package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MHTs {

    @Test
    void findMinHeightTrees() {
        //TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        //map.put(1, map.getOrDefault(1, new ArrayList<>()).add(100));
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
                //{{0,1},{0,2},{0,3},{1,4},{2,5},{3,6}};

        List<Integer> res = findMinHeightTrees(n, edges);
        System.out.println("RES: "+res);

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] maxHeight = new int[1];
        boolean[] visited = new boolean[n];
        TreeMap<Integer,List<Integer>> resMap = new TreeMap<>();
        for (int i=0; i<n; i++) {
            //make each node the root
            maxHeight[0] = Integer.MIN_VALUE;
            visited[i] = true;
            dfs(graph, i, 0, visited, maxHeight);
            //reset visited
            Arrays.fill(visited, false);
            //minTillNow[0] = Integer.MAX_VALUE;
            if (!resMap.containsKey(maxHeight[0])) {
                resMap.put(maxHeight[0], new ArrayList<>());
            }
            resMap.get(maxHeight[0]).add(i);
        }
        resMap.entrySet().forEach(e -> System.out.println(e.getKey()+"::"+e.getValue()));
        return resMap.firstEntry().getValue();
    }

    private void dfs(Map<Integer, List<Integer>> graph, int root, int height, boolean[] visited, int[] maxHeight) {
        List<Integer> nodes = graph.get(root);
        for (int node : nodes) {
            if (visited[node]) {
                maxHeight[0] = Math.max(maxHeight[0], height);
                return;
            } else {
                visited[node] = true;
                dfs(graph, node, height+1, visited, maxHeight);
            }
        }
    }

    @Test
    void testBetterSolution() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(21);
        Integer i = 21;
        list.remove(i);
        System.out.println(list);
    }
}

