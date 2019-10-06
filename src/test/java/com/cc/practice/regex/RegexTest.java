package com.cc.practice.regex;

import org.junit.Assert;
import org.junit.Test;

public class RegexTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        //Assert.assertTrue(solution.isMatch("abc", "abc"));
        Assert.assertTrue(solution.isMatch("abbcc", "a*b*c*"));
//        Assert.assertTrue(solution.isMatch("abcc", "a*b*c*"));
//        Assert.assertTrue(solution.isMatch("", "a*b*c*"));
//        Assert.assertTrue(solution.isMatch("", "c*"));
//        Assert.assertTrue(solution.isMatch("c", "c*"));
//        Assert.assertTrue(solution.isMatch("ccc", "c*"));
//        Assert.assertTrue(solution.isMatch("d", "c*"));

    }
}
