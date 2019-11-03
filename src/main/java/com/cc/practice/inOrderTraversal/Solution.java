package com.cc.practice.inOrderTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        if(root != null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }

        return result;
    }*/



    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(null != root) {
            stack.add(root);

            TreeNode previous = null;
            while(!stack.isEmpty()) {
                TreeNode current = stack.pop();
                if((current.left == previous && previous != null) || current.left == null) {
                    result.add(current.val);

                    if(current.right != null) {
                        stack.push(current.right);
                    }
                } else {
                    stack.push(current);
                    stack.push(current.left);
                }

                previous = current;
            }
        }


        return result;
    }
}
