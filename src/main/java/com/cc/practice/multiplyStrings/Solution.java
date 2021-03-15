package com.cc.practice.multiplyStrings;

class Solution {

    //better than 100% memory
    public String multiply(String num1, String num2) {
        StringBuilder answer = new StringBuilder("");
        for(int i = 0; i < num1.length() + num2.length(); i++) {
            answer.append("0");
        }

        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';

                int pos = (i + j) + 1;
                int c = answer.charAt(pos) - '0';
                int sum = (a * b) + c;

                while(sum > 0) {
                    int digit = sum % 10;
                    sum /= 10;
                    answer.setCharAt(pos, Character.forDigit(digit,10));
                    pos--;
                    if(pos >= 0 && pos < answer.length()) {
                        sum += answer.charAt(pos) - '0';
                    }
                }
            }
        }

        int i = 0;
        while(i < answer.length() && answer.charAt(i) == '0') {
            answer.delete(i, i + 1);
        }

        if(answer.length() == 0) {
            answer.append("0");
        }

        return answer.toString();
    }
}
