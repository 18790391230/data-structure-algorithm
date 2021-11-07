package com.wym.suixianglu.tree._01_foreachtype.property;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class _10PathSum2 {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1, 22};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.value);
        int targetSum = 22;
        pathSum(root, targetSum, path, result);
        System.out.println(result);
    }

    private static void pathSum(Recurse.TreeNode<Integer> root, int count, List<Integer> path, List<List<Integer>> result){
        if (root.left == null && root.right == null && count == root.value) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            path.add(root.left.value);
            pathSum(root.left, count - root.value, path, result);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.value);
            pathSum(root.right, count - root.value, path, result);
            path.remove(path.size() - 1);
        }
    }
}
