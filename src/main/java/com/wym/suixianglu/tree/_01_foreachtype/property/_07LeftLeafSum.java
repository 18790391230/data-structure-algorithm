package com.wym.suixianglu.tree._01_foreachtype.property;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.Stack;

public class _07LeftLeafSum {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
        int i = sumOfLeftLeaves(root);
        System.out.println(i);
    }

    public int sumOfLeftLeaves2(Recurse.TreeNode<Integer> root) {

        int sum = 0;
        Stack<Recurse.TreeNode<Integer>> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Recurse.TreeNode<Integer> node = stack.pop();
            if(node.left != null && node.left.left == null && node.left.right == null){
                sum+=node.left.value;
            }
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }
        }

        return sum;
    }

    public static int sumOfLeftLeaves(Recurse.TreeNode<Integer> root) {
        int midVal=0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            midVal =  root.left.value;
        }
        int sum = 0;
        if(root.left != null){
            sum+=sumOfLeftLeaves(root.left);
        }
        if(root.right != null){
            sum+=sumOfLeftLeaves(root.right);
        }
        return sum + midVal;
    }
}
