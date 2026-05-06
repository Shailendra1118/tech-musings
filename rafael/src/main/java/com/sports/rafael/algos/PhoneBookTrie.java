package com.sports.rafael.algos;

import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookTrie {

    public static void main(String[] args) {
        PhoneBookTrie phoneBook = new PhoneBookTrie();
        phoneBook.insert(new Contact("Aman", "0909090909"));
        phoneBook.insert(new Contact("Amar", "9191919199"));
        phoneBook.insert(new Contact("Amaina", "86868868686"));


        phoneBook.getAllStartsWith("ama").forEach(i -> System.out.println(i));

    }


    private final TrieNode root;
    public PhoneBookTrie() {
        this.root = new TrieNode();
    }

    public void insert(Contact contact) {
        char[] name = contact.name.toLowerCase().toCharArray();
        TrieNode current = root;
        for (char ch : name) {
            if (current.childs[ch - 'a'] == null) {
                current.childs[ch - 'a'] = new TrieNode();;
            }
            current = current.childs[ch-'a'];
        }
        current.contact = contact;
    }

    public List<Contact> getAllStartsWith(String prefix) {
        List<Contact> contacts = new ArrayList<>();
        char[] startWith = prefix.toLowerCase().toCharArray();
        TrieNode current = root;
        for (char ch: startWith) {
            if (current.childs[ch-'a'] != null) {
                current = current.childs[ch-'a'];
            }
        }
        //now current traversed to the node representing the end of a prefix string
        //collect all at this level , if current is not null
        //current is prefix root basically
        //recursive call needed
        collectAll(current, contacts);
        return contacts;
    }

    public void collectAll(TrieNode current, List<Contact> contacts) {
        if (current.contact != null) {
            contacts.add(current.contact);
        }
        for (TrieNode child : current.childs) {
            if (child != null) {
                collectAll(child, contacts);
            }
        }

    }



}


class TrieNode {
    TrieNode[] childs;
    Contact contact; // null if is not the end of a name

    public TrieNode() {
        this.childs = new TrieNode[26];
        //this.contact = null;
    }
}

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return name+": "+phoneNumber;
    }
}