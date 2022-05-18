package com.sports.rafael.algos;

public class JumpingClouds {
    public static void main(String[] args) {
        int clouds[] = {0,1,0,0,0,1,0};

        int res = countMin(clouds, 0, 0);
        System.out.println("Res: "+res);
    }

    private static int countMin(int[] clouds, int position, int count) {
        if(position >= clouds.length-1)
            return count;

        if(clouds[position] == 1)
            return count;

        return Math.min(countMin(clouds, position+1, count+1),
                countMin(clouds, position+2, count+1));
    }
}
