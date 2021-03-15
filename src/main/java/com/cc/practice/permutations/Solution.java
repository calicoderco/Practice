package com.cc.practice.permutations;

import java.util.LinkedList;
import java.util.List;

class Solution {
    /*public List<List<Integer>> permute(int[] nums) {
<<<<<<< HEAD
        return permute(nums, 0);
    }

    public List<List<Integer>> permute(int[] nums, int i) {
        List<List<Integer>> permutations = new LinkedList<>();

        if(i < nums.length) {
            List<List<Integer>> subPermutations = permute(nums, i + 1);
            if(subPermutations.size() == 0 ) {
                List<Integer> permutation = new ArrayList<>();
                permutation.add(nums[i]);
                permutations.add(permutation);
            } else {
                for (List<Integer> subPermutation : subPermutations) {
                    for (int j = 0; j <= subPermutation.size(); j++) {
                        List<Integer> permutation = new ArrayList<>();
                        for (Integer element : subPermutation) {
                            permutation.add(element);
                        }
                        permutation.add(j, nums[i]);
                        permutations.add(permutation);
                    }
                }
            }
        }

        return permutations;
    }*/

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> input = new LinkedList<Integer>();
        for(int num : nums) {
            input.add(num);
        }
        List<List<Integer>> output = new LinkedList<>();
        int factorial = 1;
        for(int i =1; i <= nums.length; factorial *= i++);
        for(int i = 0; i < input.size(); i++) {
            int removed = input.remove(0);
            for(int j = 0; j < factorial; j++) {
                List<Integer> building = new LinkedList<Integer>();
                building.add(removed);
                permute(input, building);
                input.add(removed);
                output.add(building);
            }
        }
        return output;
    }

    public void permute(List<Integer> input, List<Integer> building) {
        int size = input.size();
        for(int i = 0; i < size; i++) {
            int removed = input.remove(0);
            building.add(removed);
            permute(input, building);
            input.add(removed);
        }
    }

}
