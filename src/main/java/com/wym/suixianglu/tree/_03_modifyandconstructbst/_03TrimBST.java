package com.wym.suixianglu.tree._03_modifyandconstructbst;

import com.wym.suixianglu.tree.TreeNode;

/**
 * 修剪二叉搜索树
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 */
public class _03TrimBST {

    public static void main(String[] args) {

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.val < low){
            return trimBST(root.right, low, high);
        }
        if(root.val > high){
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
