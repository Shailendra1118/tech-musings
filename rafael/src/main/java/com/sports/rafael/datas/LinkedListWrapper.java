package com.sports.rafael.datas;

public class LinkedListWrapper {

    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        //Node head = new Node(1);
        LinkedListWrapper obj = new LinkedListWrapper();
        //obj.reverse();
        obj.reverseAll();
    }

    private void reverse() {
        Node head = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        head.next = b;
        b.next = c;
        c.next = d;

        //reverseAll(head);

        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;

        while(head != null && head.next != null) {
            Node first = head;
            Node sec = head.next;

            prev.next = sec; //make sense from second iterator, if first then
            first.next = sec.next;
            sec.next = first;

            prev = first;
            head = first.next;
        }

        //swapPair(prev, prev.next);
        printLL(dummy);

    }

    private void reverseAll() {
        Node head = new Node(100);
        Node b = new Node(200);
        Node c = new Node(300);
        Node d = new Node(400);
        Node e = new Node(500);
        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Node newHead = reverseAllUtil(head);
        printLL(newHead);

    }

    private Node reverseAllUtil(Node head) {
        if(head.next == null)
            return head;
        Node prev = head;
        Node reversed = reverseAllUtil(head.next);
        reversed.next = prev;
        return prev;
    }

    private void printLL(Node head) {
        while(head != null) {
            System.out.print(head.data+"-->");
            head = head.next;
        }
        System.out.println("null");
    }

    private void swapPair(Node prev, Node current) {

        //base case
        if(current == null)
            return;
        Node temp = prev.next;
        Node next = current.next;

        current.next = temp;
        prev.next = current;
        temp.next = next;
        if(next != null)
            swapPair(temp, next.next);

    }
}
