package com.sports.rafael.datas;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class UnionFindTest {

    @Test
    public void testQuickUF() {

        UnionFind uf = new UnionFind(new int[] {0,1,2,3,4});
        System.out.println("Start: "+ Arrays.toString(uf.roots));
        System.out.println(uf.isConnected(0,4));

        uf.union(3,4);
        System.out.println(uf.isConnected(0,4));
        System.out.println("3-->4: "+ Arrays.toString(uf.roots));

        uf.union(0,3);
        System.out.println(uf.isConnected(0,4));
        System.out.println("0-->3: "+ Arrays.toString(uf.roots));
    }

    @Test
    public void testUFRank() {
        UnionFindRank uf = new UnionFindRank(new int[] {0,1,2,3,4});
        System.out.println("Start: "+ Arrays.toString(uf.roots));
        System.out.println("Ranks: "+ Arrays.toString(uf.ranks));
        System.out.println(uf.isConnected(0,4));

        uf.union(3,4);
        System.out.println(uf.isConnected(0,4));
        System.out.println("3-->4: "+ Arrays.toString(uf.roots));
        System.out.println("Ranks: "+ Arrays.toString(uf.ranks));

        uf.union(0,3);
        System.out.println(uf.isConnected(0,4));
        System.out.println("0-->3: "+ Arrays.toString(uf.roots));
        System.out.println("Ranks: "+ Arrays.toString(uf.ranks));
    }
}
