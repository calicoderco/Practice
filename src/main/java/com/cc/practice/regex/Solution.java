package com.cc.practice.regex;

class Solution {
    public boolean isMatch(String input, String pattern, int i, int p) {
        if(i == input.length()) {
            if(p == pattern.length() - 2 && pattern.charAt(pattern.length() - 1) == '*') {
                return true;
            } else if(p == pattern.length()) {
                return true;
            } else {
                return false;
            }
        } else if(p == pattern.length()) {
            return false;
        } else {

            if(p < pattern.length() - 1 && pattern.charAt(p + 1) == '*') {
                do {
                    boolean isMatch = isMatch(input, pattern, i, p + 2);
                    if(isMatch) {
                        return true;
                    }
                    i++;
                } while(i < input.length() && (input.charAt(i) == pattern.charAt(p) || pattern.charAt(p) == '.'));
            } else if(input.charAt(i) == pattern.charAt(p) || pattern.charAt(p) == '.') {
                return isMatch(input, pattern, i + 1, p + 1);
            }

            return false;
        }
    }

    public boolean isMatch(String input, String pattern) {
        return isMatch(input, pattern, 0, 0);

    }
}
