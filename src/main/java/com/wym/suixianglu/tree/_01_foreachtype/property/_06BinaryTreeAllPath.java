package com.wym.suixianglu.tree._01_foreachtype.property;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class _06BinaryTreeAllPath {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
        List<String> list = new ArrayList<>();
        allTreePath(root, null, list);
        System.out.println(list);
    }

    /**
     * 迭代方式
     * @param root
     * @return
     */
    private static List<String> allTreePath(Recurse.TreeNode<Integer> root){

        List<String> list = new ArrayList<>();

        Stack<Recurse.TreeNode<Integer>> treeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        treeStack.add(root);
        pathStack.add(root.value + "");
        while(!treeStack.isEmpty()){
            Recurse.TreeNode<Integer> node = treeStack.pop();
            String path = pathStack.pop();
            if(node.left == null && node.right == null){
                list.add(path);
            }

            if(node.right != null){
                treeStack.add(node.right);
                pathStack.add(path + "->" + node.right.value);
            }

            if(node.left != null){
                treeStack.add(node.left);
                pathStack.add(path + "->" + node.left.value);
            }
        }

        return list;
    }
    private static void allTreePath(Recurse.TreeNode<Integer> root, String parent, List<String> list){
        parent = parent == null ? "" : parent + "->";
        if(root.left == null && root.right == null){
            list.add(parent + root.value);
            return;
        }
        String s = root.value + "";
        if(root.left != null){
            allTreePath(root.left, parent + s, list);
        }

        if(root.right != null){
            allTreePath(root.right, parent + s, list);
        }

    }
}
