package com.example.mongodemo.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "trie_nodes")
public class TrieNodeDocument {
    @Id
    private String id;

    private String key;

    public TrieNodeDocument(String key) {
        this.key = key;
    }

}
