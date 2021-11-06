package com.wym.suixianglu.tree._01_foreachtype.deepth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Iterator {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);

        List<Integer> result = new ArrayList<>();
//        preOrder(root, result);
        inOrder(root, result);
//        afterOrder(root, result);

        System.out.println("result:" + result);
    }


    private static void inOrder(Recurse.TreeNode<Integer> root, List<Integer> result) {

        Stack<Recurse.TreeNode<Integer>> stack = new Stack<>();
        Recurse.TreeNode<Integer> cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; //左
            } else {
                Recurse.TreeNode<Integer> pop = stack.pop(); //中
                result.add(pop.value);
                cur = pop.right;  //右
            }
        }


    }

    /**
     * 左 -> 右 -> 中 = 中右左翻转
     * @param root
     * @param result
     */
    private static void afterOrder(Recurse.TreeNode<Integer> root, List<Integer> result) {
        Stack<Recurse.TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Recurse.TreeNode<Integer> node = stack.pop();
            result.add(node.value);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
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
            Recurse.TreeNode<Integer> node = stack.pop();
            result.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }
}
