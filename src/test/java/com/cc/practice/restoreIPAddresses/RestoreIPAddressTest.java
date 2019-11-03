package com.cc.practice.restoreIPAddresses;

import org.junit.Test;

import java.util.List;

public class RestoreIPAddressTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        List<String> results = solution.restoreIpAddresses("2505255113");
        for(String result : results) {
            System.out.println(result);
        }
    }
}
