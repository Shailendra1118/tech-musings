package com.sports.rafael;

public class TreeView {

    public static void main(String[] args) {
        TreeView tv = new TreeView();
        Node root = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node thr = new Node(3);
        Node fr = new Node(4);
        Node fv = new Node(5);
        Node six = new Node(6);
        root.left = one;
        root.right = two;
        one.left = thr;
        one.right = fr;
        two.left = fv;
        two.right = six;
        tv.showRView(root);
    }

    private void showRView(Node node) {
        System.out.println(node.val);
        if(node.right != null)
            showRView(node.right);
    }

    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
}
