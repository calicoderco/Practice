package com.cc.practice.uniquePaths;

import java.util.Arrays;
import java.util.Map;

public class Solution {

    /*public int uniquePaths(int m, int n) {
        return uniquePaths(squares, m , n, 1, 1);
    }

    /*private int uniquePaths(int m, int n, int i, int j) {
        if(i == m) return 1; // can only go right

        if(j == n) return 1; // can only go down

        return uniquePaths(m, n, i + 1, j) + uniquePaths(m, n, i, j + 1);
    }*/

    public int uniquePaths(int m, int n) {
        int[] memo = new int[m * n];
        Arrays.fill(memo, -1);
        uniquePaths(memo, m , n, 1, 1);
        return memo[(m * n) - 1];
    }

    public void uniquePaths(int[] memo, int m, int n, int i, int j) {
        if(i <= m && j <= n) {
            if(i != 1 && j != 1) {
                if(memo[(i * j) - 1] < 0) {
                    memo[(i * j) - 1] = (i - 1 == 1 ? 1 : memo[((i - 1) * j) - 1]) + (j - 1 == 1 ? 1 : memo[(i * (j - 1))- 1]);
                }
            }

            if(j >= i) {
                uniquePaths(memo, m, n, i, j + 1); // go right
                uniquePaths(memo, m, n, i + 1, j); // go down
            } else {
                uniquePaths(memo, m, n, i + 1, j); // go down
                uniquePaths(memo, m, n, i, j + 1); // go right
            }
        }
    }

}
