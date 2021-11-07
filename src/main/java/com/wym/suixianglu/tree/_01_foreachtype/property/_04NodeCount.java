package com.wym.suixianglu.tree._01_foreachtype.property;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */
public class _04NodeCount {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7, 23};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);

        int count = nodeCount(root);
        System.out.println(count);
    }

    private static int nodeCount(Recurse.TreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }
        return nodeCount(root.left) + nodeCount(root.right) + 1;
    }

    private static int nodeCount3(Recurse.TreeNode<Integer> root) {

        if(root == null){
            return 0;
        }
        Queue<Recurse.TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            count+=size;
            for(int i = 0; i < size; i++){
                Recurse.TreeNode<Integer> node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

        return count;
    }

    private static int nodeCount2(Recurse.TreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        Recurse.TreeNode<Integer> left = root.left;
        Recurse.TreeNode<Integer> right = root.right;
        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        while (right != null) {
            rightHeight++;
            right = right.right;
        }
        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        }
        return nodeCount2(root.left) + nodeCount2(root.right) + 1;
    }

}
