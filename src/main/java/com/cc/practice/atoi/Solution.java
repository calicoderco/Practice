package com.cc.practice.atoi;

class Solution {
    public int myAtoi(String str) {
        if(str == "") {
            return 0;
        }

        int i = 0;
        while(i < str.length()) {
            if(str.charAt(i) == ' ') {
                i++;
            } else break;
        }
        if(i >= str.length()) return 0;

        char c = str.charAt(i);

        int multiplier = 1;
        switch(c) {
            case '-':
                multiplier = -1;
            case '+':
                if(i == str.length() - 1) { return 0; }
                i++;
                c = str.charAt(i);
            default:
                if(Character.isAlphabetic(c)) {
                    return 0;
                } else {
                    int result = 0;
                    while(Character.isDigit(c) && i < str.length()) {

                        int val = Character.getNumericValue(c);
                        if(multiplier < 0) {
                            if((Integer.MIN_VALUE + val) / 10 > result) {
                                return Integer.MIN_VALUE;
                            }
                            result *= 10;
                            result -= val;
                        } else {
                            if((Integer.MAX_VALUE - val) / 10 < result)  {
                                return Integer.MAX_VALUE;
                            }
                            result *= 10;
                            result += val;
                        }
                        i++;
                        if(i < str.length()) {
                            c = str.charAt(i);
                        }
                    }
                    return result;
                }
        }
    }
}
