package com.cc.practice.sudokuSolver;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<Character>();
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[3];

        for(int i = 0; i < 3; i++) {
            boxes[i] = new HashSet<Character>();
            for(int j = 0; j < 3; j++) {
                columns[(i * 3)  + j] = new HashSet<Character>();
            }
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(columns[j].contains(board[i][j])) {
                        return false;
                    } else {
                        columns[j].add(board[i][j]);
                    }

                    Set<Character> box = boxes[j /  3];
                    if(box.contains(board[i][j])) {
                        return false;
                    } else {
                        box.add(board[i][j]);
                    }

                    if(row.contains(board[i][j])) {
                        return false;
                    } else {
                        row.add(board[i][j]);
                    }
                }
            }

            row.clear();

            if(i % 3 == 2) {
                for(Set<Character> box : boxes) {
                    box.clear();
                }
            }
        }

        return true;
    }
}
