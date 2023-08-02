package com.sports.rafael.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    class TrieNode {
        TrieNode[] links;
        boolean isWord;
        public TrieNode(){
            this.links = new TrieNode[26];
        }
        public void putLink(char ch, TrieNode node) {
            this.links[ch-'a'] = node;
        }
        public TrieNode getLink(char ch) {
            return this.links[ch -'a'];
        }
    }
    class Trie {
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode node = root;
            for(int i=0; i<word.length(); i++) {
                char cur = word.charAt(i);
                if(node.getLink(cur) != null) {
                    node = node.getLink(cur);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.putLink(cur, newNode);
                    node = newNode;
                }
            }
            node.isWord = true;
        }
        public TrieNode searchPrefixNode(String prefix) {
            TrieNode node = root;
            for(int i=0; i<prefix.length(); i++) {
                char cur = prefix.charAt(i);
                if(node.getLink(cur) == null) {
                    return null;
                }else{
                    node = node.getLink(cur);
                }
            }
            return node;
        }
    }


    private TrieNode root;
    private int[] rDir = {-1, 0, 1, 0};
    private int[] cDir = {0, 1, 0, -1};
    private List<String> res = new ArrayList<>();
    private Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        String[] words = {"oath", "pea", "eat", "rain"};
        WordSearch2 obj = new WordSearch2();
        List<String> w = obj.findWords(board, words);
        System.out.println("Res: "+w);
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String str : words) {
            trie.insert(str);
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                backtrack(board, i, j, trie, board[i][j]+"");
                visited.clear();
            }
        }
        return res;
    }
    private void backtrack(char[][] board, int r, int c, Trie trie, String prefix) {

        TrieNode node = trie.searchPrefixNode(prefix);
        if(node == null)
            return;
        if(node.isWord) {
            this.res.add(prefix);
            return;
        }
        //prefix is found in trie
        visited.add(r+" "+c);
        for(int i=0; i<rDir.length; i++) {
            int nR = r + rDir[i];
            int nC = c + cDir[i];
            if(nR >= 0 && nR < board.length && nC >=0 && nC < board[0].length && !visited.contains(nR+" "+nC)) {
                backtrack(board, nR, nC, trie, prefix + board[nR][nC]);
            }
        }
    }
}
