package com.cc.practice.longestValidParenthesis;

import org.junit.Assert;
import org.junit.Test;

public class LongestValidParenthesisTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.longestValidParentheses("(((()"));
        Assert.assertEquals(2, solution.longestValidParentheses("())))"));
        Assert.assertEquals(4, solution.longestValidParentheses("(())))"));
        Assert.assertEquals(4, solution.longestValidParentheses("()())))"));
        Assert.assertEquals(6, solution.longestValidParentheses("(((()()()"));
        Assert.assertEquals(8, solution.longestValidParentheses("()()()()(((()()()"));
        Assert.assertEquals(8, solution.longestValidParentheses("))))))))()()()()(((()()()"));
        Assert.assertEquals(8, solution.longestValidParentheses("))))))))()()()()(((()()("));
        Assert.assertEquals(4, solution.longestValidParentheses("(((()()("));
    }

}
