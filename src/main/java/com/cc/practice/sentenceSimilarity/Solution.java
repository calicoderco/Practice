package com.cc.practice.sentenceSimilarity;

import java.util.*;

class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;

        Map<String, Set<String>> wordEquivalenceMap = new HashMap<>();

        for(List<String> pair : pairs) {
            String word1 = pair.get(0),
                    word2 = pair.get(1);

            Set<String> equivalentWords;

            if(wordEquivalenceMap.containsKey(word1)) {
                equivalentWords = wordEquivalenceMap.get(word1);
            } else {
                equivalentWords = new HashSet<>();
                wordEquivalenceMap.put(word1, equivalentWords);
            }

            equivalentWords.add(word2);

            if(wordEquivalenceMap.containsKey(word2)) {
                equivalentWords = wordEquivalenceMap.get(word2);
            } else {
                equivalentWords = new HashSet<>();
                wordEquivalenceMap.put(word2, equivalentWords);
            }

            equivalentWords.add(word1);
        }


        List<Set<String>> wordSetList = new LinkedList<>();

        for(String word : words1) {
            Set<String> wordSet = new HashSet<>();
            wordSet.add(word);
            wordSet.addAll(wordEquivalenceMap.getOrDefault(word, Collections.emptySet()));
            wordSetList.add(wordSet);
        }

        Iterator<Set<String>> wordSetIt = wordSetList.iterator();
        for(String word : words2) {
            Set<String> wordSet = wordSetIt.next();
            if(!wordSet.contains(word)) {
                return false;
            }
        }

        return true;
    }
}
