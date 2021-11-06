package com.wym.suixianglu.tree._01_foreachtype.property;

import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.LinkedList;
import java.util.Queue;

public class _02MaxDepth {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7, 23};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);

//        int depth = maxDepth(root);
        int depth = maxDepth2(root);
        System.out.println(depth);
    }

    private static int maxDepth(Recurse.TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    private static int maxDepth2(Recurse.TreeNode<Integer> root) {

        Queue<Recurse.TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }
}
