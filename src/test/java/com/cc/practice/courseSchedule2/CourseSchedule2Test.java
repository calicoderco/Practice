package com.cc.practice.courseSchedule2;

import org.junit.Test;

public class CourseSchedule2Test {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] order = solution.findOrder(2, new int[][]{new int[]{1,0}});
        for(int i = 0; i < order.length; i++) {
            System.out.println(order[i]);
        }
    }
}
