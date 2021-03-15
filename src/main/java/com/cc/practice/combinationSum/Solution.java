package com.cc.practice.combinationSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    //after reading, i learned this is called a backtracking solution
    //recursion beats 70% in both categories
    //recursion depth is the cause of the slower than 100% performance
    /*List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> current = new ArrayList<>();
        combinationSum(candidates, target, current, 0, results, 0);
        return results;
    }

    public void combinationSum(int[] candidates, int target, List<Integer> current, int sum, List<List<Integer>> results, int candidateStart) {
        for(int i = candidateStart; i < candidates.length; i++) {
            int c = candidates[i];
            int newSum = sum + c;
            if(newSum < target) {
                current.add(c);
                combinationSum(candidates, target, current, newSum, results, candidateStart);
                current.remove(current.size() - 1);
            } else if(newSum == target) {
                List<Integer> result = new LinkedList<>();
                current.add(c);
                result.addAll(current);
                current.remove(current.size() - 1);
                results.add(result);
            }
            candidateStart++;
        }
    }*/

    List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> current = new ArrayList<>();
        combinationSum(candidates, target, current, 0, results, 0);
        return results;
    }

    public void combinationSum(int[] candidates, int target, List<Integer> current, int sum, List<List<Integer>> results, int candidateStart) {
        for(int i = candidateStart; i < candidates.length; i++) {
            int c = candidates[i];
            int newSum = sum + c;
            int cAdded = 0;

            while(newSum < target) {
                current.add(c);
                combinationSum(candidates, target, current, newSum, results, i + 1);
                newSum += c;
                cAdded++;
            }

            if(newSum == target) {
                List<Integer> result = new LinkedList<>();
                current.add(c);
                result.addAll(current);
                current.remove(current.size() - 1);
                results.add(result);
            }

            for(int j = 0; j < cAdded; j++) {
                current.remove(current.size() - 1);
            }
        }
    }
}
