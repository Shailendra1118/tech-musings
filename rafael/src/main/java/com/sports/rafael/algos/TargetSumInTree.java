package com.sports.rafael.algos;

import java.util.ArrayList;
import java.util.List;

public class TargetSumInTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private static int count = 0;
    public static void main(String[] args) {
        TargetSumInTree obj = new TargetSumInTree();
        TreeNode fiv = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode ele = new TreeNode(11);
        TreeNode thirteen = new TreeNode(13);
        TreeNode four1 = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode fiv1 = new TreeNode(5);
        TreeNode one = new TreeNode(1);

        fiv.left = four;
        fiv.right = eight;
        fiv.left.left = ele;
        fiv.left.left.left = seven;
        fiv.left.left.right = two;

        fiv.right.left =  thirteen;
        fiv.right.right = four1;
        fiv.right.right.left = fiv1;
        fiv.right.right.right = one;

        obj.pathSum(fiv, 22);
        System.out.println("Path Count: "+count);
    }


    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        List<Integer> list = new ArrayList<>();
        //list.add(root.val);
        dfs(root, list, targetSum);
        return count;
    }

    private void dfs(TreeNode node, List<Integer> list, int target) {
        //base
        if(node == null)
            return;
        List<Integer> nList = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            nList.add(list.get(i)+node.val);
            if(nList.get(i) == target) {
                count++;
            }
        }
        nList.add(node.val);
        if(node.val == target) {
            count++;
        }
        //list = nList;
        dfs(node.left, nList, target);
        dfs(node.right, nList, target);
    }
}
