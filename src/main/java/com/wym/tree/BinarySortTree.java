package com.wym.tree;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

/**
 * 二叉排序树
 */
public class BinarySortTree {

    public static void main(String[] args) {

//        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};

        Node node7 = new Node(7);
        Node node3 = new Node(3);
        Node node10 = new Node(10);
        Node node12 = new Node(12);
        Node node5 = new Node(5);
        Node node1 = new Node(1);
        Node node9 = new Node(9);

        node7.add(node3);
        node7.add(node10);
        node7.add(node12);
        node7.add(node5);
        node7.add(node1);
        node7.add(node9);

        node7.centerOrder();
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
