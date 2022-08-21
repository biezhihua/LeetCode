package com.bzh.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBineary {


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftTreeDepth = maxDepth(root.left) + 1;

        int rightTreeDepth = maxDepth(root.right) + 1;

        return leftTreeDepth > rightTreeDepth ? leftTreeDepth : rightTreeDepth;
    }


    public int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depth = 0;

        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);

        while (!qu.isEmpty()) {
            depth++;
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();
                if (node.left != null) {
                    qu.offer(node.left);
                }
                if (node.right != null) {
                    qu.offer(node.right);
                }
            }
        }

        return depth;
    }
}
