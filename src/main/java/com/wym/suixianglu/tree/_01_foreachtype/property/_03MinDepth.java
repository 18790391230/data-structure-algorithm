package com.wym.suixianglu.tree._01_foreachtype.property;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.LinkedList;
import java.util.Queue;

public class _03MinDepth {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, null, 2, null, null, 4, 3, null, null, null, null, null, null, 6, 5};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);

//        int depth = minDepth(root);
        int depth = minDepth2(root);
        System.out.println(depth);
    }

    private static int minDepth2(Recurse.TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int minDepth = 0;
        Queue<Recurse.TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return minDepth;
    }

    private static int minDepth(Recurse.TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + right;
        }
        if (root.left != null && root.right == null) {
            return 1 + left;
        }

        return Math.min(left, right) + 1;
    }

    //这是错误的
    private static int minDepthBad(Recurse.TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = minDepthBad(root.left);
        int right = minDepthBad(root.right);

        return Math.min(left, right) + 1;
    }
}
