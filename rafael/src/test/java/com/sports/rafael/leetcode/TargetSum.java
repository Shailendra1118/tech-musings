package com.sports.rafael.leetcode;

public class TargetSum {
 /*
 IT is not optimal and correct solution, It should be implemented
 without evaluate expression as there is no need and it will be O(2^n) solution
  */
    private static int count = 0;
    public static void main(String[] args) {
        int[] arr = {1,0,0,0};
        TargetSum obj = new TargetSum();
        obj.findTargetSumWays(arr, 1000);
        //int res = obj.evalExp("-2-1");
        System.out.println("Res: "+count);
    }

    private void findTargetSumWays(int[] arr, int target) {
        //StringBuilder sb = new StringBuilder();
        util("", arr, target, 0);
    }

    private void util(String exp, int[] arr, int target, int curr) {
        //base case of dfs
        if(curr == arr.length) {
            if(evalExp(exp) == target)
                this.count++;
            return;
        }

        util(exp+"+"+arr[curr], arr, target, curr+1);
        util(exp+"-"+arr[curr], arr, target, curr+1);

    }

    private int evalExp(String exp) {
        char arr[] = exp.toCharArray();
        int res = 0;
        boolean neg = false;
        for(char c : arr) {
            if(Character.isDigit(c)) {
                if(neg) {
                    res -= Character.getNumericValue(c);
                    neg = false;
                }else
                    res += Character.getNumericValue(c);
            }else{
                // + or -
                if(c == '-')
                    neg = true;
            }
        }
        return res;
    }


}
