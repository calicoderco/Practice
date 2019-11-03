package com.cc.practice.restoreIPAddresses;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new LinkedList<>();
        char[] result = new char[s.length() + 3];
        restoreIpAddresses(s, results, result, 0,0, 3);
        return results;
    }

    public void restoreIpAddresses(String s, List<String> results, char[] result, int sPos, int rPos, int decNum) {
        if(decNum == 0) {
            if(s.length() - sPos == result.length - rPos) {
                while(sPos < s.length()) {
                    result[rPos] = s.charAt(sPos);
                    sPos++;
                    rPos++;
                }
                results.add(new String(result));
            }
        } else {
            int width = 1;
            while (width <= (s.charAt(sPos) == '0' ? 1 : 3)) {
                int decPos = rPos + width;
                int nextSPos = sPos + width;
                int charsLeftInS = (s.length() - 1) - (nextSPos - 1);
                if(charsLeftInS > decNum - 1 && charsLeftInS <= decNum*3) {
                    for(int i = sPos, j = rPos; i < nextSPos; i++, j++) {
                        result[j] = s.charAt(i);
                    }
                    result[decPos] = '.';
                    restoreIpAddresses(s, results, result, nextSPos, decPos + 1,  decNum - 1);
                }
                width += 1;
            }
        }
    }
}
