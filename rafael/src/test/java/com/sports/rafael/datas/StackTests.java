package com.sports.rafael.datas;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class StackTests {

    @Test
    public void testStackMethods() {
        Deque<String> deque = new LinkedList<>(); //Deque is an interface, extending Queue interface
        // push and pop methods are implemented by ArrayDeque class
        // LinkedList implemented push and pop
        deque.push("element");
        //System.out.println(deque.pop());
        deque.forEach(e -> System.out.println(e));
    }

    @Test
    public void testLL() {
        LinkedList<String> stack = new LinkedList<>();
        stack.push("element1");
        stack.push("element2");
        stack.push("element3");
        //System.out.println(stack.peek());
        stack.forEach(e -> System.out.println(e));
        System.out.println("----");

        for (String s : stack) {
            System.out.println(s);
        }

    }

    class Node {
        int val;
        Node left;
        Node right;
        public Node(int d, Node l, Node r) {
            this.val = d;
            this.left = l;
            this.right = r;
        }
        public Node(int d) {
            this.val = d;
        }
    }
    @Test
    void rangeSumBST() {
        Node n3 =  new Node(3);
        Node n10 =  new Node(10);
        Node n5 =  new Node(5);
        Node n15 =  new Node(15);
        Node n7 =  new Node(7);
        Node n18 =  new Node(18);
        n10.left = n5;
        n10.right = n15;
        n15.right = n18;
        n5.left = n3;
        n5.right = n7;

        //preorder traversal
        RangeSum sum = new RangeSum();
        sum.total = 0;

        int low = 7;
        int high = 15;
        traverse(n10, low, high, sum);
        System.out.println("Total: "+sum.total);

    }

    class RangeSum {
        int total;
    }

    private void traverse(Node node, int low, int high, RangeSum sum) {
        if (node == null) {
            return;
        }
        if (node.val >= low && node.val <= high) {
            sum.total += node.val;
        }
        traverse(node.left, low, high, sum);
        traverse(node.right, low, high, sum);
    }
}
