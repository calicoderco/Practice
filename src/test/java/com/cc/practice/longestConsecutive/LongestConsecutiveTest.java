package com.cc.practice.longestConsecutive;

import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutiveTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.longestConsecutive(new int[] {-6,-9,8,-8,-1,-3,-6,8,-9,-1,-4,-8,-5,0,1,6,-8,-5,-7,8,-2,-8,4,5,-5,-1,-5}));
    }
}
