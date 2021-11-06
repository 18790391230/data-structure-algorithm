package com.wym.suixianglu.tree._01_foreachtype.deepth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Iterator2 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);

        List<Integer> result = new ArrayList<>();
//        preOrder(root, result);
//        inOrder(root, result);
        afterOrder(root, result);

        System.out.println("result:" + result);
    }


    //左中右
    private static void inOrder(Recurse.TreeNode<Integer> root, List<Integer> result) {

        Stack<Recurse.TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Recurse.TreeNode<Integer> node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                stack.pop();
                Recurse.TreeNode<Integer> pop = stack.pop();
                result.add(pop.value);
            }
        }
    }

    /**
     * 左 -> 右 -> 中
     * @param root
     * @param result
     */
    private static void afterOrder(Recurse.TreeNode<Integer> root, List<Integer> result) {
        Stack<Recurse.TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Recurse.TreeNode<Integer> node = stack.peek();
            if (node != null) {
                stack.pop();
                stack.push(node);
                stack.push(null);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                stack.pop();
                Recurse.TreeNode<Integer> pop = stack.pop();
                result.add(pop.value);
            }
        }
    }

    /**
     * 中 -> 左 -> 右
     * @param root
     * @param result
     */
    private static void preOrder(Recurse.TreeNode<Integer> root, List<Integer> result) {
        Stack<Recurse.TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Recurse.TreeNode<Integer> node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            } else {
                stack.pop();
                Recurse.TreeNode<Integer> pop = stack.pop();
                result.add(pop.value);
            }
        }
    }
}
