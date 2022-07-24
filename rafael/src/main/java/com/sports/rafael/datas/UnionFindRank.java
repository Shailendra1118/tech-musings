package com.sports.rafael.datas;

public class UnionFindRank {

    // Improved upon QuickUnion DataStructure
    /**
     *  Ranks is for storing the number that indicates if how many nodes this node acts as ROOT
     *  if ranks[X] = 3, it means, height of tree, with X as root node, has length of 3
     */
    
    public int[] roots;
    public int[] ranks;
    public UnionFindRank(int[] arr) {
        this.roots = arr;
        this.ranks = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            this.roots[i]=i;
            this.ranks[i] = 1; //initial height of every vertex is one, to begin with.
        }
    }

    public void union(int x, int y) {
        // connect x and y vertices
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) {
            //check ranks to make decision, attach the shorter tree under taller tree
            if(ranks[rootX] > ranks[rootY]) {
                //x is taller tree
                roots[rootY] = rootX; // remember not roots[x OR y], we are attaching roots
            } else if(ranks[rootX] < ranks[rootY])
                roots[rootX] = rootY; //Y is taller
            else {
                //if both are equal
                roots[rootX] = rootY;
                ranks[rootY] += 1;
            }
        }
    }

    // O(logN) -- height of tree
    public int find(int x) {
        //find the root of x
        while(x != roots[x])
            x = roots[x];
        return x;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

}
