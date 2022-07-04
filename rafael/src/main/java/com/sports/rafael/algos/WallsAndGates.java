package com.sports.rafael.algos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args) {
        WallsAndGates obj = new WallsAndGates();
        int[][] rooms0 = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        int rooms[][] = {{2147483647,0,2147483647,2147483647,0,2147483647,-1,2147483647}};
        obj.wallsAndGates(rooms);
        Arrays.stream(rooms).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    public void wallsAndGates(int[][] rooms) {

        //iterate over every empty room
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++) {
                if(rooms[i][j] == Integer.MAX_VALUE) {
                    Integer steps = findNearestGate(rooms,i,j);
                    rooms[i][j] = steps;

                } //if empty
            }
        }
    }

    private int findNearestGate(int[][] rooms, int i, int j) {
        int steps = 0;
        int xDir[] = {1,-1,0,0};
        int yDir[] = {0,0,-1,1};
        int R = rooms.length;
        int C = rooms[0].length;

        Queue<Integer[]> que = new LinkedList<>();
        int[][] visited = new int[R][C];
        Integer[] empty = {i,j}; //new Integer[2];

        que.offer(empty);
        visited[i][j] = 1;

        while(! que.isEmpty()) {
            int qSize = que.size();
            for(int p=0; p<qSize; p++) {
                Integer[] pos = que.poll();
                if(rooms[pos[0]][pos[1]] == 0) {
                    //if gate
                    return steps;
                }
                for(int k=0; k<xDir.length; k++) {
                    int xPos = pos[0]+xDir[k];
                    int yPos = pos[1]+yDir[k];

                    if(isValid(xPos, yPos, R, C, rooms) && visited[xPos][yPos] == 0) {
                        que.offer(new Integer[]{xPos, yPos});
                        visited[xPos][yPos] = 1;
                    }
                }
            }

            //increase level, go to next lot
            steps++;
        }
        return -1;
    }

    private boolean isValid(int x, int y, int row, int col, int[][] rooms) {
        if(x >=0 && x< row && y >=0 && y<col && rooms[x][y] != -1)
            return true;
        else
            return false;
    }

}
