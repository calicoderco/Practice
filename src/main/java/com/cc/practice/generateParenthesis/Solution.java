package com.cc.practice.generateParenthesis;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class Solution {
    //almost correct but doesnt work
    /*public List<String> generateParenthesis(int n) {
        Collection<String> f1 = new LinkedList<>();
        f1.add("()");

        Collection<String> f2 = new LinkedList<>();
        f2.add("()()");
        f2.add("(())");

        Collection<String> fn = new LinkedList<>();
        fn.add("(%s)");
        fn.add("%s()");
        fn.add("()%s");

        List<String> parens = new LinkedList<>();
        parens.addAll(f1);


        for(int i = 2; i <= n; i++) {
                List<String> newParens = new LinkedList<>();
                int j = 1;
                for(String p : parens) {
                    if(j == )
                }
                parens = newParens;
        }

        return parens;
    }*/

    /*works but slow, but 100% better memory */
    /*public List<String> generateParenthesis(int n) {
        List<String> input = new LinkedList<>();
        input.add("");
        return generateParenthesis(input, n, 0, 0);
    }

    public List<String> generateParenthesis(List<String> strings, int n, int leftParens, int rightParens) {
            List<String> answer = new LinkedList<String>();
            if(leftParens < n) {
                List<String> input1 = new LinkedList<String>(),
                        input2 = new LinkedList<String>();

                for(String s : strings) {
                    input1.add(s + "(");
                }

                List<String> answer1 = generateParenthesis(input1, n, leftParens + 1, rightParens);

                answer.addAll(answer1);

                if(rightParens < leftParens) {
                    for(String s : strings) {
                        input2.add(s + ")");
                    }
                    List<String> answer2 = generateParenthesis(input2, n, leftParens, rightParens + 1);
                    answer.addAll(answer2);
                }
            } else {
                String suffix = "";
                for(int i = rightParens; i < n; i++) {
                    suffix += ")";
                }
                for(String s : strings) {
                    answer.add(s + suffix);
                }
            }

            return answer;
    }*/

    //faster than 93% and better than 100% memory
    /*public List<String> generateParenthesis(int n) {
        String input = "";
        List<String> output = new LinkedList<String>();
        generateParenthesis(output, input, n, 0, 0);
        return output;
    }

    void generateParenthesis(List<String> output, String input, int n, int leftParentheses, int rightParentheses) {
        if(leftParentheses < n) {
            generateParenthesis(output, input + "(", n, leftParentheses + 1, rightParentheses);
            if(rightParentheses < leftParentheses) {
                generateParenthesis(output, input + ")", n, leftParentheses, rightParentheses + 1);
            }
        } else {
            while(rightParentheses < n) {
                input += ")";
                rightParentheses++;
            }
            output.add(input);
        }
    }*/

    public List<String> generateParenthesis(int n) {
        StringBuilder input = new StringBuilder("");
        List<String> output = new LinkedList<String>();
        generateParenthesis(output, input, n, 0, 0);
        return output;
    }

    void generateParenthesis(List<String> output, StringBuilder input, int n, int leftParentheses, int rightParentheses) {
        if(leftParentheses < n) {
            input.append('(');
            generateParenthesis(output, input, n, leftParentheses + 1, rightParentheses);
            input.deleteCharAt(input.length() - 1);

            if(rightParentheses < leftParentheses) {
                input.append(')');
                generateParenthesis(output, input, n, leftParentheses, rightParentheses + 1);
                input.deleteCharAt(input.length() - 1);
            }
        } else {
            int toDelete = n - rightParentheses;
            while(rightParentheses < n) {
                input.append(')');
                rightParentheses++;
            }
            output.add(input.toString());
            input.delete(input.length() - toDelete, input.length());
        }
    }

}
