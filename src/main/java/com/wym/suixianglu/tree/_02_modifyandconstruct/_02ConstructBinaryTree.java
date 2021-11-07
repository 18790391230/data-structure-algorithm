package com.wym.suixianglu.tree._02_modifyandconstruct;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

/**
 * 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class _02ConstructBinaryTree {

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        Recurse.TreeNode<Integer> node = build(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }

    private static Recurse.TreeNode<Integer> build(int[] inorder, int inLeft, int inRight,
                           int[] postorder, int postLeft, int postRight){
        if (inLeft == inRight) {
            return null;
        }

        int rootVal = postorder[postRight - 1];
        Recurse.TreeNode<Integer> root = new Recurse.TreeNode<Integer>(rootVal);
        if (inRight - inLeft == 1) {
            return root;
        }

        int valIndex = 0;
        for (valIndex = inLeft; valIndex < inRight; valIndex++) {
            if (inorder[valIndex] == rootVal) {
                break;
            }
        }
        root.left = build(inorder, inLeft, valIndex,
                postorder, postLeft, postLeft + valIndex - inLeft);
        root.right = build(inorder, valIndex + 1, inRight,
                postorder, postLeft + (valIndex - inLeft), postRight - 1);
        return root;
    }


}
