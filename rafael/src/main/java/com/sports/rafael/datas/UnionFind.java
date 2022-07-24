package com.sports.rafael.datas;

public class UnionFind {
    //implement this data structure with root array
    // Quick Find O(1)

    /**
     * <b>Quick Union</b> also works likes this, but
     * find(int x) {
     *     while(x != roots[x])
     *         x = roots[x];
     *  return x;
     *
     *  union(int x, int y) {
     *      Here we do not use the for loop, everytime
     *      rootX = find(x);
     *      rootY = find(y);
     *      if(rootX != rootY) {
     *          root[rootX] = rootY;
     *      }
     *  }
     * }
     */



    public int[] roots;
    public UnionFind(int arr[]) {
        this.roots = new int[arr.length];
        //init
        for(int i=0; i<arr.length; i++) {
            roots[i] = i; //every element is its own root
        }
    }

    public int find(int x) {
        //find the root of x node
        return roots[x];
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y); //if both x and y's root is same then they are connected.
    }

    public void union(int x, int y) {
        int rootX = roots[x]; //get root of x
        int rootY = find(y); // == roots[y]
        if(rootX != rootY) {
            //update root
            for(int i=0; i<roots.length; i++) {
                if(roots[i] == rootX)
                    roots[i] = rootY;
            }
        }

    }
}
