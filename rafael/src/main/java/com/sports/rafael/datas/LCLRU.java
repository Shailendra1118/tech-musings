package com.sports.rafael.datas;

import java.util.HashMap;
import java.util.Map;

public class LCLRU {
    public static void main(String[] args) {
        int capacity = 3;
        LCLRUCache obj = new LCLRUCache(capacity);

          obj.put(100, 1);
//        obj.put(200, 2);
//        obj.put(300, 3);
        int val = obj.get(100);
        System.out.println("100's value :"+val);
        obj.put(400, 3);
        System.out.println(obj);
    }
}

class LCLRUCache {
    private int capacity;
    private Map<Integer, ListNode> dict;
    private ListNode head;
    private ListNode tail;

    public LCLRUCache(int capacity) {
        this.capacity = capacity;
        dict = new HashMap<>();
        //init pointers
        this.head = new ListNode(-1,-1);
        this.tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.dict.entrySet().forEach(e -> sb.append("key:"+e.getKey()+"-value:"+e.getValue().val).append(" "));
        //sb.append(", ");
        return sb.toString();
    }

    public int get(int key) {
        if(! dict.containsKey(key)) {
            return -1;
        }
        //make it recently used
        ListNode node = dict.get(key);
        //remove from head and add to tail
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(dict.containsKey(key)) {
            ListNode old = dict.get(key);
            remove(old);
        }

        ListNode node = new ListNode(key, value);
        dict.put(key, node);
        add(node);

        //capacity check
        if(dict.size() > capacity) {
            ListNode toDelete = head.next;
            remove(toDelete);
            dict.remove(toDelete.key);
        }
    }

    public void add(ListNode node) {
        ListNode prevNode = tail.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

//doubly LL
class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */