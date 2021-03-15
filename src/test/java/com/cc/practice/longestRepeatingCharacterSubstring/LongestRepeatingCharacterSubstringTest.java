package com.cc.practice.longestRepeatingCharacterSubstring;

import org.junit.Assert;
import org.junit.Test;

public class LongestRepeatingCharacterSubstringTest {

    @Test
    public void test() {
        Solution solution;
        /*Solution solution = new Solution();
        Assert.assertEquals(5, solution.characterReplacement("ABABA", 2));
        solution = new Solution();
        Assert.assertEquals(3, solution.characterReplacement("ABABA", 1));
        solution = new Solution();
        Assert.assertEquals(3, solution.characterReplacement("ABABA", 1));*/
        solution = new Solution();
        Assert.assertEquals(5, solution.characterReplacement("BCCBBAA", 1));
    }
}
