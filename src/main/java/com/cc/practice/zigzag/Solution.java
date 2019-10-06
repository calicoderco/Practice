package com.cc.practice.zigzag;

public class Solution {

    public String convert(String input, int rows) {
        if(rows <= 0) {
            throw new IllegalArgumentException(String.format("rows must be greater than 0 but is %d", rows));
        }

        char[] inArr = input.toCharArray();

        if(rows > 1) {
            int i = 0;

            StringBuilder builder = new StringBuilder();

            for(i = 0; i < inArr.length; i += 2*rows -2) {
                builder.append(inArr[i]);
            }

            for(int row = 2; row <= rows - 1; row++) {
                boolean inner = false;
                i = row - 1;
                while(i < inArr.length) {
                    builder.append(inArr[i]);

                    if(inner) {
                        i += 2*(row - 1);
                    } else {
                        i += 2*(rows - row);
                    }

                    inner = !inner;
                }
            }

            if(rows >= 2) {
                for(i = rows - 1; i < inArr.length; i += 2*rows -2) {
                    builder.append(inArr[i]);
                }
            }
            return builder.toString();
        } else return input;
    }
}
