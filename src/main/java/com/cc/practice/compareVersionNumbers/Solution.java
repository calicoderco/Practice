package com.cc.practice.compareVersionNumbers;

class Solution {
    public int compareVersion(String version1, String version2) {
        return 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        assert(solution.compareVersion("1.1.0", "1.1") == 1);
        assert(solution.compareVersion("1.1", "1.1.0")) == 2;
        assert(solution.compareVersion("", "") == 0);
        assert(solution.compareVersion(null, "") == 0);
        assert(solution.compareVersion("", null) == 0);
        assert(solution.compareVersion("1", "") == 1);
        assert(solution.compareVersion("", "1") == -1);
        assert(solution.compareVersion("11.1", "1.11") == 1);
        assert(solution.compareVersion("1.11", "11.1") == -1);
        assert(solution.compareVersion("1.001", "1.1") == 0);
        assert(solution.compareVersion("1.1", "1.001") == 0);
        assert(solution.compareVersion("1.000100", "1.0001") == 1);
    }
}
