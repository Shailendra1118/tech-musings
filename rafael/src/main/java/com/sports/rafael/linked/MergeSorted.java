package com.sports.rafael.linked;

import java.util.List;

public class MergeSorted {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node4;

        ListNode node11 = new ListNode(1);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(4);
        node11.next = node13;
        node13.next = node14;

        iterate(node11);
        ListNode head = merge(node1, node11);
        iterate(head);
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode h1 = list1;
        ListNode h2 = list2;
        ListNode start = new ListNode(-1);
        ListNode prev = start;
        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val) {
                prev.next = h1;
                prev = h1;
                h1 = h1.next;
            }else {
                prev.next = h2;
                prev = h2;
                h2 = h2.next;
            }
            //prev = prev.next;
            /*
            else {
                prev.next = h1;
                prev = h1;
                h1 = h1.next;
            }
             */
        }
        //link the longer list at the end
        prev.next = h1 == null ? h2 : h1;
        return start.next;
    }
    private static void iterate(ListNode node) {
        ListNode temp = node;
        while(temp != null) {
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
class ListNode {
    int val;
    ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
