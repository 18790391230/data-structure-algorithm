package com.wym.suixianglu.tree._03_modifyandconstructbst;

import com.wym.suixianglu.tree.TreeNode;

/**
 * 将有序数组构造为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class _04_SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int left, int right){
        if(left >= right){
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid);
        node.right = build(nums, mid + 1, right);
        return node;
    }
}
