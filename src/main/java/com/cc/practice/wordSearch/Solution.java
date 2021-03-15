package com.cc.practice.wordSearch;

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length ; j++) {
                if(board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    if(exist(board, word, used, i , j, 1)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word, boolean[][] used, int i, int j, int w) {
        if(w >= word.length()) {
            return true;
        }

        char nextChar = word.charAt(w);
        if(j < board[0].length - 1 && !used[i][j + 1] && board[i][j + 1] == nextChar) {
            used[i][j + 1] = true;
            if(exist(board, word, used, i, j + 1, w + 1)) return true;
            used[i][j + 1] = false;
        }

        if(j > 0 && !used[i][j - 1] && board[i][j - 1] == nextChar) {
            used[i][j - 1] = true;
            if(exist(board, word, used, i, j - 1, w + 1)) return true;
            used[i][j - 1] = false;
        }

        if(i < board.length - 1 && !used[i + 1][j] && board[i + 1][j] == nextChar) {
            used[i + 1][j] = true;
            if(exist(board, word, used, i + 1, j, w + 1)) return true;
            used[i + 1][j] = false;
        }

        if(i > 0 && !used[i - 1][j] && board[i - 1][j] == nextChar) {
            used[i - 1][j] = true;
            if(exist(board, word, used, i - 1, j, w + 1)) return true;
            used[i - 1][j] = false;
        }

        return false;
    }
}
