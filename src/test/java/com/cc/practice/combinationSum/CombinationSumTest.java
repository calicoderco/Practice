package com.cc.practice.combinationSum;


import org.junit.Test;

import java.util.List;

public class CombinationSumTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<Integer>> results = solution.combinationSum(new int[]{1,2,3,4}, 8);
        print(results);
    }

    void print(List<List<Integer>> results) {
        for(List<Integer> result : results) {
            for(int r : result) {
                System.out.print(r);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
