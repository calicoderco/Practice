package com.cc.practice.threeSumClosest;


import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = 0;
        int k = nums.length; //the permanent divider
        int closestSum = Integer.MAX_VALUE;
        int lowestDiff = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - 3; i++) {
            for(int j = i + 1; j < k; j++) {
                int divider = k; //the divider for this current iteration

                //binary search for a place in nums from index j + 1 to k - 1 where for all sum including nums[divider],...,nums[k - 1] are above target
                //and sum including nums[j + 1],..,nums[divider - 1] are below target.
                //set divider to be equal to this dividing index
                //the number of dividing indexes is one greater than the length of the input array because there are imaginary dividers at the ends of the array
                //divider could end up being k or j + 1, it is okay. that just means either all the sums are greater than target or all the sums are less than target
                final int ijSum = nums[i] + nums[j];
                while(!((divider == k || ijSum + nums[divider] >= target) && (divider == j + 1 || ijSum + nums[divider - 1] <= target))) {
                    if( divider > j + 1 && target < ijSum + nums[divider - 1]) {
                        //go to the left side
                        divider = j + 1 + ((divider - (j + 2)) / 2);
                    }

                    if(divider < k && target > ijSum + nums[divider]) {
                        //go to the right side
                        divider = divider + ((k - (divider)) / 2);
                    }
                }

                if(divider > j + 1 ) {
                    if(ijSum + nums[divider - 1] == target) {
                        return target;
                    } else if(Math.abs(ijSum + nums[divider - 1] - target) < lowestDiff) {
                        closestSum = ijSum + nums[divider - 1];
                        lowestDiff = Math.abs(ijSum + nums[divider - 1] - target);
                    }
                }

                if(divider <= k  && divider < nums.length) {
                    if(ijSum + nums[divider] == target) {
                        return target;
                    } else if(Math.abs(ijSum + nums[divider] - target) < lowestDiff) {
                        closestSum = ijSum + nums[divider];
                        lowestDiff = Math.abs(ijSum + nums[divider] - target);
                    }
                }

                //move the permanent divider
                k = divider;
            }
        }

        return closestSum;
    }
}

