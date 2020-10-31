package com.wym.linkedlist;

/**
 * 链表翻转
 * 如 1 -> 2 -> 3 -> 4
 * 转换为：
 * 1 <- 2 <- 3 <- 4
 * 返回4作为head
 *
 * 思路分析：
 * 链表翻转分为2部分
 * 1. 修改指针方向
 * 2. 修改指针指向时，包装修改后可以继续遍历后面的元素
 */
public class Reverse {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        showNodes(node1);

        doReverse(node1);

//        showNodes(node1);
    }

    private static void doReverse(Node head) {

        Node pre = head;
        Node current = head.next;
        //注意，需要将head的next设置为null
        head.next = null;
        while (current != null) {
            Node next = current.next; //先拿到当前节点的下一个节点
            current.next = pre;  //修改指针指向
            pre = current; //pre指针后移
            current = next; //current指针后移
        }

        showNodes(pre);
    }

    private static void showNodes(Node head) {

        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val);
            if (tmp.next != null) {
                System.out.print(" -> ");
            }
            tmp = tmp.next;
        }
        System.out.println();
    }
}
