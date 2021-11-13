package com.wym.suixianglu.tree._03_modifyandconstructbst;

import com.wym.suixianglu.tree.TreeNode;

/**
 * 二叉搜索树插入节点
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class _01BSTInsert {

    public static void main(String[] args) {

    }

    /**
     * 迭代方式
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while(cur != null){
            parent = cur;
            if(cur.val > val){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        TreeNode node = new TreeNode(val);
        if(parent.val > val){
            parent.left = node;
        }else{
            parent.right = node;
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            if(root.left == null){
                root.left = new TreeNode(val);
            }else{
                root.left = insertIntoBST(root.left, val);
            }
        }
        if(root.val < val){
            if(root.right == null){
                root.right = new TreeNode(val);
            }else{
                root.right = insertIntoBST(root.right, val);
            }
        }
        return root;
    }
}
