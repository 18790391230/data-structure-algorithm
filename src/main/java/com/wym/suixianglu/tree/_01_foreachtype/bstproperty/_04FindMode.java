package com.wym.suixianglu.tree._01_foreachtype.bstproperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/solution/
 */
public class _04FindMode {
    static List<Integer> result = new ArrayList<>();
    static int maxCount = 0;
    static int count = 0;
    static TreeNode prev = null;

    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        find(root);

    }

    private static void find(TreeNode root) {
        if (root == null) {
            return;
        }
        find(root.left);

        if (prev == null) {
            count = 1;
        } else if (prev.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        if (count == maxCount) {
            result.add(root.val);
        }
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        }
        prev = root;
        find(root.right);
    }

    private void find2(TreeNode root){
        if(root == null){
            return;
        }

        int maxCount = 0;
        int count = 0;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.add(cur);
                cur = cur.left;
            }else{
                TreeNode node = stack.pop();
                if(prev == null){
                    count = 1;
                }else if(prev.val == node.val){
                    count++;
                }else{
                    count = 1;
                }
                if(count == maxCount){
                    result.add(node.val);
                }
                if(count > maxCount){
                    maxCount = count;
                    result.clear();
                    result.add(node.val);
                }
                prev = node;
                cur = node.right;
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
