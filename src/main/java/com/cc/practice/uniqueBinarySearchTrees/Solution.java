package com.cc.practice.uniqueBinarySearchTrees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


//beats 99% and 100%
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] computed = new LinkedList[n][n];

        if(n == 0) {
            List<TreeNode> results = new LinkedList<TreeNode>();
            return results;
        }

        return generateTrees(n, 1, n, computed);
    }



    public List<TreeNode> generateTrees(int n, int start, int end, List<TreeNode>[][] computed) {
        List<TreeNode> results = new LinkedList<>();

        if(start >= 0 && end < n && computed[start - 1][end - 1] != null) {
            return computed[start - 1][end - 1];
        } else if(start == end) {
            results.add(new TreeNode(start));
        } else {
            for (TreeNode rightTree : generateTrees(n, start + 1, end, computed)) {
                TreeNode rootNode = new TreeNode(start);
                rootNode.right = rightTree;
                results.add(rootNode);
            }

            for(int root = start + 1; root <= end - 1; root++) {
                List<TreeNode> leftTrees = generateTrees(n, start, root - 1, computed), rightTrees = generateTrees(n, root + 1, end, computed);
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode rootNode = new TreeNode(root);
                        rootNode.left = leftTree;
                        rootNode.right = rightTree;
                        results.add(rootNode);
                    }
                }
            }

            for (TreeNode leftTree : generateTrees(n, start, end - 1, computed)) {
                TreeNode rootNode = new TreeNode(end);
                rootNode.left = leftTree;
                results.add(rootNode);
            }
        }

        computed[start - 1][end - 1] = results;

        return results;
    }
}
