package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ReRouting {

    @Test
    public void findMin() {
        int[] connections = {2,3,4,1,5}; //{1,2,3,4};
        List<Integer> input = Arrays.stream(connections).boxed().collect(Collectors.toList());
        System.out.println(minChangeToTerminalServer(input));
    }

    private int minChangeToTerminalServer(List<Integer> connections) {
        //make it zero index
        int N = connections.size();
        connections.add(0, -1);

        int changes = 0;
        int terminalNode = -1;

        boolean[] visited = new boolean[N+1];
        //boolean[] inCycle = new boolean[N+1]; //keep track of if node is part of cycle
        List<Integer> cycleNodes = new ArrayList<>();

        //1. DFS to detect and mark cycles
        for (int i=1; i<N+1; i++) {
            if (!visited[i]) {
                detectCycle(connections, i, visited, new boolean[N+1], cycleNodes);
            }
        }

        //2. Find an existing terminal node if exists
        for (int i=1; i<N+1; i++) {
            if (connections.get(i) == i) {
                terminalNode = i;
                break;
            }
        }

        //3. If no terminal node exists, pick the first cycle node and make it a terminal
        if (terminalNode == -1 && !cycleNodes.isEmpty()) {
            terminalNode = cycleNodes.get(0);
            connections.set(terminalNode, terminalNode);
            changes++;  // We've made this node a terminal
        }

        //4. Break the cycle by pointing one cycle node to the terminal node
        for (int node : cycleNodes) {
            if (connections.get(node) != terminalNode) {
                connections.set(node, terminalNode);
                changes++;
                break;  // Only break one node to minimize changes
            }
        }


        // Ensure all non-terminal nodes point to the terminal
        for (int i = 1; i <N+1; i++) {
            if (connections.get(i) != terminalNode) {
                connections.set(i, terminalNode);
                changes++;
            }
        }

        return changes;
    }

    private void detectCycle(List<Integer> connections, int start, boolean[] visited, boolean[] currentPath, List<Integer> cycleNodes) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.peek();

            if (!visited[node]) {
                visited[node] = true;
                currentPath[node] = true;

                int next = connections.get(node);
                if (!visited[next]) {
                    stack.push(next);
                } else if (currentPath[next]) {
                    //cycle detected
                    int cycleStart = next;
                    while (!stack.isEmpty()) {
                        int cNode = stack.pop();
                        cycleNodes.add(cNode);
                        if (cNode  == cycleStart) {
                            break;
                        }
                    }
                }
            } else {
                // already visited
                currentPath[node] = false;
                stack.pop();
            }


        }
    }

//    private void markCycleNodes(List<Integer> connections, int cycleStart, boolean[] inCycle) {
//        int current = cycleStart;
//        do {
//            inCycle[current] = true;
//            current = connections.get(current);
//        } while (current != cycleStart);
//    }


}
