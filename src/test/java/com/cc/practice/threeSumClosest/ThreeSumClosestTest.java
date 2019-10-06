package com.cc.practice.threeSumClosest;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSumClosestTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.threeSumClosest(new int[] {-5,-1,0,1,5}, 4));
        Assert.assertEquals(1, solution.threeSumClosest(new int[] {-5,-1,0,1,5}, 1));
        Assert.assertEquals(1, solution.threeSumClosest(new int[] {-5,-1,0,1,5}, 2));
        Assert.assertEquals(0, solution.threeSumClosest(new int[] {-5,-1,0,1,5}, 0));
        Assert.assertEquals(-5, solution.threeSumClosest(new int[] {-5,-1,0,1,5}, -5));
        Assert.assertEquals(-4, solution.threeSumClosest(new int[] {-5,-1,0,1,5}, -4));
        Assert.assertEquals(-4, solution.threeSumClosest(new int[] {-5,-1,0,1,5}, -3));
        Assert.assertEquals(-1, solution.threeSumClosest(new int[] {-5,-1,0,1,5}, -2));
        Assert.assertEquals(6, solution.threeSumClosest(new int[] {-5,-1,0,1,5}, 111));
        Assert.assertEquals(-6, solution.threeSumClosest(new int[] {-5,-1,0,1,5}, -113));
        Assert.assertEquals(82, solution.threeSumClosest(new int[] {1,2,4,8,16,32,64,128}, 82));
    }
}
