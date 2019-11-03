package com.cc.practice.longestValidParenthesis;

import java.util.*;

class Solution {
    /* probably works but inefficient for "((((((((()"
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 0;
        int stackHeight = 0;
        int maxLength = 0;
        int nextI = 1;
        while(j < chars.length) {
            while(stackHeight >= 0 && j < chars.length) {
                switch(chars[j]) {
                    case '(':
                        stackHeight++;
                        break;
                    case ')':
                        stackHeight--;
                        break;
                }
                if(stackHeight == 0) {
                    maxLength = Math.max(maxLength, j - i + 1);
                    nextI = j + 1;
                }
                j++;
            }

            if(stackHeight == -1) {
                maxLength = Math.max(maxLength, j - i);
            } else if(stackHeight > 0) {

                i = nextI;
                j = nextI;
                nextI = i + 1;
                stackHeight = 0;
            }
        }

        return maxLength;

    }*/

    /* 21% speed, 100% memory */
    public int longestValidParentheses(String s) {
        int j = 0;
        int stackHeight = 0;
        int maxLength = 0;
        int startingPoint = 0;
        Map<Integer, Integer> map = new HashMap<>(); //index from stack height to the first index known to have that stack height
        while(j < s.length()) {
            switch (s.charAt(j)) {
                case '(':
                    stackHeight++;
                    break;
                case ')':
                    stackHeight--;
                    if(stackHeight >= 0) {
                        Integer index = map.getOrDefault(stackHeight + 1, startingPoint);
                        maxLength = Math.max(maxLength, j - index + 1);
                        map.remove(stackHeight + 2);
                    } else {
                        startingPoint = j + 1;
                        map = new HashMap<>();
                        stackHeight = 0;
                    }
                    break;
            }

            if(stackHeight >= 0 && !map.containsKey(stackHeight)) {
                map.put(stackHeight, j);
            }

            j++;
        }

        return maxLength;
    }
}
