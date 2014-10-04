package com.knowledgebase.company.youtube;

public class AutoSpellCorrector {

    public static void main(String... str) {
        Trie trie = new Trie();
        trie.insert(trie.root, "cat");
        trie.insert(trie.root, "car");
        trie.insert(trie.root, "carry");
        trie.insert(trie.root, "rat");
        trie.insert(trie.root, "their");
        trie.insert(trie.root, "there");
        
        System.out.println(trie.isWord("cat"));
        System.out.println(trie.isWord("cats"));
        
        System.out.println(trie.findMatchingWords("th"));
    }
    
    
}
