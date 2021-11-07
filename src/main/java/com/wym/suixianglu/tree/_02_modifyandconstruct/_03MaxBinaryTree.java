package com.wym.suixianglu.tree._02_modifyandconstruct;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

/**
 * 最大二叉树
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class _03MaxBinaryTree {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        Recurse.TreeNode<Integer> build = build(nums, 0, nums.length);

    }

    private static Recurse.TreeNode<Integer> build(int[] nums, int left, int right){
        if(left >= right){
            return null;
        }

        int rootIndex = left;
        for(int i = left; i < right; i++){
            if(nums[i] > nums[rootIndex]){
                rootIndex = i;
            }
        }
        Recurse.TreeNode<Integer> root = new Recurse.TreeNode<Integer>(nums[rootIndex]);
        root.left = build(nums, left, rootIndex);
        root.right = build(nums, rootIndex + 1, right);
        return root;
    }
}
