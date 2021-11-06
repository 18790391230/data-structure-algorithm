package com.wym.suixianglu.tree._01_foreachtype.width;


import com.wym.suixianglu.tree._01_foreachtype.deepth.Recurse;

import java.util.*;

/**
 * 层序遍历
 */
public class LayerForeach {

    public static void main(String[] args) {

//        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
//        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);

//        List<List<Integer>> list = layForeach(root);
//        List<List<Integer>> list = layForeach2(root);

//---------------------------------------------------------------

//        Integer[] arr = new Integer[]{1, 2, 3, null, 5, null, 4};
//        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
//        List<Integer> list = rightView(root);
//        System.out.println(list);

        //---------------------------------------------------------------

//        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
//        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
//        List<Double> list = layAvg(root);
//        System.out.println(list);


        //---------------------------------------------------------------

//        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
//        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
//        List<Integer> list = layMax(root);
//        System.out.println(list);

        //---------------------------------------------------------------

//        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
//        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
//        List<String> list = connect(root);
//        System.out.println(list);

        //---------------------------------------------------------------

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Recurse.TreeNode<Integer> root = Recurse.generateTree(arr);
        int maxDepth = maxDepth(root);
        System.out.println(maxDepth);

        //最小深度omit
    }

    /**
     * 求树的最小深度
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     * @param root
     * @return
     */
    private static int minDepth(Recurse.TreeNode<Integer> root) {
        int depth = 0;
        Queue<Recurse.TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }

    /**
     * 求树的最大深度
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * @param root
     * @return
     */
    private static int maxDepth(Recurse.TreeNode<Integer> root) {
        int depth = 0;
        Queue<Recurse.TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
     * @param root
     * @return
     */
    private static List<String> connect(Recurse.TreeNode<Integer> root) {
        List<String> list = new ArrayList<>();
        Queue<Recurse.TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Recurse.TreeNode<Integer> prev = null;
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();
                list.add(node.value + "");
                if (i == 0) {
                    prev = node;
                }else{
                    prev.next = node;
                    prev = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add("#");
        }
        return list;
    }


    //在每个树行中找最大值
    //https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
    private static List<Integer> layMax(Recurse.TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();
        Queue<Recurse.TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();
                max = node.value > max ? node.value : max;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(max);
        }

        return list;
    }

    //二叉树的层平均值
    //https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
    private static List<Double> layAvg(Recurse.TreeNode<Integer> root) {
        List<Double> list = new ArrayList<>();
        Queue<Recurse.TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double value = 0;
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();
                value += node.value;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(value / size);
        }

        return list;
    }

    //二叉树的右视图
    //https://leetcode-cn.com/problems/binary-tree-right-side-view/
    private static List<Integer> rightView(Recurse.TreeNode<Integer> root) {
        List<Integer> list = new ArrayList<>();

        Queue<Recurse.TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();

                if (i == size - 1) {
                    list.add(node.value);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return list;
    }

    /**
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）
     * 层序遍历
     * @return
     */
    private static List<List<Integer>> layForeach(Recurse.TreeNode<Integer> root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<Recurse.TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            list.add(temp);
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();
                temp.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return list;
    }

    //N叉树的层序遍历
    //https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
    private static List<List<Integer>> nTreeLayForeach(Recurse.TreeNode<Integer> root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<Recurse.TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            list.add(temp);
            for (int i = 0; i < size; i++) {
                Recurse.TreeNode<Integer> node = queue.poll();
                temp.add(node.value);
//                for (int i = 0; i < node->children.size(); i++) { // 将节点孩子加入队列
//                    if (node->children[i]) que.push(node->children[i]);
//                }
            }
        }

        return list;
    }

    /**
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * @return
     */
    private static List<List<Integer>> layForeach2(Recurse.TreeNode<Integer> root) {

        List<List<Integer>> list = layForeach(root);
        Collections.reverse(list);
        return list;
    }

}
