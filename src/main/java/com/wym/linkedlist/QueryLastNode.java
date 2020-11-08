package com.wym.linkedlist;

/**
 * 查找单向链表中倒数第K个节点
 * 思路：
 * 2中方案
 * 1：反转链表，然后遍历的同时进行计数，但是会破坏单向链表的结构
 * 2：先遍历所有节点，获取链表的长度，设为n，假设要获取倒数第二个元素，则正向遍历链表的同时进行计数，当计数index == n - K时，即找到
 * 倒数第K个节点
 */
public class QueryLastNode {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList.Node node1 = new LinkedList.Node(1);
        LinkedList.Node node2 = new LinkedList.Node(2);
        LinkedList.Node node3 = new LinkedList.Node(3);
        LinkedList.Node node4 = new LinkedList.Node(4);
        node4.name = "node4";
        LinkedList.Node node5 = new LinkedList.Node(5);

        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        int length = list.length();
        int k = 2;
        LinkedList.Node node = list.getHead();
        int index = 0;
        while (node != null) {
            if (index == length - k) {
                System.out.println("找到节点：node.name= " + node.name + "  node.val=" + node.val);
                break;
            }
            node = node.next;
            index++;
        }

    }
}
