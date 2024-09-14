package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CriticalConnections {

    @Test
    void testReturnCriticalConnection() {

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] arr = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>(); // # could be array ([]) of arraylist
        //create adjacency list
        for (int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(List<Integer> edge : connections) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
            // if (graph.get(connections.get(0)) != null) {
            //     graph.put(connections.get(0), con)
            // }
            // graph.get(connections.get(0)).add(connections.get(1));
            // graph.put(i, new ArrayList<>());
        }
        //int i = 0;
        // for(List<Integer> connection : connections) {
        //     //graph.put(Arrays.asList(connection.get(0),connection.get(1)));
        //     graph.put(connection.get(0), Arrays.asList(connection.get(0),connection.get(1)));
        //     graph.add(Arrays.asList(connection.get(1),connection.get(0)));
        //     //graph[connection.get(1)].add(connection.get(0));
        // }

        //this will be return as result, having only critical edges
        Map<Integer, List<Integer>> connectionSet = new HashMap<>();
        connectionSet.putAll(graph);
        int[] rank = new int[n];

        //if a node is not visited yet, it has a special rank -2;
        //if we've fully completed the visit of a node, it has a special rank n
        // nodes that we've started visiting, but haven't finished visiting, have ranks. So 0 <= rank < n.
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, connectionSet);
        return new ArrayList<>(connectionSet.values());


    }

    private int dfs(Map<Integer,List<Integer>> graph, int node, int depth, int[] rank,
                    Map<Integer,List<Integer>> connectionSet) {
        if (rank[node] >= 0) {
            //visiting 0 <= rank < n
            //visited rank = n
            return rank[node];
        }
        rank[node] = depth;
        int minDepthTotal = depth;
        for (Integer neighbour : graph.get(node)) {
            if (rank[neighbour] == depth-1) {
                //parent node
                continue;
            }
            int minDepth = dfs(graph, neighbour, depth+1, rank, connectionSet);
            if (minDepth <= depth) {
                //remove edge
                connectionSet.remove(Arrays.asList(node, neighbour));
                connectionSet.remove(Arrays.asList(neighbour, node));
            }
            minDepthTotal = Math.min(minDepth, minDepthTotal);
        }

        return minDepthTotal;
    }
}
