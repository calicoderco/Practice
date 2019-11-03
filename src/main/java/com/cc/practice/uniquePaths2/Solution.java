package com.cc.practice.uniquePaths2;

import java.util.Arrays;

class Solution {
    //better than 100% and 70%

    //solved this but then tried to get 100/100 and got bored - whatever
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length > obstacleGrid[0].length) {
            int[] current = new int[obstacleGrid[0].length];
            Arrays.fill(current, 0);
            current[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            int row = 0;

            while(row < obstacleGrid.length) {
                for(int column = 0; column < obstacleGrid[0].length; column++) {
                    if(obstacleGrid[row][column] == 1) {
                        current[column] = 0;
                        continue;
                    } else {
                        if(row == 0 && column > 0) {
                            current[column] = current[column - 1];
                        } else if(column == 0 && row > 0) {
                        } else if(column > 0 && row > 0) {
                            current[column] = current[column - 1] + current[column];
                        }
                    }
                }
                row++;
            }

            return current[current.length - 1];
        } else {
            int[] currentColumn = new int[obstacleGrid.length];
            Arrays.fill(currentColumn, 0);
            currentColumn[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
            int column = 0;

            while(column < obstacleGrid.length - 1) {
                for(int row = 0; row < obstacleGrid[0].length; row++) {
                    if(obstacleGrid[row][column] == 1) {
                        currentColumn[row] = 0;
                        continue;
                    } else {
                        if(row == 0 && column > 0) {
                        } else if(column == 0 && row > 0) {
                            currentColumn[row] = currentColumn[row - 1];
                        } else if(column > 0 && row > 0) {
                            currentColumn[row] = currentColumn[row - 1] + currentColumn[row];
                        }
                    }
                }
                column++;
            }

            return currentColumn[currentColumn.length - 1];
        }
    }
}
