package com.wym.suixianglu.tree._01_foreachtype.property;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.LinkedList;
import java.util.Queue;

public class _08LeftBottomValue {

    static int maxValue = 0;
    static int maxDepth = 0;
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
        leftBottomValue(root, 1);
        System.out.println(maxValue);
    }

    private static int leftBottomValue2(Recurse.TreeNode<Integer> root) {

        int value = 0;
        Queue<Recurse.TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();
                if (i == 0) {
                    value = node.value;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }

        return value;
    }


    private static void leftBottomValue(Recurse.TreeNode<Integer> root, int depth) {

        if (root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            if (depth > maxDepth && root.value > maxValue) {
                maxValue = root.value;
                maxDepth = depth;
            }
            return;
        }

        leftBottomValue(root.left, depth + 1);
        leftBottomValue(root.right, depth + 1);
    }
}
