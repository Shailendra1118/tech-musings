package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

    @Test
    public void testCourses() {
        int courses = 20;
        int[][]prerequisites = //{{1,0},{0,1}};
                {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        boolean res = canFinish(courses, prerequisites);
        System.out.println("RES: "+res);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //base case
        if (numCourses == 1) {
            return true;
        }
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            adj.put(i, new HashSet<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            int[] path = prerequisites[i];
            adj.get(path[1]).add(path[0]);
        }

        adj.entrySet().forEach(e -> System.out.println(e.getKey()+":"+e.getValue()));

        int[] visited = new int[numCourses]; //default fills with 0
        int[] pathVisited = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            if (visited[i] == 0) {
                //not visited
                if (cycleDetected(i, adj, visited, pathVisited)) {
                    //cycle detected so can't finish all courses
                    System.out.println("Cycle detected..");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean cycleDetected(int course, Map<Integer,Set<Integer>> adj, int[] visited, int[] pathVisited) {
        visited[course] = 1;
        pathVisited[course] = 1;

        //traverse adjacent node
        for (int neighbour : adj.get(course)) {
            if (visited[neighbour] == 0) {
                //dfs
                if (cycleDetected(neighbour, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[neighbour] == 1) {
                // path is visited && node is visited
                return true;
            }
        }

        //undo pathVisited
        pathVisited[course] = 0;
        return false;
    }
}
