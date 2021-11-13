package com.wym.suixianglu.tree._03_modifyandconstructbst;

import com.wym.suixianglu.tree.TreeNode;

/**
 * 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class _02BSTDelete {

    public static void main(String[] args) {

    }


    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return root;
        }
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode left = root.left;
            TreeNode cur = root.right;
            while(cur.left != null){
                cur = cur.left;
            }
            cur.left = left;
            return root.right;
        }
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
