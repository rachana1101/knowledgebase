package com.knowledgebase.company.youtube;

import java.util.ArrayList;
import java.util.List;



public class Trie {
    TrieNode root = new TrieNode('*');
    
    public void insert(TrieNode node, String word) {
            char[] lets = word.toCharArray();
            int k = 0;
            for(Character c : lets) {
                int index = lets[k] - 'a';
                if (node.childs[index] == null)
                {
                node.childs[index] = new TrieNode(c);
                }
                node = node.childs[index];
                k++;
            }
            node.isWordEnd = true;
    }
    
    public boolean isWord(String s) {
        TrieNode node = root;
        char[] lets = s.toCharArray();
        int k =0;
        for(Character c : lets) {
            int index = lets[k]-'a';
            if(node.childs[index] == null) {
                return false; 
            } else {
                node = node.childs[index];
            }
            k++;
        }
        return true;
    }
    
    public List<String> findMatchingWords(String s) {
        TrieNode node = root;
        char[] lets = s.toCharArray();
        int k =0;
        for(Character c : lets) {
            int index = lets[k]-'a';
            if(node.childs[index] != null) {
                node = node.childs[index];
            }
            k++;
        }
      return restOfWord(node, "" , new ArrayList());
    }
    
    private List<String> restOfWord(TrieNode node, String w, List list) {
        if(node.isWordEnd) {
            list.add(w);
            w="";
            return list;
        } else {
            for(TrieNode child : node.childs) {
                if(child!=null) {
                    w = w.concat(child.character.toString());
                    System.out.println(w);
                    restOfWord(child, w, list);
                }
            }
        }
        return list;
    }
}

class TrieNode {
    Character character;
    boolean isWordEnd;
    TrieNode[] childs = new TrieNode[26];
    
    public TrieNode(Character character) {
        this.character = character;
    }
    
    public TrieNode(Character character, boolean isWordEnd, TrieNode[] childs) {
        super();
        this.character = character;
        this.isWordEnd = isWordEnd;
        this.childs = childs;
    }

    public boolean hasChilds() {
        if(childs.length>0) {
            return true;
        }
        return false;
    }
}