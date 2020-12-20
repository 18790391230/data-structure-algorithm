package com.wym.tree;

/**
 * 创建中序遍历线索化二叉树
 */
public class CreateClueBinaryTree {

    private static HeroNode prev = null;

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1);

        HeroNode node3 = new HeroNode(3);
        HeroNode node8 = new HeroNode(8);
        HeroNode node10 = new HeroNode(10);
        HeroNode node6 = new HeroNode(6);
        HeroNode node14 = new HeroNode(14);
        root.left = node3;
        node3.left = node8;
        node3.right = node10;
        root.right = node6;
        node6.left = node14;

        buildClueBinaryTree(root);

        System.out.println("node10.right.no == 1 ? " + (node10.right.no == 1));
    }

    static void buildClueBinaryTree(HeroNode node) {

        if (node == null) {
            return;
        }
        //1.中序遍历时先线索化left
        buildClueBinaryTree(node.left);
        //2. 再线索化当前节点
        //2.1当前节点的left == null时，设置当前节点的left为prev
        if (node.left == null) {
            node.left = prev;
            node.leftType = 1;
        }
        //2.2当prev != null且prev的right == null,则设置prev的right为当前节点
        if (prev != null && prev.right == null) {
            prev.right = node;
            prev.rightType = 1;
        }
        //2.3重新设置prev
        prev = node;

        //3.最后线索化right
        buildClueBinaryTree(node.right);
    }

    public static class HeroNode {

        public int leftType = 0;

        public int rightType = 0;

        public Integer no;

//        private String name;

        public HeroNode left;

        public HeroNode right;

        public HeroNode(int no) {
            this.no = no;
//            this.name = name;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    '}';
        }
    }

}
