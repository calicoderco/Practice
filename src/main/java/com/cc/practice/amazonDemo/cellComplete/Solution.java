package com.cc.practice.amazonDemo.cellComplete;

import java.util.ArrayList;
import java.util.List;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days) {
        List<Integer> result = new ArrayList<>();
        result.add(0);

        for(int state : states) result.add(state);

        result.add(0);

        for(int i = 0; i < days; i++) {
            int value = Integer.MIN_VALUE;
            for(int x = 1; x < result.size() - 1; x++) {
                int tempValue = value;
                value = result.get(x - 1) == result.get(x + 1) ? 1 : 0;
                if(tempValue != Integer.MIN_VALUE) {
                    result.set(x - 1, tempValue);
                }
            }
            result.set(result.size() - 1, value);
        }

        result.remove(0);
        result.remove(result.size() - 1);

        return result;
    }
    // METHOD SIGNATURE ENDS
}
