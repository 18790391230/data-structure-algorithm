package com.wym.suixianglu.tree.common_ancestors;

import com.wym.suixianglu.tree.TreeNode;

/**
 * 二叉树公共祖先问题
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class BinaryTreeCommonAncestors {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        if(left == null) return right;
        return left;
    }
}
