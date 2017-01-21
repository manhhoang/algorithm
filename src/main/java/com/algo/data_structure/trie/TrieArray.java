package com.algo.data_structure.trie;

public class TrieArray {

    private class TrieNode {
        TrieNode[] arr;
        boolean isEnd;

        // Initialize your data structure here.
        public TrieNode() {
            this.arr = new TrieNode[26];
        }

    }

    private TrieNode root;

    public TrieArray() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.arr[index] == null) {
                TrieNode temp = new TrieNode();
                p.arr[index] = temp;
                p = temp;
            } else {
                p = p.arr[index];
            }
        }
        p.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if (p == null) {
            return false;
        } else {
            if (p.isEnd)
                return true;
        }

        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if (p == null) {
            return false;
        } else {
            return true;
        }
    }

    public TrieNode searchNode(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (p.arr[index] != null) {
                p = p.arr[index];
            } else {
                return null;
            }
        }

        if (p == root)
            return null;

        return p;
    }

    public static void main(String[] args) {
        TrieArray trieArray = new TrieArray();
        String[] data = new String[]{"bananas", "ban", "ana"};
        for (String s : data) {
            trieArray.insert(s);
        }

        String[] input = new String[]{"bananas", "ba", "ana"};
        for (String s : input) {
            String exists = trieArray.search(s) ? "exists" : "doesn't exist";
            System.out.printf("Input: %s %s\n", s, exists);
        }
    }
}
