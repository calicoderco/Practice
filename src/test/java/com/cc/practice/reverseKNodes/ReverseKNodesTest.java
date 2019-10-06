package com.cc.practice.reverseKNodes;

import org.junit.Assert;
import org.junit.Test;

public class ReverseKNodesTest {

    @Test
    public void test() {
        test(new int[]{1,2,3,4,5,6,7,8}, 4, new int[]{4,3,2,1,8,7,6,5});
        test(new int[]{1,2,3,4,5,6,7,8,9,10,11}, 4, new int[]{4,3,2,1,8,7,6,5,9,10,11});
        test(new int[]{1,2,3,4,5,6,7,8,9}, 3, new int[]{3,2,1,6,5,4,9,8,7});
        test(new int[]{1,2,3,4,5,6,7,8,9}, 1, new int[]{1,2,3,4,5,6,7,8,9});
        test(new int[]{1,2,3,4,5,6,7,8,9}, 9, new int[]{9,8,7,6,5,4,3,2,1});
    }

    public void test(int[] inputList,int k , int[] expectedOutput) {
        Solution solution = new Solution();
        ListNode list = solution.buildList(inputList);
        ListNode reversed = solution.reverseKGroup(list, k);
        ListNode expected = solution.buildList(expectedOutput);
        Assert.assertTrue(String.format("Expecting %s but found %s ", expected.toString(), reversed.toString()), solution.equals(expected,reversed));
    }
}
