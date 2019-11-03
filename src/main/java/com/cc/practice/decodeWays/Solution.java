package com.cc.practice.decodeWays;

import java.util.Arrays;
public class Solution {

    //beats 98% and 100%
    public int numDecodings(String s) {
        if(s.charAt(0) - '1' < 0 || s.charAt(0) - '1' > 26) return 0;

        int[] pastTwo = new int[2];
        Arrays.fill(pastTwo, -1);
        pastTwo[0] = 1;
        pastTwo[1] = 0;

        for(int i = s.length() - 2; i >= 0; i--) {


            int numWays = 0;

            int twoDigit = (s.charAt(i + 1) - '0') + ((s.charAt(i) - '0') * 10);

            if(twoDigit == 0) {
                return 0;
            }

            if(twoDigit >= 10 && twoDigit <= 26) {
                if(i < s.length() - 2) {
                    if(s.charAt(i + 2) != '0') {
                        numWays += pastTwo[1];
                    }
                } else {
                    numWays += 1;
                }

                if(twoDigit != 10 && twoDigit != 20) {
                    numWays += pastTwo[0];
                }
            } else {
                if(twoDigit % 10 == 0) {
                    return 0;
                } else {
                    numWays += pastTwo[0];
                }
            }

            pastTwo[1] = pastTwo[0];
            pastTwo[0] = numWays;
        }


        return pastTwo[0];
    }
}