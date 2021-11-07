package com.wym.suixianglu.tree._01_foreachtype.bstproperty;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class _02BSTValidate {

    static Recurse.TreeNode<Integer> prev = null;

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
        boolean b = validateBST(root);
    }

    public static boolean validateBST(Recurse.TreeNode<Integer> root) {
        if(root == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        isValidBST(root, list);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i - 1) >= list.get(i)){
                return false;
            }
        }
        return true;
    }

    private static void isValidBST(Recurse.TreeNode<Integer> root, List<Integer> list) {
        if(root == null){
            return;
        }
        isValidBST(root.left, list);
        list.add(root.value);
        isValidBST(root.right, list);
    }

    public boolean isValidBST2(Recurse.TreeNode<Integer> root) {
        if(root == null){
            return true;
        }
        boolean left = isValidBST2(root.left);
        if(prev != null && prev.value >= root.value){
            return false;
        }
        prev = root;
        boolean right = isValidBST2(root.right);
        return left && right;
    }


    public boolean isValidBST3(Recurse.TreeNode<Integer> root) {
        if(root == null){
            return true;
        }
        Recurse.TreeNode<Integer> prev = null;
        Stack<Recurse.TreeNode<Integer>> stack = new Stack<>();
        Recurse.TreeNode<Integer> cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.add(cur);
                cur = cur.left;
            }else{
                Recurse.TreeNode<Integer> node = stack.pop();
                if(prev != null && prev.value >= node.value){
                    return false;
                }
                prev = node;
                cur = node.right;
            }
        }
        return true;
    }
}
