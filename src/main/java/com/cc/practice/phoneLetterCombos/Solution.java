package com.cc.practice.phoneLetterCombos;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {

        LinkedList<String> output = new LinkedList<String>();
        if(digits.length() > 0) {
            letterCombinations(output, digits, 0, "");
        }
        return output;
    }

    private void letterCombinations(List<String> output, String digits, int i, String current) {
        if(i == digits.length()) {
            output.add(current);
        } else {
            char[] numbers = getNumbers(digits.charAt(i));
            for(char c : numbers) {
                if(c == '1') {
                    letterCombinations(output, digits, i + 1, current);
                } else {
                    letterCombinations(output, digits, i + 1, current + c);
                }
            }
        }
    }

    private char[] getNumbers(char c) {
        return numbers[Character.getNumericValue(c) - 2];
    }

    private static char[][] numbers = new char[][]{
            new char[]{'a','b','c'},
            new char[]{'d','e','f'},
            new char[]{'g','h','i'},
            new char[]{'j','k','l'},
            new char[]{'m','n','o'},
            new char[]{'p','q','r','s'},
            new char[]{'t','u','v'},
            new char[]{'w','x','y','z'}};
}
