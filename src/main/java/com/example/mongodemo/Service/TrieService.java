package com.example.mongodemo.Service;

import com.example.mongodemo.Util.TrieNode;
import com.example.mongodemo.Entity.TrieNodeDocument;
import com.example.mongodemo.Repository.TrieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrieService {

    @Autowired
    private TrieRepository trieRepository;

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, k -> new TrieNode());
        }
        current.setEndOfWord(true);

        trieRepository.save(new TrieNodeDocument(word));
    }

    public Object searchAutoSuggestion(String key) {
        TrieNode current = root;
        boolean isKeyPresent = true;

        // Traverse the trie to check if the complete word is present
        for (char c : key.toCharArray()) {
            current = current.getChildren().get(c);
            if (current == null) {
                isKeyPresent = false;
                break;
            }
        }

        // If the complete word is present, return it
        if (isKeyPresent && current.isEndOfWord()) {
            return key;
        }

        // Otherwise, perform auto-suggestion logic based on startsWith method
        List<TrieNodeDocument> suggestions = trieRepository.findByKeyStartingWith(key);
        List<String> autoSuggestions = suggestions.stream()
                .map(TrieNodeDocument::getKey)
                .toList();

        return autoSuggestions.isEmpty() ? "Not present in DataBase" : autoSuggestions;
    }

}
