package com.wym.suixianglu.tree._01_foreachtype.deepth;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Recurse {


    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode<Integer> root = generateTree(arr);

        List<Integer> result = new ArrayList<>();
//        preOrder(root, result);
//        inOrder(root, result);
        afterOrder(root, result);

        System.out.println("result:" + result);
    }

    private static void afterOrder(TreeNode<Integer> root, List<Integer> result) {

        if (root == null) {
            return;
        }
        afterOrder(root.left, result);
        afterOrder(root.right, result);
        result.add(root.value);
    }

    private static void inOrder(TreeNode<Integer> root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.value);
        inOrder(root.right, result);
    }

    private static void preOrder(TreeNode<Integer> root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        preOrder(root.left, result);
        preOrder(root.right, result);

    }

    public static TreeNode<Integer> generateTree(int[] arr) {

        TreeNode<Integer> root = new TreeNode<>(arr[0], null, null);

        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);

        int startIndex = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                if (node == null) {
                    return root;
                }
                if (startIndex < arr.length) {
                    node.left = new TreeNode<>(arr[startIndex++], null, null);
                    queue.add(node.left);
                }
                if (startIndex < arr.length) {
                    node.right = new TreeNode<>(arr[startIndex++], null, null);
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

    public static class TreeNode<T>{

        public T value;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
