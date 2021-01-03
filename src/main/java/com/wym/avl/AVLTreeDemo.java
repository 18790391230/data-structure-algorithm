package com.wym.avl;

/**
 * 平衡二叉树
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
//        int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        //创建一个 AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for(int i=0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.centerOrder();

        System.out.println(avlTree.getHeight());
        System.out.println(avlTree.getLeftHeight());
        System.out.println(avlTree.getRightHeight());
    }

    static class AVLTree{
        private Node root;

        public int getHeight() {
            return root.getHeight();
        }

        public int getLeftHeight() {
            return root.left.getHeight();
        }

        public int getRightHeight() {
            return root.right.getHeight();
        }

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

        public void deleteNode(int value) {

            //1.找到要删除的节点及其父节点
            Node[] node = root.searchNodeAndParent(value, null);
            if (node == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                this.root = null;
                return;
            }

            //2.删除节点

            //2.1要删除的节点是叶子节点
            final Node targetNode = node[0];
            final Node parent = node[1];
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.right != null && parent.right.value == targetNode.value) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }
                return;
            }

            //2.2要删除的节点拥有2颗子树
            if (targetNode.left != null && targetNode.right != null) {
                final Node min = targetNode.findMinAndDel();
                if (parent != null) {
                    if (parent.right != null &&parent.right.value == targetNode.value) {
                        parent.right.value = min.value;
                    } else {
                        parent.left.value = min.value;
                    }
                } else {
                    root.value = min.value;
                }
                return;
            }

            //2.3要删除的节点拥有一颗子树
            if (parent != null) {
                if (parent.left != null && parent.left.value == targetNode.value) {
                    parent.left = targetNode.left != null ? targetNode.left : targetNode.right;
                } else {
                    parent.right = targetNode.left != null ? targetNode.left : targetNode.right;
                }
            } else {
                root = targetNode.left != null ? targetNode.left : targetNode.right;
            }

        }

    }


    static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        private Node findMinAndDel() {
            if (this.right != null && this.right.left == null) {
                Node rtn = this.right;
                this.right = null;
                return rtn;
            }
            Node parent = this;
            Node node = right;
            while (node.left != null) {
                parent = node;
                node = node.left;
            }
            parent.left = null;

            return node;
        }

        private Node[] searchNodeAndParent(int value, Node parent) {

            if (value == this.value) {
                return new Node[]{this, parent};
            }
            if (value < this.value) {
                if (this.left != null) {
                    return this.left.searchNodeAndParent(value, this);
                } else {
                    return null;
                }
            } else {
                if (this.right != null) {
                    return this.right.searchNodeAndParent(value, this);
                } else {
                    return null;
                }
            }
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

        public int getLeftHeight() {
            return left == null ? 0 : this.left.getHeight();
        }

        public int getRightHeight() {
            return right == null ? 0 : this.right.getHeight();
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

            if (getRightHeight() - getLeftHeight() > 1) {
                if (this.right != null && this.right.getLeftHeight() > this.right.getRightHeight()) {
                    this.right.rightRotate();
                }
                leftRotate();
            }
            if (getLeftHeight() - getRightHeight() > 1) {
                if (this.left != null && this.left.getRightHeight() > this.left.getLeftHeight()) {
                    this.left.leftRotate();
                }
                rightRotate();
            }
        }

        private void leftRotate() {
            //1.创建一个和当前节点相同的节点newNode
            final Node newNode = new Node(this.value);

            //2.新节点的left设置为当前节点的左节点
            newNode.left = this.left;

            //3.新节点的right设置为当前节点的右节点的左节点
            newNode.right = this.right.left;

            //4.当前节点的值设置为当前节点的右节点
            this.value = this.right.value;

            //5.当前节点的右节点的右节点设置为当前节点的右节点
            this.right = this.right.right;

            //6.当前节点的左节点设置为新节点
            this.left = newNode;
        }

        private void rightRotate() {
            //1.创建一个和当前节点值相同的新节点
            final Node newNode = new Node(this.value);

            //2.新节点的右节点设置为当前节点的右节点
            newNode.right = this.right;

            //3.新节点的左节点设置为当前节点的左节点的右节点
            newNode.left = this.left.right;

            //4.当前节点的值设置为当前节点的左节点
            this.value = this.left.value;

            //5.当前节点的左节点设置为当前节点的左节点的左节点
            this.left = this.left.left;

            //6.当前节点的右节点设置为新节点
            this.right = newNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }


        public int getHeight() {

            return Math.max(left == null ? 0 : left.getHeight(), this.right == null ? 0 : this.right.getHeight()) + 1;
        }
    }
}
