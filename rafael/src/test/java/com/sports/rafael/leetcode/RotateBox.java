package com.sports.rafael.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class RotateBox {

    @Test
    public void rotateSquare() {

        int matrix[][] = {{5,1,9,11},
                        {2,4,8,10},
                        {13,3,6,7},
                        {15,14,12,16}};
        int N = matrix.length;
        //System.out.println("J: "+N/2);
        for(int i=0; i<(N+1)/2; i++) {  //<(N/2 + N%2)
            System.out.println("I: "+i);
            for(int j=0; j<N/2; j++) {
                int temp = matrix[i][j];
                System.out.println("J: "+j);
                matrix[i][j] = matrix[N-1 - j][i];
                matrix[N-1-j][i] = matrix[N-1-i][N-j -1];
                matrix[N-1 -i][N-j -1] = matrix[j][N-1 -i];
                matrix[j][N-1 -i] = temp;
            }
        }

        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
    }


    @Test
    public void testLinkedListAsStack() {
        LinkedList<Character> list = new LinkedList<>();
        list.addLast('C');
        list.addLast('D');
        list.removeLast();
        char ch = list.peek();
        //list.pop()
        System.out.println(ch);

        list.push('E');
        list.push('F');
        System.out.println(list.pop());
    }
}


