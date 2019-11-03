package com.cc.practice.uniquePaths;

import java.util.Arrays;

class Solution {

    //lots of solutions exist. you can do it straight mathematically using combinations, and even improve this method w/ single array for above and current
    public int uniquePaths(int m, int n) {
        int[] above = new int[n], current =  new int[n];
        Arrays.fill(above, 1);
        current[0] = 1;
        int row = 1;
        while(row <= m) {
            for(int column = 1; column < n; column++) {
                current[column] = current[column - 1] + above[column];
            }
            int[] temp = above;
            above = current;
            current = temp;
            row++;
        }
        return current[n - 1];
    }

    //combination solution: C(m + n - 2, n
}
