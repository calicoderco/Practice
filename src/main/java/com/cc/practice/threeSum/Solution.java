package com.cc.practice.threeSum;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Set<Integer>> valueToIndex = new HashMap<Integer, Set<Integer>>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> indices = valueToIndex.get(nums[i]);
            if (indices == null) {
                indices = new HashSet<>();
            }
            indices.add(i);
            valueToIndex.put(nums[i], indices);
        }

        List<List<Integer>> results = new LinkedList<>();
        Set<Integer> avoid = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] != nums[i - 1]) {
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(avoid.contains(nums[j])) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                int inverse = sum * -1;
                Set<Integer> indices = valueToIndex.get(inverse);
                if (indices != null && !indices.isEmpty()) {
                    if(!indices.isEmpty()) {
                        for(int index : indices) {
                            if(index > j) {
                                List<Integer> result = new LinkedList<Integer>();
                                result.add(nums[i]);
                                result.add(nums[j]);
                                result.add(inverse);
                                results.add(result);
                                avoid.add(inverse);
                                avoid.add(nums[j]);
                                break;
                            }
                        }
                    }
                }
            }
        }


        return results;
    }
}
    /*
    Map<Integer, List<Integer>> valueToIndex = new HashMap<Integer, List<Integer>>();

        for(int i = 0; i < nums.length; i++) {
            List<Integer> indices = valueToIndex.get(nums[i]);
            if(indices == null) {
                indices = new LinkedList<>();
            }
            indices.add(i);
            valueToIndex.put(nums[i], indices);
        }

        List<List<Integer>> results = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int inverse = sum * -1;
                List<Integer> indices = valueToIndex.get(inverse);
                if(indices != null) {
                    for(int index : indices) {
                        if(index != i && index != j) {
                            List<Integer> result = new LinkedList<Integer>();
                            result.add(nums[i]);
                            result.add(nums[j]);
                            result.add(nums[index]);
                            results.add(result);
                        }
                    }
                }
            }
        }

        return results;
    }
     */

     /*Set<List<Integer>> sumsToZero = new HashSet<>();
        Map<Integer, Set<Set<Integer>>> twoSums = new HashMap<>();


        for(int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for(int j = 0; j < nums.length; j++) {
                int num2 = nums[j];
                if(i != j) {
                    Set<Integer> indexesInSum = new HashSet<Integer>();
                    indexesInSum.add(i);
                    indexesInSum.add(j);

                    Set<Set<Integer>> listOfSumIndexSets = twoSums.getOrDefault(num1 + num2, new HashSet<Set<Integer>>());
                    listOfSumIndexSets.add(indexesInSum);

                    twoSums.put(num1 + num2, listOfSumIndexSets);
                }
            }
        }

        Set<Integer> considered = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!considered.contains(num)) {
                int inverse = num * -1;
                Set<Set<Integer>> listOfSumSets = twoSums.get(inverse);
                if(null != listOfSumSets) {
                    for(Set<Integer> indexSet : listOfSumSets) {
                        if(!indexSet.contains(i)) {
                            List<Integer> sumToZero = new LinkedList<Integer>();
                            for(int index : indexSet) {
                                sumToZero.add(nums[index]);
                            }
                            sumToZero.add(nums[i]);
                            sumsToZero.add(sumToZero);
                        }
                    }
                }
            }
        }

        List<List<Integer>> answer = new LinkedList<>();
        for(List<Integer> sumToZero : sumsToZero) {
            answer.add(new LinkedList<>(sumToZero));
        }*/