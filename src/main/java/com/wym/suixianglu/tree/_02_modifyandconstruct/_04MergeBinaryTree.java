package com.wym.suixianglu.tree._02_modifyandconstruct;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.LinkedList;
import java.util.Queue;

public class _04MergeBinaryTree {

    public static void main(String[] args) {
        Recurse.TreeNode<Integer> root = Recurse.generateTree(new Integer[]{1, 3, 2, 5});
        Recurse.TreeNode<Integer> root2 = Recurse.generateTree(new Integer[]{2, 1, 3, null, 4, null, 7});
        Recurse.TreeNode<Integer> merge = merge(root, root2);
        System.out.println(merge);
    }

    private static Recurse.TreeNode<Integer> merge(Recurse.TreeNode<Integer> root1, Recurse.TreeNode<Integer> root2){
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        Recurse.TreeNode<Integer> root = new Recurse.TreeNode<Integer>(root1.value + root2.value);
        root.left = merge(root1.left, root2.left);
        root.right = merge(root1.right, root2.right);
        return root;
    }

    private static Recurse.TreeNode<Integer> merge2(Recurse.TreeNode<Integer> root1, Recurse.TreeNode<Integer> root2){
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }

        Queue<Recurse.TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while(!queue.isEmpty()){
            Recurse.TreeNode<Integer> left = queue.poll();
            Recurse.TreeNode<Integer> right = queue.poll();
            left.value += right.value;
            if(left.left != null && right.left != null){
                queue.add(left.left);
                queue.add(right.left);
            }
            if(left.right != null && right.right != null){
                queue.add(left.right);
                queue.add(right.right);
            }
            if(left.left == null && right.left != null){
                left.left = right.left;
            }
            if(left.right == null && right.right != null){
                left.right = right.right;
            }
        }

        return root1;
    }
}
