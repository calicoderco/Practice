package com.cc.practice.threeSum;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<Integer>> results = solution.threeSum(new int[] {-1,0,1,2,-1,-4});
        for(List<Integer> result : results) {
            int i = 0;
            for(Integer r  : result) {
                System.out.print(r);
                if(i < 2) {
                    System.out.print(',');
                }
                i++;
            }
            System.out.println();
        }

        //Assert.assertEquals(new int[]{1,2}, new int[]{2,1});
        /*Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(-3);
        set2.add(1);
        set2.add(2);

        Assert.assertEquals(set1, set2);*/
    }
}
