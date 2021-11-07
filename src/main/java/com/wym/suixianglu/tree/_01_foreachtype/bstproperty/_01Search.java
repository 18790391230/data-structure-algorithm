package com.wym.suixianglu.tree._01_foreachtype.bstproperty;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class _01Search {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
        searchBST(root, 5);
    }

    //----------------------------二叉搜索树----------------------------------------------

    public static Recurse.TreeNode<Integer> searchBST(Recurse.TreeNode<Integer> root, int val) {
        if(root == null){
            return null;
        }
        if(root.value == val) return root;
        else if(root.value > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

    public static Recurse.TreeNode<Integer> searchBST2(Recurse.TreeNode<Integer> root, int val) {
        if(root == null){
            return null;
        }
        while(root != null){
            if(root.value == val){
                return root;
            }
            else if(root.value > val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return null;
    }

    //----------------------------二叉树----------------------------------------------

    public Recurse.TreeNode<Integer> search(Recurse.TreeNode<Integer> root, int val) {
        if(root == null){
            return null;
        }
        if(root.value == val){
            return root;
        }
        Recurse.TreeNode<Integer> left = searchBST(root.left, val);
        if(left != null){
            return left;
        }
        Recurse.TreeNode<Integer> right = searchBST(root.right, val);
        if(right != null){
            return right;
        }
        return null;
    }

    public Recurse.TreeNode<Integer> search2(Recurse.TreeNode<Integer> root, int val) {
        if(root == null){
            return null;
        }
        Queue<Recurse.TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i< size; i++){
                Recurse.TreeNode<Integer> node = queue.poll();
                if(node.value == val){
                    return node;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

        return null;
    }

}
