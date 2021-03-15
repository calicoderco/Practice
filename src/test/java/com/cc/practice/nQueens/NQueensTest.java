package com.cc.practice.nQueens;

import org.junit.Test;

import java.util.List;

public class NQueensTest {
    private static final int chessBoardSize = 8;

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<String>> results = solution.solveNQueens(chessBoardSize);
        for(List<String> result : results) {
            for(String row : result) {
                System.out.println(row);
            }

            for(int i = 0; i < chessBoardSize; i++) {
                System.out.print('-');
            }
            System.out.println();
        }
    }
}
