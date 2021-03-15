package com.cc.practice.minimumHeightTrees;

import org.junit.Test;

import java.util.List;

public class MinimumHeightTreesTest {

    @Test
    public void test() {
        int numNodes = 6;
        String inputString = "[3,0],[3,1],[3,2],[3,4],[5,4]";
        String[] arrStrings = inputString.substring(1, inputString.length() - 1).split("\\],\\[");
        int[][] inputs = new int[arrStrings.length][2];
        int i = 0;
        for(String arrString : arrStrings) {
            String withoutBrackets = arrString.replace("[","").replace("]", "");
            String[] parts = withoutBrackets.split(",");
            int[] input = new int[2];
            input[0] = Integer.parseInt(parts[0]);
            input[1] = Integer.parseInt(parts[1]);
            inputs[i] = input;
            i++;
        }

        Solution solution = new Solution();
                                                                                                                                                           List<Integer> result = solution.findMinHeightTrees(numNodes, inputs);
        System.out.println(result.toString());
    }
}
