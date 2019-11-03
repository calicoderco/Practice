package com.cc.practice.wordSearch;

import org.junit.Assert;
import org.junit.Test;

public class WordSearchTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(true, solution.exist(new char[][]{new char[]{'a','b'}}, "ba"));
    }
}
