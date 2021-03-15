package com.cc.practice.pathSum2;

import java.util.*;

public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if(root != null) {
            int currentSum = 0;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            TreeNode lastNode = new TreeNode(12345);
            while(!stack.empty()) {
                TreeNode current = stack.peek();
                currentSum += current.val;
                if(isLeaf(current) && currentSum == sum) {
                    result.add(new LinkedList(stack));
                    stack.pop();
                } else if(current.right != lastNode && current.left != lastNode) {
                    if(current.right != null) {
                        stack.push(current.right);
                    }

                    if(current.left != null) {
                        stack.push(current.left);
                    }
                } else {
                    stack.pop();
                }
                lastNode = current;
            }
        }
        return result;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
