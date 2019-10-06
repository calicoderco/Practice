package com.cc.practice.findSubstring;

import java.util.*;

class Solution {
    //works when words are of any size
    /*public List<Integer> findSubstring(String s, String[] words) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        if(words.length == 0) {
            return result;
        }

        Map<String, Integer> wordMap = new HashMap<>(words.length);
        for(String word : words) {
            wordMap.put(word, wordMap.containsKey(word) ? Integer.valueOf(wordMap.get(word).intValue() + 1) : Integer.valueOf(1));
        }


        for(int i = 0; i < s.length(); i++) {
            findSubstring(s, wordMap, result, i);
        }

        return result;
    }


    public void findSubstring(String s, Map<String, Integer> words, List<Integer> result, int startingIndex) {
      findSubstring(s, words, result, startingIndex, startingIndex);
    }

    public void findSubstring(String s, Map<String, Integer> words, List<Integer> result, int startingIndex, int endingIndex) {
        if(words.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for(int i = endingIndex; i < s.length(); i++) {
                builder.append(s.charAt(i));
                String substring = builder.toString();
                if(words.containsKey(substring)) {

                    Integer number = words.remove(substring);
                    if(number.intValue() > 1) {
                        words.put(substring, Integer.valueOf(number.intValue() - 1));
                    }
                    findSubstring(s, words, result, startingIndex,i + 1);
                    words.put(substring, number);
                }
            }
        } else {
            result.add(startingIndex);
        }
    }*/

    //words are all the same size but slow due to recursion
    /*public List<Integer> findSubstring(String s, String[] words) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        if(words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();

        Map<String, Integer> wordMap = new HashMap<>(words.length);
        for(String word : words) {
            wordMap.put(word, wordMap.containsKey(word) ? Integer.valueOf(wordMap.get(word).intValue() + 1) : Integer.valueOf(1));
        }


        for(int i = 0; i < s.length(); i++) {
            findSubstring(s, wordMap, result, wordLength, i);
        }

        return result;
    }


    public void findSubstring(String s, Map<String, Integer> words, List<Integer> result, int wordLength, int startingIndex) {
        findSubstring(s, words, result, wordLength, startingIndex, startingIndex);
    }

    public void findSubstring(String s, Map<String, Integer> words, List<Integer> result, int wordLength, int startingIndex, int endingIndex) {
        if(words.size() > 0) {
            if(endingIndex + wordLength - 1 < s.length()) {
                String substring = s.substring(endingIndex, endingIndex + wordLength);
                if(words.containsKey(substring)) {
                    Integer number = words.remove(substring);
                    if(number.intValue() > 1) {
                        words.put(substring, Integer.valueOf(number.intValue() - 1));
                    }
                    findSubstring(s, words, result, wordLength, startingIndex,endingIndex + wordLength);
                    words.put(substring, number);
                }
            }
        } else {
            result.add(startingIndex);
        }
    }*/

    public List<Integer> findSubstring(String s, String[] words) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Set<Integer> resultSet = new HashSet<Integer>(words.length);

        if(words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWordsLength = words.length * wordLength;

        Map<String, Integer> wordMap = new HashMap<>(words.length);
        for(String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> coveredWordMap = new HashMap<>(words.length);
        for(int startingIndex = 0; startingIndex <= s.length() - totalWordsLength; startingIndex++) {
            if(!resultSet.contains(startingIndex)) {
                int endingIndex = startingIndex;
                Integer number = 1;
                while(wordMap.size() > 0 && endingIndex + wordLength - 1 < s.length() && number > 0) {
                    String substring = s.substring(endingIndex, endingIndex + wordLength);
                    number = wordMap.getOrDefault(substring, 0);
                    if(number > 0) {
                        if(number > 1) {
                            wordMap.put(substring, Integer.valueOf(number.intValue() - 1));
                        } else {
                            wordMap.remove(substring);
                        }
                        coveredWordMap.put(substring, coveredWordMap.getOrDefault(substring, 0) + 1);
                        endingIndex += wordLength;
                    }
                }

                if(wordMap.size() == 0) {
                    result.add(startingIndex);
                    resultSet.add(startingIndex);
                }

                int i = startingIndex;
                int j = endingIndex - 1;

                while(i < j && j <= s.length() - totalWordsLength) {
                    String firstWord = s.substring(i, i + wordLength);
                    coveredWordMap.put(firstWord, coveredWordMap.getOrDefault(firstWord, 0) - 1);
                    if(coveredWordMap.getOrDefault(firstWord, 0) == 0) {
                        coveredWordMap.remove(firstWord);
                    }
                    wordMap.put(firstWord, wordMap.getOrDefault(firstWord, 0) + 1);
                    String newWord = s.substring(j, j + wordLength);
                    i+= wordLength;

                    if(wordMap.getOrDefault(newWord, 0) > 0) {
                        wordMap.put(newWord, wordMap.getOrDefault(newWord, 0) - 1);
                        if(wordMap.getOrDefault(newWord, 0) == 0) {
                            wordMap.remove(newWord);
                        }

                        coveredWordMap.put(newWord, wordMap.getOrDefault(newWord, 0) + 1);
                        j += wordLength;

                        if(wordMap.size() == 0) {
                            result.add(i);
                            resultSet.add(i);
                        }
                    }
                }

                if(coveredWordMap.size() > 0) {
                    for(String coveredWord : coveredWordMap.keySet()) {
                        wordMap.put(coveredWord, wordMap.getOrDefault(coveredWord, 0) + coveredWordMap.getOrDefault(coveredWord, 0));
                    }

                    coveredWordMap.clear();
                }
            }
        }

        return result;
    }


    /*
    public Map<String, Map> buildTree(String[] words) {
        Map<String, Map> rootTree = new HashMap<String, Map>();
        for(String word: words) {
            addToTree(word, rootTree, 0);
        }
        return rootTree;
    }

    public void addToTree(String word, Map<String, Map> tree, int i) {
        if(i < word.length()) {
            String s = word.charAt(i) + "";
            Map<String, Map> subTree;
            if(tree.containsKey(s)) {
                subTree = tree.get(s);
            } else {
                subTree = new HashMap<();
                tree.put(s, subTree);
            }
            addToTree(word, subTree, i + 1);
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Map> tree = buildTree(words);

        LinkedList<Integer> result = new LinkedList<Integer>();
        if(words.length == 0) {
            return result;
        }

        for(int i = 0; i < s.length(); i++) {
            findSubstring(s, tree, result, i);
        }

        return result;
    }


    public void findSubstring(String s, Map<String, Map> rootTree, List<Integer> result, int startingIndex) {
        findSubstring(s, rootTree, result, startingIndex, startingIndex);
    }

    public void findSubstring(String s, Map<String, Map> rootTree, List<Integer> result, int startingIndex, int endingIndex) {
        if(rootTree.size() > 0 && endingIndex < s.length()) {
            String substring = s.charAt(endingIndex) + "";
            if(rootTree.containsKey(substring)) {
                findSubstring(s, rootTree.get(substring), result, startingIndex, endingIndex + 1);
            }
        }

    }*/
}

