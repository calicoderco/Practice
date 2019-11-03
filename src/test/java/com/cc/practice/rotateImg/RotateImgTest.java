package com.cc.practice.rotateImg;

import org.junit.Test;

public class RotateImgTest {

    @Test
    public void test() {
        int[][] input = new int[][]{
                new int[]{11,12,13,14},
                new int[]{15,16,17,18},
                new int[]{19,20,21,22},
                new int[]{23,24,25,26}
        };


        Solution solution = new Solution();
        solution.print(input);
        solution.rotate(input);
        System.out.println();
        System.out.println();
        solution.print(input);
    }
}
