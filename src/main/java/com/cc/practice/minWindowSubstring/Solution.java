package com.cc.practice.minWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    //correct but very slow and ugly
    //same basic algorithm but different impl details got 80% so not worth effort to improve now
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> lookingFor = new HashMap<>();

        //fill the set of chars we are looking for
        for(int i = 0; i < t.length(); i++) {
            lookingFor.put(t.charAt(i), lookingFor.getOrDefault(t.charAt(i), 0) + 1);
        }


        Map<Character, Integer> counts = new HashMap<>();
        int start = -1, end, i = 0;
        while(!lookingFor.isEmpty() && i < s.length()) {
            if(lookingFor.containsKey(s.charAt(i))) {
                if(start == -1) {
                    start = i;
                }
                int count =  lookingFor.get(s.charAt(i));
                if(count == 1) {
                    lookingFor.remove(s.charAt(i));
                } else {
                    lookingFor.put(s.charAt(i), count - 1);
                }
                counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            } else if(counts.containsKey(s.charAt(i))) {
                counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            }

            i++;
        }

        if(!lookingFor.isEmpty()) {
            return "";
        }

        end = i - 1;


        //fill the set of chars we are looking for
        for(i = 0; i < t.length(); i++) {
            lookingFor.put(t.charAt(i), lookingFor.getOrDefault(t.charAt(i), 0) + 1);
        }


        char startChar = s.charAt(start);

        while(counts.getOrDefault(startChar, 0) > lookingFor.getOrDefault(startChar, 0) && start < end) {
            start++;
            counts.put(startChar, counts.get(startChar) - 1);
            while(!counts.containsKey(s.charAt(start))) {
                start++;
            }
            startChar = s.charAt(start);
        }

        int minStart = start, minEnd = end;

        if(end - start < minEnd - minStart) {
            minStart = start;
            minEnd = end;
        }

        while(end < s.length() - 1) {
            end++;
            char endChar = s.charAt(end);
            startChar = s.charAt(start);

            if(counts.containsKey(endChar)) {
                counts.put(endChar, counts.get(endChar) + 1);
            }

            while(counts.getOrDefault(startChar, 0) > lookingFor.getOrDefault(startChar, 0) && start < end) {
                start++;
                counts.put(startChar, counts.get(startChar) - 1);
                while(!counts.containsKey(s.charAt(start))) {
                    start++;
                }
                startChar = s.charAt(start);
            }

            if(end - start < minEnd - minStart) {
                minStart = start;
                minEnd = end;
            }
        }

        return s.substring(minStart, minEnd + 1);
    }
}
