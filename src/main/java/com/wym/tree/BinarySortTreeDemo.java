package com.wym.tree;

/**
 * 二叉排序树
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {

        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9, 2, 11};

        BinarySortTree tree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
//        tree.centerOrder();
//        System.out.println("\n\n\n\n");

        tree.deleteNode(1);
        tree.centerOrder();
        System.out.println("\n\n\n\n");

        tree.deleteNode(11);
        tree.centerOrder();

//        tree.deleteNode(3);
//        tree.centerOrder();

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
