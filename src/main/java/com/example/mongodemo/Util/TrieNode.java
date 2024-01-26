package com.example.mongodemo.Util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrieNode {

    private Map<Character, TrieNode> children = new HashMap<>();
    private boolean isEndOfWord;

}
