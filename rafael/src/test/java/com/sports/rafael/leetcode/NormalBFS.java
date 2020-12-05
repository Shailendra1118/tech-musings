package com.sports.rafael.leetcode;

import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

public class NormalBFS {

    static class Node {
        int val;
        Node left = null;
        Node right = null;
        Node(int val, Node left, Node right) {
            this.val = val;
            if(left != null)
                this.left = left;
            if(right != null)
                this.right =right;
        }
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Node node = populateTree();
        bfs(node);

    }

    public static void bfs(Node node) {
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while(queue.size() != 0) {
            Node n = queue.poll();
            System.out.println(n.val);
            // check if this node has any child
            if(n.left != null)
                queue.offer(n.left);
            if(n.right != null)
                queue.offer(n.right);
        }
    }


    private static Node populateTree() {
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        return root;
    }
}
