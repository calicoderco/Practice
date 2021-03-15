package com.cc.practice.permutations;

import org.junit.Test;

import java.util.List;

public class PermutationsTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<Integer>> results = solution.permute(new int[]{1,2,3});
        print(results);
    }

    public static void print(List<List<Integer>> results) {
        for(List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
