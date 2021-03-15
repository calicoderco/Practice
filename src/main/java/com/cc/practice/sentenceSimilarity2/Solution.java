package com.cc.practice.sentenceSimilarity2;

import java.util.*;

class Solution {

    Map<String, Integer> groupMap = new HashMap<>();
    Map<Integer, Set<String>> wordMap = new HashMap<>();
    int nextGroup = 0;

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;

        for(List<String> pair : pairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);

            Integer group1 = groupMap.get(word1);
            Integer group2 = groupMap.get(word2);

            System.out.println(word1 + ", " + word2 + ", " + group1 + ", " + group2);

            if(group1 == null && group2 == null) {
                groupMap.put(word1, nextGroup);
                groupMap.put(word2, nextGroup);
                Set<String> set = new HashSet<>();
                set.add(word1);
                set.add(word2);
                wordMap.put(nextGroup, set);
                nextGroup++;
            } else if(group1 != group2) {
                if(group1 == null) {
                    groupMap.put(word1, group2);
                    wordMap.get(group2).add(word1);
                } else if(group2 == null) {
                    groupMap.put(word2, group1);
                    wordMap.get(group1).add(word2);
                } else if(wordMap.get(group2).size() < wordMap.get(group1).size()) {
                    for(String group2Word : wordMap.get(group2)) {
                        wordMap.get(group1).add(group2Word);
                        groupMap.put(group2Word, group1);
                    }
                } else {
                    for(String group1Word : wordMap.get(group1)) {
                        wordMap.get(group2).add(group1Word);
                        groupMap.put(group1Word, group2);
                    }
                }
            }
        }

        for(int i = 0; i < words1.length; i++) {
            Integer group1 = groupMap.get(words1[i]);

            if(group1 == null) {
                group1 = nextGroup;
                groupMap.put(words1[i], nextGroup);
                nextGroup++;
            }

            Integer group2 = groupMap.get(words2[i]);

            if(group2 == null) {
                group2 = nextGroup++;
            }

            if(!group1.equals(group2)) {
                return false;
            }
        }

        return true;
    }
}