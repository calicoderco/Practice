package com.cc.practice.trappingRainWater;

import org.junit.Assert;
import org.junit.Test;

public class TrappingRainWaterTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.trap(new int[]{2,4,2,4}));
        Assert.assertEquals(5, solution.trap(new int[]{4,1,2,4}));
        Assert.assertEquals(0, solution.trap(new int[]{2,4,4,4}));
        Assert.assertEquals(0, solution.trap(new int[]{4,4,4,2}));
        Assert.assertEquals(0, solution.trap(new int[]{2,4,4,2}));
        Assert.assertEquals(0, solution.trap(new int[]{2,4,2}));
        Assert.assertEquals(2, solution.trap(new int[]{4,1,3}));
    }
}
