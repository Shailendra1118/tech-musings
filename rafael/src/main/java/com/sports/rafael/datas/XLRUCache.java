package com.sports.rafael.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class XLRUCache implements Cache{

    @AllArgsConstructor
    class Node{
        int data;
        String value;
        Node prev;
        Node next;

        public String toString() {
            return "key:"+data+", value:"+value+", prev:"+ ((prev != null) ? prev.data : "null")+", next:"+((next != null) ? next.data : "null");
        }
    }

    private int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;

    public XLRUCache(int cap) {
        this.capacity = cap;
    }

    @Override
    public void put(Integer key, String value) {
        if(map.containsKey(key)) {
            //update old key
            Node old = map.get(key);
            old.value = value;
            delete(old);
            setHead(old);
        }else {
            Node newNode = new Node(key, value, null, null);
            if(map.size() == this.capacity) {
                map.remove(this.tail.data);
                delete(tail);
            }
            setHead(newNode);
            map.put(key, newNode);
        }

    }

    @Override
    public String get(Integer key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            delete(node);
            setHead(node);
            return node.value;
        }
        return "Not found";
    }

    private void delete(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        }else{
            //first node only
            head = node.next;
        }

        if(node.next != null) {
            node.next.prev = node.prev;
        }else{
            tail = node.prev;
        }
    }

    private void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if(head != null)
            head.prev = node;
        head = node;
        if(tail == null)
            tail = head;

    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {
        this.map.clear();
        for (Node n = head; n != null; ) {
            Node next = n.next;
            n.data = 0;
            n.next = null;
            n.prev = null;
            // move next
            n = next;
        }
        head = tail = null;
    }

    @Override
    public void display() {
        this.map.entrySet().stream().forEach((e -> System.out.println("Key-> "+e.getKey() +", Associated Node-> "+e.getValue())));
    }
}
