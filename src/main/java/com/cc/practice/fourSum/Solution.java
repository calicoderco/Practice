package com.cc.practice.fourSum;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public List<List<Integer>> fourSum(final int[] nums, final int target) {
        Arrays.sort(nums);

        List<List<Integer>> results = new LinkedList<>();
        int i = 0;
        int j = 1;
        int k = 2;
        int l = nums.length - 1;

        while(i < nums.length - 3) {
            int sum = nums[i] + nums[j] + nums[k] + nums[l];
            if(target > sum) {
                if(k < l - 1) {
                    k++;
                } else if(j < k - 1) {
                    j++;
                } else {
                    i++;
                }
            } else if(target < sum) {
                if(l > k + 1) {
                    l--;
                    k = j + 1;
                } else if(k > j + 2) {
                    k--;
                    j++;
                } else if(j > i + 2) {
                    j--;
                    i++;
                } else if(i >= l - 3) {
                    break;
                } else {
                    i++;
                    j = i + 1;
                    k = j + 1;
                }
            } else {
                List<Integer> result = new LinkedList<Integer>();
                result.add(nums[i]);
                result.add(nums[j]);
                result.add(nums[k]);
                result.add(nums[l]);
                results.add(result);

                if (k < l - 1) {
                    k++;
                } else if (j < k - 1) {
                    j++;
                    k = j + 1;
                } else if (i >= l - 3) {
                    break;
                } else {
                    i++;
                    j = i + 1;
                    k = j + 1;
                }
            }
        }

        return results;
    }
}

//fails to find unique ones
    /*public List<List<Integer>> fourSum(final int[] nums, final int target) {
        List<List<Integer>> results = new LinkedList<>();
        Map<Integer, Set<Set<Integer>>> sumToUniqueSets = new HashMap<>(nums.length * nums.length);
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                if(i != j) {
                    int sum = nums[i] + nums[j];
                    Set<Set<Integer>> uniqueSets = sumToUniqueSets.get(sum);
                    if(uniqueSets == null) {
                        uniqueSets = new HashSet<>();
                        sumToUniqueSets.put(sum, uniqueSets);
                    }
                    Set<Integer> uniqueSet = new HashSet<Integer>();
                    uniqueSet.add(i);
                    uniqueSet.add(j);
                    uniqueSets.add(uniqueSet);
                }
            }
        }

        Set<Integer> considered = new HashSet<>();
        for(Integer sum : sumToUniqueSets.keySet()) {
            Set<Set<Integer>> uniqueSets1 = sumToUniqueSets.get(sum);
            Set<Set<Integer>> uniqueSets2 = sumToUniqueSets.get(target - sum);

            if(!considered.contains(sum)) {
                if(uniqueSets2 != null && uniqueSets1 != uniqueSets2) {
                    for(Set<Integer> uniqueSet1 : uniqueSets1) {
                        for(Set<Integer> uniqueSet2 : uniqueSets2) {
                            if(!uniqueSet1.stream().anyMatch(i -> uniqueSet2.contains(i))) {
                                List<Integer> result = new LinkedList<>();
                                result.addAll(uniqueSet1.stream().map(i -> nums[i]).collect(Collectors.toList()));
                                result.addAll(uniqueSet2.stream().map(i -> nums[i]).collect(Collectors.toList()));
                                results.add(result.stream().collect(Collectors.toList()));
                            }
                        }
                    }
                }
            }

            considered.add(sum);
            considered.add(target - sum);
        }

        return results;
    }*/
