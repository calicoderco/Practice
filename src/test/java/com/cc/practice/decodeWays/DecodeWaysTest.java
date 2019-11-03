package com.cc.practice.decodeWays;

import org.junit.Assert;
import org.junit.Test;

public class DecodeWaysTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.numDecodings("12"));
    }
}
