package com.cc.practice.fourSum;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSumTest {

    @Test
    public void test() {
        Solution solution = new Solution();

        List<List<Integer>> results;


        /*results = solution.fourSum(new int[]{1,2,2,3,4,5,6}, 5);
        test(results, new int[]{1,2,2});
        results = solution.fourSum(new int[]{1,1,2,2,3,4,5,6,2}, 7);
        test(results, new int[]{1,2,2,2});
        test(results, new int[]{2,1,1,3});*/



        /*results = solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        Assert.assertTrue(test(results, new int[]{-2,-1,1,2}));
        Assert.assertTrue(test(results, new int[]{-2,0,0,2}));
        Assert.assertTrue(test(results, new int[]{-1,0,0,1}));*/


        /*results = solution.fourSum(new int[]{0,0,0,0}, 0);
        Assert.assertTrue(test(results, new int[]{0,0,0,0}));*/

        results = solution.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
        //Assert.assertTrue(test(results, new int[]{0,0,0,0}));
    }

    public boolean test(List<List<Integer>> results, int[] result) {
        Set<Integer> resultSet = new HashSet<>();
        for(int r : result) {
            resultSet.add(r);
        }

        for(List<Integer> res : results) {
            boolean matches = true;

            for(Integer r : res) {
                if(!resultSet.contains(r)) {
                    matches = false;
                    break;
                }
            }

            if(matches) {
                return true;
            }
        }
        return false;
    }
}
