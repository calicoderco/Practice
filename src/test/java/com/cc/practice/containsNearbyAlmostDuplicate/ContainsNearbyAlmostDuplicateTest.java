package com.cc.practice.containsNearbyAlmostDuplicate;

import org.junit.Assert;
import org.junit.Test;

public class ContainsNearbyAlmostDuplicateTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(false, solution.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
    }
}
