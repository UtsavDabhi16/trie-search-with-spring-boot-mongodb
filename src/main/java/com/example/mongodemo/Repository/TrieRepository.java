package com.example.mongodemo.Repository;

import com.example.mongodemo.Entity.TrieNodeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface  TrieRepository extends MongoRepository<TrieNodeDocument, String> {

    List<TrieNodeDocument> findByKeyStartingWith(String prefix);
}
