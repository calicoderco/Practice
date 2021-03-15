package com.cc.practice.sqrt;

import org.junit.Assert;
import org.junit.Test;

public class SQRTTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.mySqrt(4));
        Assert.assertEquals(2, solution.mySqrt(5));
        Assert.assertEquals(2, solution.mySqrt(6));
        Assert.assertEquals(3, solution.mySqrt(9));
    }
}
