package com.cc.practice.reverseInteger;

import org.junit.Assert;
import org.junit.Test;

public class ReverseIntegerTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(54321, solution.reverse(12345));
        Assert.assertEquals(0, solution.reverse(0));
        Assert.assertEquals(5, solution.reverse(5000));
        Assert.assertEquals(0, solution.reverse(0000000));
        Assert.assertEquals(-54321, solution.reverse(-12345));
        Assert.assertEquals(0, solution.reverse(1534236469));
        Assert.assertEquals(0, solution.reverse(-1534236469));
    }
}
