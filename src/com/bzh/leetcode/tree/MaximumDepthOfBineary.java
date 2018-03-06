package com.bzh.leetcode.tree;

public class MaximumDepthOfBineary {


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftTreeDepth = maxDepth(root.left) + 1;

        int rightTreeDepth = maxDepth(root.right) + 1;

        return leftTreeDepth > rightTreeDepth ? leftTreeDepth : rightTreeDepth;
    }
}
