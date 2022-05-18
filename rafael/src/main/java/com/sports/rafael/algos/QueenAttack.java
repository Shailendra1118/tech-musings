package com.sports.rafael.algos;

import java.util.HashMap;

public class QueenAttack {

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int n = 8;  // Chessboard size
        int k = 1;  // Number of obstacles
        int Qposx = 4; // Queen x position
        int Qposy = 4; // Queen y position
        int obstPosx[] = { 3 };  // x position of obstacles
        int obstPosy[] = { 5 };  // y position of obstacles

        System.out.print(numberOfPosition(n, k, Qposx, Qposy,
                obstPosx, obstPosy) +"\n");
    }

    // Return the number of position a Queen can move.
    static int numberOfPosition(int n, int k, int x, int y, int obstPosx[], int obstPosy[])
    {
        int x1, y1, ans = 0;
        HashMap <QueenAttack.Pair, Integer> mp = new HashMap<>();

        // Mapping each obstacle's position
        while(k>0)
        {
            k--;
            x1 = obstPosx[k];
            y1 = obstPosy[k];

            mp.put(new QueenAttack.Pair(x1, y1), 1);
        }

        // Fetching number of position a queen can
        // move in each direction.
        ans += check(n, x + 1, y, 1, 0, mp);
        ans += check(n, x-1, y, -1, 0, mp);
        ans += check(n, x, y + 1, 0, 1, mp);
        ans += check(n, x, y-1, 0, -1, mp);
        ans += check(n, x + 1, y + 1, 1, 1, mp);
        ans += check(n, x + 1, y-1, 1, -1, mp);
        ans += check(n, x-1, y + 1, -1, 1, mp);
        ans += check(n, x-1, y-1, -1, -1, mp);

        return ans;
    }

    // Return the number of moves with a given direction
    static int check(int n, int x, int y, int xx, int yy, HashMap <QueenAttack.Pair, Integer> mp)
    {
        int ans = 0;

        // Checking valid move of Queen in a direction.
        while (range(n, x, y) && ! mp.containsKey(new QueenAttack.Pair(x, y)))
        {
            x += xx;
            y += yy;
            ans++;
        }

        return ans;
    }

    // Return if position is valid on chessboard
    static boolean range(int n, int x, int y)
    {
        return (x <= n && x > 0 && y <= n && y > 0);
    }

}
