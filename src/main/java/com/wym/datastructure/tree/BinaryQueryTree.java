package com.wym.datastructure.tree;

/**
 * 前序、中序、后序查找二叉树
 */
public class BinaryQueryTree {

    private static int invokeCount = 0;

    public static void main(String[] args) {
        HeroNode root = buildTree();
        int targetNo = 3;

        HeroNode heroNode1 = frontQuery(root, targetNo);
        System.out.println("invokeCount=" + invokeCount + "\t" + heroNode1);
        System.out.println("\n======================================\n");

        invokeCount = 0;
        HeroNode heroNode2 = centerQuery(root, targetNo);
        System.out.println("invokeCount=" + invokeCount + "\t" + heroNode2);
        System.out.println("\n======================================\n");

        invokeCount = 0;
        HeroNode heroNode3 = afterQuery(root, targetNo);
        System.out.println("invokeCount=" + invokeCount + "\t" + heroNode3);

    }

    private static HeroNode afterQuery(HeroNode root, int no) {
        invokeCount++;
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            HeroNode heroNode = frontQuery(root.left, no);
            if (heroNode != null) {
                return heroNode;
            }
        }

        if (root.right != null) {
            HeroNode heroNode = frontQuery(root.right, no);
            if (heroNode != null) {
                return heroNode;
            }
        }
        if (root.no == no) {
            return root;
        }
        return null;
    }

    private static HeroNode centerQuery(HeroNode root, int no) {
        invokeCount++;
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            HeroNode heroNode = frontQuery(root.left, no);
            if (heroNode != null) {
                return heroNode;
            }
        }
        if (root.no == no) {
            return root;
        }
        if (root.right != null) {
            HeroNode heroNode = frontQuery(root.right, no);
            if (heroNode != null) {
                return heroNode;
            }
        }
        return null;
    }

    private static HeroNode frontQuery(HeroNode root, int no) {
        invokeCount++;
        if (root == null) {
            return null;
        }
        if (root.no == no) {
            return root;
        }
        if (root.left != null) {
            HeroNode heroNode = frontQuery(root.left, no);
            if (heroNode != null) {
                return heroNode;
            }
        }
        if (root.right != null) {
            HeroNode heroNode = frontQuery(root.right, no);
            if (heroNode != null) {
                return heroNode;
            }
        }
        return null;
    }

    private static HeroNode buildTree() {

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode wuyong = new HeroNode(2, "无用");
        HeroNode lujunyi = new HeroNode(3, "卢俊义");
        HeroNode linchong = new HeroNode(4, "林冲");
        HeroNode wuming = new HeroNode(5, "无名");

        root.left = wuyong;
        root.right = lujunyi;
        lujunyi.right = wuming;
        lujunyi.left = linchong;

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
    }
}
