package mocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    /**
     * array of integer, can be negative
     * sub-array with maximum sum
     *
     */

    public static void main(String[] args) {
        int[] arr = {1, 3, -5, 6, 10 , -8}; // 6

        int maxTillNow = arr[0];
        int currMax = arr[0];
        for(int i=1; i<arr.length; i++) {
            currMax = currMax + arr[i];
            if(currMax < 0){
                currMax = 0;
            }
            maxTillNow = Math.max(maxTillNow, currMax);
        }
        System.out.println("Res: "+maxTillNow);
        List<Integer> input = List.of(19,12,3,4,17);
        int k = 2;
        List<Integer> res = findAfterDelete(input, k);
        System.out.println("Result: "+res);
    }

    private static List<Integer> findAfterDelete(List<Integer> input, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int val : input) {
            while (!stack.isEmpty() && stack.peek() < val && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(val);
        }
        return new ArrayList<>(stack);
    }

    /**
     *
     * You have given Nodes with its value. All node are connected as linkedList.
     *
     * Node1 -> Node2 -> Node3 -> Node4 ..... Node(n)
     *
     * Algorithm to Delete(Node):
     *     DeleteNode=false
     *     for i = 1 to linkedList.length-1
     *          if ( value of (i)th Node < value of (i+1)th Node)
     *             delete i th Node
     *             DeleteNode=true
     *             break
     *     if(DeleteNode == false)
     *         delete the last Node
     *
     * You have to delete K node from given nodes using mentioned Algorithm.
     * linkedList : [3->100->1] , k = 1
     * Ans : 100 1
     *
     * linkedList : [19->12->3->4->17] , k = 2
     * Ans : 19 12 17
     *
     * linkedList : [23->45->11->77->18] , k = 3
     * Ans : 77 18
     */


}
