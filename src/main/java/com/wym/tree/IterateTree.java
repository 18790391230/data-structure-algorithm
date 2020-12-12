package com.wym.tree;

/**
 * 前序、中序、后序遍历二叉树
 */
public class IterateTree {


    public static void main(String[] args) {
        HeroNode root = buildTree();

        root.frontIterate();
        System.out.println("\n======================================\n");
        root.centerIterate();
        System.out.println("\n======================================\n");
        root.afterIterate();
        System.out.println("\n\n");


        System.out.println("\n==================分割线====================\n");
        frontIterate(root);
        System.out.println("\n======================================\n");
        centerIterate(root);
        System.out.println("\n======================================\n");
        afterIterate(root);

    }

    private static void afterIterate(HeroNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            afterIterate(root.left);
        }
        if (root.right != null) {
            afterIterate(root.right);
        }
        System.out.println(root);
    }

    private static void centerIterate(HeroNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            centerIterate(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            centerIterate(root.right);
        }
    }

    private static void frontIterate(HeroNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        if (root.left != null) {
            frontIterate(root.left);
        }
        if (root.right != null) {
            frontIterate(root.right);
        }
    }

    private static HeroNode buildTree() {

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode wuyong = new HeroNode(2, "无用");
        HeroNode lujunyi = new HeroNode(3, "卢俊义");
        HeroNode linchong = new HeroNode(4, "林冲");

        root.left = wuyong;
        root.right = lujunyi;
        lujunyi.right = linchong;

        return root;
    }


    public static class HeroNode{
        private Integer no;

        private String name;

        private HeroNode left;

        private HeroNode right;

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        private void afterIterate() {

            if (this.left != null) {
                this.left.afterIterate();
            }
            if (this.right != null) {
                this.right.afterIterate();
            }
            System.out.println(this);
        }

        private void centerIterate() {

            if (this.left != null) {
                this.left.centerIterate();
            }
            System.out.println(this);
            if (this.right != null) {
                this.right.centerIterate();
            }
        }

        private void frontIterate() {

            System.out.println(this);
            if (this.left != null) {
                this.left.frontIterate();
            }
            if (this.right != null) {
                this.right.frontIterate();
            }
        }
    }
}
