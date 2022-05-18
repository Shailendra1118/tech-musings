package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        int n = 3;
        List<String> res = new ArrayList<>();
        generate(n, 0, 0, res, "");
        System.out.println(res);

        ArrayList<String> list = new ArrayList<>(res){{add("Shailendra");}};
        System.out.println("List: "+list);
        //OR
        list = new ArrayList<>(Arrays.asList("Shailendra", "Singh", "Yadav"));
        System.out.println("New List: "+list);

        List<String> strList = List.of("Shailendra", "Singh", "Yadav");
        System.out.println("StringList: "+strList);
    }

    private static void generate(int n, int leftCount, int rightCount, List<String> res, String sb) {
        //base conditions
        /*
        if(leftCount > n || rightCount > n)
            return;
        if(leftCount < rightCount)
            return;
        if(leftCount == rightCount && leftCount == n) {
            res.add(sb.toString());
            sb.setLength(0);
            return;
        }*/
        if(sb.length() == n*2) {
            res.add(sb.toString());
            //sb.setLength(0);
            return;
        }
        if(leftCount < n)
            generate(n, leftCount+1, rightCount, res, sb+"(");
        if(rightCount < leftCount)
            generate(n, leftCount, rightCount+1, res, sb+")");

    }
}
