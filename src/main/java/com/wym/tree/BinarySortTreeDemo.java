package com.wym.tree;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

/**
 * 二叉排序树
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {

        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9, 2};

        BinarySortTree tree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        tree.centerOrder();


    }

    static class BinarySortTree{
        private Node root;

        public void add(Node node) {
            if (node == null) {
                return;
            }
            if (root == null) {
                this.root = node;
            } else {
                root.add(node);
            }
        }

        public void centerOrder() {

            if (root == null) {
                return;
            }
            root.centerOrder();
        }
    }


    static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public void centerOrder() {

            if (left != null) {
                left.centerOrder();
            }
            System.out.println(this);
            if (right != null) {
                right.centerOrder();
            }
        }

        public void add(Node node) {
            if (node == null) {
                return;
            }
            if (node.value < value) {
                if (left != null) {
                    left.add(node);
                } else {
                    this.left = node;
                }
            } else {
                if (right != null) {
                    right.add(node);
                } else {
                    this.right = node;
                }

            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
