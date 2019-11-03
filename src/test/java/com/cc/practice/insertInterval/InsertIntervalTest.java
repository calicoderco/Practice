package com.cc.practice.insertInterval;

import org.junit.Test;

public class InsertIntervalTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] results = solution.insert(new int[][]{ new int[]{3, 4}, new int[]{5, 6}, new int[]{7, 8}, new int[]{15, 19} }, new int[]{21, 22});
        for(int[] result : results) {
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
