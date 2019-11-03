package com.cc.practice.uniquePaths;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(6, solution.uniquePaths(3, 3));
    }
}
