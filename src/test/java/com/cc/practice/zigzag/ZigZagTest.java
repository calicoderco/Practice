package com.cc.practice.zigzag;

import org.junit.Assert;
import org.junit.Test;

public class ZigZagTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals("aibhcgdfe", solution.convert("abcdefghi", 5));
        Assert.assertEquals("agbfhceid", solution.convert("abcdefghi", 4));
        Assert.assertEquals("acegibdfh", solution.convert("abcdefghi", 2));
        Assert.assertEquals("abcdefghi", solution.convert("abcdefghi", 1));

        Exception ex = null;
        try {
            Assert.assertEquals("abcdefghi", solution.convert("abcdefghi", 0));
        } catch(IllegalArgumentException e) {
            ex = e;
        }
        Assert.assertNotNull(ex);
    }
}
