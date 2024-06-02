package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CourseSchedule2 {

    @Test
    public void testBFS() {
       int numCourses = 2;
       int[][] preq = {{0,1}}; //{{1,0}, {2,0}, {3,1}, {3,2}};
       int res[] = findOrder(numCourses, preq);
        System.out.println("RES"+ Arrays.toString(res));

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Topological sort BFS
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        Map<Integer,Set<Integer>> adjList = new HashMap<>();

        for (int[] path : prerequisites) {
            if (adjList.get(path[1]) == null) {
                adjList.put(path[1], new HashSet<>());
            }
            adjList.get(path[1]).add(path[0]);
        }

        for (Set<Integer> set : adjList.values()) {
            for (Integer n : set) {
                indegree[n]++;
            }
        }

        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (adjList.get(course) != null) {
                for (int n : adjList.get(course)) {
                    indegree[n]--;
                    if (indegree[n] == 0) {
                        queue.offer(n);
                    }
                }
            }
            res.add(course);
        }

        if (res.size() < numCourses) {
            return new int[]{};
        }
        return res.stream().mapToInt(n -> n).toArray();

    }
}
