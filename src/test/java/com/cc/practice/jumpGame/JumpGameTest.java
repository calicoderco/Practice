package com.cc.practice.jumpGame;

import org.junit.Assert;
import org.junit.Test;

public class JumpGameTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.jump(new int[]{3,2,1}));
    }
}
