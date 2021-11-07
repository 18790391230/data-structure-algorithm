package com.wym.suixianglu.tree._02_modifyandconstruct;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

/**
 * 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _01FlitBinaryTree {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
        invert(root);
    }

    private static void invert(Recurse.TreeNode<Integer> root){
        if(root == null){
            return;
        }
        Recurse.TreeNode<Integer> left = root.left;
        Recurse.TreeNode<Integer> right = root.right;
        root.left = right;
        root.right = left;
        invert(left);
        invert(right);
    }
}
