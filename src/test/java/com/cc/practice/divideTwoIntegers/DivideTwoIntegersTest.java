package com.cc.practice.divideTwoIntegers;

import org.junit.Assert;
import org.junit.Test;

public class DivideTwoIntegersTest {

    @Test
    public void test() {

        /*System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(Integer.MAX_VALUE + 1);*/




        Solution solution = new Solution();

        /*Assert.assertEquals(16 / 2, solution.divide(16, 2));
        Assert.assertEquals(17 / 9, solution.divide(17, 9));
        Assert.assertEquals(15 / 9, solution.divide(17, 9));
        Assert.assertEquals(30 / 4, solution.divide(-30, -4));
        Assert.assertEquals(5, solution.divide(-30, -6));
        Assert.assertEquals(6, solution.divide(-30, -5));
        Assert.assertEquals(15, solution.divide(-30, -2));
        Assert.assertEquals(-5, solution.divide(30, -6));
        Assert.assertEquals(-6, solution.divide(30, -5));
        Assert.assertEquals(-15, solution.divide(30, -2));*/
        Assert.assertEquals(-1073741824, solution.divide(-2147483648,2));
    }
}
