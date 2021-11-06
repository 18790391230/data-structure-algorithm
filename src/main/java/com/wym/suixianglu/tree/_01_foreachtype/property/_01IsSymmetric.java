package com.wym.suixianglu.tree._01_foreachtype.property;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.*;

public class _01IsSymmetric {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
//        boolean b = isSymmetric(root.left, root.right);
//        boolean b = isSymmetricWithQueue(root.left, root.right);
        boolean b = isSymmetricWithStack(root.left, root.right);
        System.out.println(b);
    }

    private static boolean isSymmetricWithQueue(Recurse.TreeNode<Integer> left, Recurse.TreeNode<Integer> right) {

        Deque<Recurse.TreeNode<Integer>> deque = new LinkedList<>();
        deque.add(left);
        deque.add(right);
        while (!deque.isEmpty()) {
            Recurse.TreeNode<Integer> leftNode = deque.poll();
            Recurse.TreeNode<Integer> rightNode = deque.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if ((leftNode != null && rightNode == null) || (leftNode == null && rightNode != null) || (!leftNode.value.equals(rightNode.value))) {
                return false;
            }
            deque.add(leftNode.left);
            deque.add(rightNode.right);

            deque.add(leftNode.right);
            deque.add(rightNode.left);
        }

        return true;
    }

    private static boolean isSymmetricWithStack(Recurse.TreeNode<Integer> left, Recurse.TreeNode<Integer> right) {

        Stack<Recurse.TreeNode<Integer>> stack = new Stack<>();
        stack.add(left);
        stack.add(right);
        while (!stack.isEmpty()) {
            Recurse.TreeNode<Integer> leftNode = stack.pop();
            Recurse.TreeNode<Integer> rightNode = stack.pop();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if ((leftNode != null && rightNode == null) || (leftNode == null && rightNode != null) || (!leftNode.value.equals(rightNode.value))) {
                return false;
            }
            stack.add(leftNode.left);
            stack.add(rightNode.right);

            stack.add(leftNode.right);
            stack.add(rightNode.left);
        }

        return true;
    }


    private static boolean isSymmetric(Recurse.TreeNode<Integer> left, Recurse.TreeNode<Integer> right) {

        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }
        if (!left.value.equals(right.value)) {
            return false;
        }
        boolean a = isSymmetric(left.left, right.right);
        boolean b = isSymmetric(left.right, right.left);

        return a && b;
    }
}
