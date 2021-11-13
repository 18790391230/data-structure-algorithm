package com.wym.suixianglu.tree.common_ancestors;

import com.wym.suixianglu.tree.TreeNode;

/**
 * 平衡二叉树公共祖先问题
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class BSTCommonAncestors {

    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return null;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if(left != null){
                return left;
            }
        }
        if(root.val < p.val && root.val < q.val){
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(right != null){
                return right;
            }
        }
        return root;
    }
}
