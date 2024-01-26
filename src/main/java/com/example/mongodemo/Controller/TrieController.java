package com.example.mongodemo.Controller;

import com.example.mongodemo.Service.TrieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trie")
public class TrieController {

    @Autowired
    private TrieService trieService;

    @PostMapping("/insert/{key}")
    public ResponseEntity<String> insert(@PathVariable String key) {
        trieService.insert(key);
        return new ResponseEntity<>("Key inserted successfully", HttpStatus.CREATED);
    }

    @GetMapping("/search/{key}")
    public ResponseEntity<Object> search(@PathVariable String key) {
        Object  result = trieService.searchAutoSuggestion(key);
        if (result != null)
            return new ResponseEntity<>(result, HttpStatus.OK);
        else
            return new ResponseEntity<>("Key not found", HttpStatus.NOT_FOUND);
    }

}
