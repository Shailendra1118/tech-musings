package com.sports.rafael.algos;

import java.util.List;

public class DetectLoop {
    public static void main(String[] args) {

        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l0 = new ListNode(0);
        ListNode l4_ = new ListNode(-4);
        l3.next = l2;
        l2.next = l0;
        l0.next = l4_;
        l4_.next = l2;

        ListNode res = detectLoop(l3);
        System.out.println("Res: "+res.val);
    }

    private static ListNode detectLoop(ListNode head) {
        if(head == null)
            return null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode intersection = null;
        while(slowPtr != null && fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr) {
                intersection = slowPtr;
                break;
            }
        }

        if(intersection == null)
            return null;

        //find entrance of cycle
        slowPtr = head;
        fastPtr = intersection;
        while(slowPtr != fastPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return slowPtr;

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
