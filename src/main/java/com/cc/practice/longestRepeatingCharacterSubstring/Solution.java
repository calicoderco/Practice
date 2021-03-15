package com.cc.practice.longestRepeatingCharacterSubstring;

import java.util.TreeSet;

class Solution {


    //sadly, time limit exceeded for this one
    /*
    private class CharCount implements Comparable<CharCount> {
        int count;
        char c;

        public int compareTo(CharCount other) {
            return count - other.count;
        }
    }

    TreeSet<CharCount> tree = new TreeSet<CharCount>();
    CharCount[] charCounts = new CharCount[26];

    //sadly, time limit exceeded for this one
    public int characterReplacement(String s, int k) {
        for(int i = 0; i < 26; i++) {
            CharCount charCount = new CharCount();
            charCount.count = 0;
            charCount.c = (char) ('A' + i);
            charCounts[i] = charCount;
            tree.add(charCount);
        }

        if(k >= s.length()) {
            return s.length();
        }

        int i = 0, j = 1;

        charCountFor(s.charAt(0)).count++;
        tree.add(charCountFor(s.charAt(0)));
        charCountFor(s.charAt(1)).count++;
        tree.add(charCountFor(s.charAt(1)));

        int longest = 0;

        while(i < s.length() - 1 && j < s.length()) {


            CharCount highestCharCount = tree.last();
            int replacementSpaces = j - i + 1 - highestCharCount.count;
            if(replacementSpaces <= k) {
                longest = Math.max(longest, j - i + 1);
                j++;
                if(j < s.length()) {
                    CharCount charCountAtJ = charCountFor(s.charAt(j));
                    tree.remove(charCountAtJ);
                    charCountAtJ.count++;
                    tree.add(charCountAtJ);
                }
            } else if(i < j - 1) {
                CharCount charCountAtI = charCountFor(s.charAt(i));
                tree.remove(charCountAtI);
                charCountAtI.count--;
                tree.add(charCountAtI);
                i++;
            }
        }

        return longest;
    }

    private CharCount charCountFor(char c) {
        return charCounts[c - 'A'];
    }*/

        public int characterReplacement(String s, int k)
        {
            int start = 0, end = -1;
            int maxCountOfRepeatedChar = Integer.MIN_VALUE, maxLen = Integer.MIN_VALUE;
            int[] countMap = new int[26];

            while (++end < s.length())
            {
                maxCountOfRepeatedChar = Math.max(maxCountOfRepeatedChar, ++countMap[getInt(s.charAt(end))]);
                while ((end - start + 1) - maxCountOfRepeatedChar > k) countMap[getInt(s.charAt(start++))]--;
                maxLen = Math.max(maxLen, end - start + 1);
            }

            return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
        }

        private int getInt(char c)
        {
            return (int) (c - 'A');
        }
}
