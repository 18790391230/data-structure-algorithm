package com.wym.suixianglu.tree._01_foreachtype.property;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.Stack;

public class _09PathSum {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
    }

    public boolean hasPathSum(Recurse.TreeNode<Integer> root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && targetSum == root.value){
            return true;
        }

        return hasPathSum(root.left, targetSum - root.value) || hasPathSum(root.right, targetSum - root.value);
    }

    public boolean hasPathSum2(Recurse.TreeNode<Integer> root, int targetSum) {
        if(root == null){
            return false;
        }
        Stack<Recurse.TreeNode<Integer>> stack = new Stack<>();
        stack.add(root);

        Stack<Integer> stack2 = new Stack<>();
        stack2.add(targetSum);
        while(!stack.isEmpty()){

            Recurse.TreeNode<Integer> node = stack.pop();
            Integer value = stack2.pop();
            if(node.left == null && node.right == null && value.equals(node.value)){
                return true;
            }
            if(node.right != null){
                stack.add(node.right);
                stack2.add(value - node.value);
            }
            if(node.left != null){
                stack.add(node.left);
                stack2.add(value - node.value);
            }

        }

        return false;
    }
}
