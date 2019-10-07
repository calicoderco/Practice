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
        Assert.assertEquals(-52, solution.threeSumClosest(new int[] {6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10},
                -52));
    }
}
