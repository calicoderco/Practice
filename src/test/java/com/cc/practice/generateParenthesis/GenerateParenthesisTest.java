package com.cc.practice.generateParenthesis;

import org.junit.Test;

import java.util.List;

public class GenerateParenthesisTest {

    @Test
    public void test() {
        Solution solution = new Solution();

        List<String> answers = solution.generateParenthesis(4);
        System.out.println(answers);

        //["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
    }
}
