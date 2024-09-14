package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ReRoutingGPT {

    @Test
    public void testGPTCode() {
        ArrayList<Integer> connections = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        System.out.println("Minimum changes required: " + minChangesToReachSingleServer(connections));
    }

    static class Tarjan {
        private final List<List<Integer>> graph;
        private final int[] index;
        private final int[] lowlink;
        private final boolean[] onStack;
        private final Stack<Integer> stack;
        private final List<List<Integer>> sccs;
        private int currentIndex;

        public Tarjan(List<List<Integer>> graph) {
            this.graph = graph;
            this.index = new int[graph.size()];
            this.lowlink = new int[graph.size()];
            this.onStack = new boolean[graph.size()];
            this.stack = new Stack<>();
            this.sccs = new ArrayList<>();
            Arrays.fill(this.index, -1);
            this.currentIndex = 0;
        }

        public List<List<Integer>> findSCCs() {
            for (int i = 0; i < graph.size(); i++) {
                if (index[i] == -1) {
                    strongconnect(i);
                }
            }
            return sccs;
        }

        private void strongconnect(int v) {
            index[v] = currentIndex;
            lowlink[v] = currentIndex;
            currentIndex++;
            stack.push(v);
            onStack[v] = true;

            for (int w : graph.get(v)) {
                if (index[w] == -1) {
                    strongconnect(w);
                    lowlink[v] = Math.min(lowlink[v], lowlink[w]);
                } else if (onStack[w]) {
                    lowlink[v] = Math.min(lowlink[v], index[w]);
                }
            }

            if (lowlink[v] == index[v]) {
                List<Integer> scc = new ArrayList<>();
                int w;
                do {
                    w = stack.pop();
                    onStack[w] = false;
                    scc.add(w);
                } while (w != v);
                sccs.add(scc);
            }
        }
    }

    public static int minChangesToReachSingleServer(ArrayList<Integer> connections) {
        int n = connections.size();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (connections.get(i) != i) {
                graph.get(i).add(connections.get(i));
            }
        }

        Tarjan tarjan = new Tarjan(graph);
        List<List<Integer>> sccs = tarjan.findSCCs();

        Map<Integer, Integer> sccId = new HashMap<>();
        for (int i = 0; i < sccs.size(); i++) {
            for (int node : sccs.get(i)) {
                sccId.put(node, i);
            }
        }

        int sccCount = sccs.size();
        List<Set<Integer>> sccGraph = new ArrayList<>();
        for (int i = 0; i < sccCount; i++) {
            sccGraph.add(new HashSet<>());
        }

        int[] inDegree = new int[sccCount];
        Arrays.fill(inDegree, 0);

        for (int v = 0; v < n; v++) {
            for (int w : graph.get(v)) {
                if (sccId.get(v) != sccId.get(w)) {
                    int u = sccId.get(v);
                    int vSCC = sccId.get(w);
                    if (!sccGraph.get(u).contains(vSCC)) {
                        sccGraph.get(u).add(vSCC);
                        inDegree[vSCC]++;
                    }
                }
            }
        }

        int sources = 0;
        for (int degree : inDegree) {
            if (degree == 0) {
                sources++;
            }
        }

        return Math.max(sources - 1, 0);
    }

}
