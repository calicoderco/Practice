package com.cc.practice.addBinary;

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int carryOver = 0, i = a.length() - 1, j = b.length() - 1;

        while(i >= 0) {
            int charA = 0, charB = 0;
            charA = a.charAt(i) - '0';
            if(j >= 0) {
                charB = b.charAt(j) - '0';
            }
            carryOver = compute(charA + charB + carryOver, builder);
            i--;
            j--;
        }

        while(j >= 0) {
            int charA = 0, charB = 0;
            charB = b.charAt(j) - '0';
            carryOver = compute(charA + charB + carryOver, builder);
            j--;
        }

        if(carryOver == 1) {
            builder.insert(0, '1');
        }

        return builder.toString();
    }

    private int compute(int result, StringBuilder builder) {
        switch(result) {
            case 2:
            case 0:
                builder.insert(0, '0');
                break;
            case 3:
            case 1:
                builder.insert(0, '1');
                break;
        }
        return result >= 2 ? 1 : 0;
    }
}
