package com.cc.practice.findKthLargest;

import org.junit.Assert;
import org.junit.Test;

public class FindKthLargestTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(6, solution.findKthLargest(new int[]{0,3,5,6,2,1,4,7}, 2));
    }
}
