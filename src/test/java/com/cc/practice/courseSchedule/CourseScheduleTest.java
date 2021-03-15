package com.cc.practice.courseSchedule;

import org.junit.Assert;
import org.junit.Test;

public class CourseScheduleTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        Assert.assertEquals(true, solution.canFinish(2, new int[][]{new int[]{1,0}}));
    }
}
