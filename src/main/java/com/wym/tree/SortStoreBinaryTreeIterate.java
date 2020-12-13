package com.wym.tree;

/**
 * 顺序存储二叉树遍历
 *             1
 *        /        \
 *     2              3
 *   /  \          /    \
 * 4     5        6     7
 * 以上二叉树转换为数组为
 * [1, 2, 3, 4, 5, 6, 7]
 *
 * 第n个元素的左子节点为2 * n + 1
 * 第n个元素的右子节点为2 * n + 2
 * 第n个元素的父节点为(n - 1) / 2
 *
 * n表示二叉树的第几个元素（从零开始）
 *
 */
public class SortStoreBinaryTreeIterate {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        preOrder(arr, 0);

    }

    private static void preOrder(int[] arr, int index) {

        if (index > arr.length - 1) {
            return;
        }
        //先输出自己
        System.out.println(arr[index]);

        //再输出左节点
        preOrder(arr, 2 * index + 1);

        //最后输出右节点
        preOrder(arr, 2 * index + 2);
    }

}
