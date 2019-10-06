package com.cc.practice.findSubstring;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubstringTest {

    @Test
    public void test() {
        /*Solution solution = new Solution();
        List<Integer> result = solution.findSubstring("theboobofagesasasdtheboobofages", new String[] {"the", "boob", "of", "age"});
        Set<Integer> resultSet = new HashSet<Integer>();
        resultSet.addAll(result);
        Assert.assertTrue(resultSet.contains(0));
        Assert.assertTrue(resultSet.contains(18));*/

        Solution solution = new Solution();
        List<Integer> result = solution.findSubstring("abababab", new String[] {"a","b","a"});
        Set<Integer> resultSet = new HashSet<Integer>();
        resultSet.addAll(result);
        Assert.assertTrue(resultSet.contains(0));
        Assert.assertTrue(resultSet.contains(2));
        Assert.assertTrue(resultSet.contains(4));

    }
}
