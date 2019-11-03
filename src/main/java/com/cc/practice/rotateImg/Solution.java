package com.cc.practice.rotateImg;

class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length <= 1) {
            return;
        }

        int size = matrix.length; // the length and width of the currently considered square, initially the whole square
        int initialSize = matrix.length;
        int firstI = 0;
        while(size > 1) {
            int temp = 0; //stores the currently displaced number
            for(int firstJ = firstI; firstJ < firstI + size - 1; firstJ++) {
                int i = firstI, j = firstJ;
                do {
                    int t = matrix[i][j];
                    matrix[i][j] = temp;
                    temp = t;
                    int tempI = i;
                    i = j;
                    j = initialSize - 1 - tempI;
                } while(!(i == firstI && j == firstJ));
                matrix[i][j] = temp;
            }
            firstI++;
            size -= 2;
        }
    }

    public void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
                if(j != matrix.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
