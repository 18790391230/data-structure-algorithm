package com.wym.datastructure.tree;

/**
 * 遍历中序线索化二叉树
 */
public class IterateClueBinaryTree {

    public static void main(String[] args) {
        CreateClueBinaryTree.HeroNode root = new CreateClueBinaryTree.HeroNode(1);

        CreateClueBinaryTree.HeroNode node3 = new CreateClueBinaryTree.HeroNode(3);
        CreateClueBinaryTree.HeroNode node8 = new CreateClueBinaryTree.HeroNode(8);
        CreateClueBinaryTree.HeroNode node10 = new CreateClueBinaryTree.HeroNode(10);
        CreateClueBinaryTree.HeroNode node6 = new CreateClueBinaryTree.HeroNode(6);
        CreateClueBinaryTree.HeroNode node14 = new CreateClueBinaryTree.HeroNode(14);
        root.left = node3;
        node3.left = node8;
        node3.right = node10;
        root.right = node6;
        node6.left = node14;

        CreateClueBinaryTree.buildClueBinaryTree(root);

        iterator(root);
    }

    private static void iterator(CreateClueBinaryTree.HeroNode root) {

        CreateClueBinaryTree.HeroNode node = root;
        if (node == null) {
            return;
        }
        while (node != null) {
            while (node.leftType == 0) {
                node = node.left;
            }
            System.out.println(node);
            while (node.rightType == 1) {
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }

    }
}
