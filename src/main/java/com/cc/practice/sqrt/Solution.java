package com.cc.practice.sqrt;

class Solution {
    //beats 100% using binary search
    public int mySqrt(int x) {
        if(x == 0) return 0;

        int left = 1, right = x;
        while(left != right) {
            int mid = left + ((right - left) / 2);
            if(x / mid >= mid && x / (mid + 1) < (mid + 1)) {
                return mid;
            } else if(x / mid >= mid && x / (mid + 1) >= (mid + 1)) {
                left = mid == left ? mid + 1 : mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}