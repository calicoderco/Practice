package com.cc.practice.minWindowSubstring;

import org.junit.Assert;
import org.junit.Test;

public class MinWindowSubstringTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals("AB0000C", solution.minWindow("00AB0000C00","ABC"));
        Assert.assertEquals("C00AB", solution.minWindow("C00AB0000C00","ABC"));
        Assert.assertEquals("A00C00B", solution.minWindow("0C00A00C00B000C00","ABC"));
        Assert.assertEquals("A00C00B000C00D", solution.minWindow("0C00A00C00B000C00D00","ABCD"));
        Assert.assertEquals("BANC", solution.minWindow("ADOBECODEBANC","ABC"));
        Assert.assertEquals("aa", solution.minWindow("aa","aa"));
        Assert.assertEquals("ba", solution.minWindow("bba","ab"));
        Assert.assertEquals("baa", solution.minWindow("bbaac","aba"));

    }
}
