package com.cc.practice.reverseInteger;

class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            if((result > (Integer.MAX_VALUE - digit) / 10 && x > 0) || (result < (Integer.MIN_VALUE - digit) / 10 && x < 0)) {
                return 0;
            }
            result *= 10;
            result += digit;
            x = x / 10;
        }

        return result;
    }
}
