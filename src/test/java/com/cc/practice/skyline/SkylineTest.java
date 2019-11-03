package com.cc.practice.skyline;

import org.junit.Test;

import java.util.List;

public class SkylineTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<Integer>> results = null;
        /*results = solution.getSkyline(new int[][]{new int[]{1, 5, 5}, new int[]{6,10,5}});
        for(List<Integer> result : results) {
            System.out.println(result.get(0) + ", " + result.get(1));
        }

        System.out.println("-----");

        results = solution.getSkyline(new int[][]{new int[]{1, 15, 4}, new int[]{2,5,10}, new int[]{2,8,9},});
        for(List<Integer> result : results) {
            System.out.println(result.get(0) + ", " + result.get(1));
        }

        System.out.println("-----");

        results = solution.getSkyline(new int[][]{new int[]{1, 15, 4}});
        for(List<Integer> result : results) {
            System.out.println(result.get(0) + ", " + result.get(1));
        }

        System.out.println("-----");*/

        results = solution.getSkyline(new int[][]{new int[]{2,9,10}, new int[]{3,7,15}, new int[]{5,12,12}, new int[]{15,20,10}, new int[]{19,24,8}});
        for(List<Integer> result : results) {
            System.out.println(result.get(0) + ", " + result.get(1));
        }

        System.out.println("-----");
    }
}
