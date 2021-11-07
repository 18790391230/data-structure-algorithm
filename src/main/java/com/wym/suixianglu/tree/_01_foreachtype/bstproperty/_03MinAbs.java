package com.wym.suixianglu.tree._01_foreachtype.bstproperty;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.Stack;

/**
 * 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class _03MinAbs {


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
        int minimumDifference = getMinimumDifference(root);
        System.out.println(minimumDifference);
    }

    public static int getMinimumDifference2(Recurse.TreeNode<Integer> root) {
        minDifference(root);
        return min;
    }

    static Recurse.TreeNode<Integer> prev;
    static int min = Integer.MAX_VALUE;

    private static void minDifference(Recurse.TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        minDifference(root.left);
        if (prev != null) {
            min = Math.min(min, root.value - prev.value);
        }
        prev = root;
        minDifference(root.right);
    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    private static int getMinimumDifference(Recurse.TreeNode<Integer> root) {
        Recurse.TreeNode<Integer> prev = null;
        int min = Integer.MAX_VALUE;
        Recurse.TreeNode<Integer> cur = root;
        Stack<Recurse.TreeNode<Integer>> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                Recurse.TreeNode<Integer> node = stack.pop();
                if (prev != null && node.value - prev.value < min) {
                    min = node.value - prev.value;
                }
                prev = node;
                cur = node.right;
            }
        }
        return min;
    }
}
