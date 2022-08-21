package com.bzh.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inOrder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private void inOrder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public boolean isValidBST1(TreeNode root) {

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) return false;
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

}
