package com.cc.practice.networkDelayTime;

import org.junit.Test;

public class NetworkDelayTimeTest {

    @Test
    public void test() {
        int numNodes = 5;
        int startNode = 1;
        String inputString = "[[2,4,10],[5,2,38],[3,4,33],[4,2,76],[3,2,64],[1,5,54],[1,4,98]," +
                "[2,3,61],[2,1,0],[3,5,77],[5,1,34],[3,1,79],[5,3,2],[1,2,59],[4,3,46],[5,4,44]," +
                "[2,5,89],[4,5,21],[1,3,86],[4,1,95]]";

        String[] arrStrings = inputString.substring(1, inputString.length() - 1).split("\\],\\[");
        int[][] inputs = new int[arrStrings.length][2];
        int i = 0;
        for(String arrString : arrStrings) {
            String withoutBrackets = arrString.replace("[","").replace("]", "");
            String[] parts = withoutBrackets.split(",");
            int[] input = new int[3];
            input[0] = Integer.parseInt(parts[0]);
            input[1] = Integer.parseInt(parts[1]);
            input[2] = Integer.parseInt(parts[2]);
            inputs[i] = input;
            i++;
        }

        Solution solution = new Solution();
        int result = solution.networkDelayTime(inputs, numNodes, startNode);
        System.out.println("result: " + result);
    }
}
