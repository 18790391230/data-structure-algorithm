package com.wym.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HefumanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Node(arr[i]));
        }

        Collections.sort(list);

        while (list.size() > 1) {
            //1. 依次取出前两个数，相加
            Node left = list.get(0);
            Node right = list.get(1);

            //2.根据前两个数创建新的node
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;

            //3.删除前两个数
            list.remove(left);
            list.remove(right);

            //4.将新的node添加到list中
            list.add(parent);

            //5.再次排序
            Collections.sort(list);
        }

        list.get(0).preOrder();

    }

    static class Node implements Comparable<Node>{

        Node left;

        Node right;

        int value;

        public Node(int value) {
            this.value = value;
        }

        /**
         * 前序遍历
         */
        public void preOrder() {
            System.out.println(this);
            if (left != null) {
                left.preOrder();
            }
            if (right != null) {
                right.preOrder();
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }
}
