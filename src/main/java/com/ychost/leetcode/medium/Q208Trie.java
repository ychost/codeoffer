package com.ychost.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ychost
 * @date 2018/8/22
 */
public class Q208Trie {
    TrieNode trie = new TrieNode();

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = trie;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)){
                TrieNode child = new TrieNode();
                node.children.put(ch,child);
            }
            node = node.children.get(ch);
        }
        node.isWord=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPath(word);
        return node != null && node.isWord;
    }

    TrieNode searchPath(String path){
        TrieNode node = trie;
        for(int i=0;i<path.length();i++){
            char ch =path.charAt(i);
            if(!node.children.containsKey(ch)){
                return null;
            }
            node = node.children.get(ch);
        }
        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPath(prefix) != null;
    }
}

class TrieNode {
    boolean isWord = false;
    Map<Character,TrieNode> children = new HashMap<>();
}
