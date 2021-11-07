package com.wym.suixianglu.tree._01_foreachtype.property;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class _05IsBalanceTree {

    public static void main(String[] args) {

    }

    private static int balanceTree(Recurse.TreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }
        int left = balanceTree(root.left);
        if (left == -1) {
            return -1;
        }
        int right = balanceTree(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
