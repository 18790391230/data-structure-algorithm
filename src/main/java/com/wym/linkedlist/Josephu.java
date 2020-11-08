package com.wym.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫问题
 * 描述：
 * 设编号为1,2,3...n的n个人围成一圈，约定从编号为k（1<=k<=n）的人开始报数，数到m的那个人出列，以此类推，直到所有人出列为止，
 * 由此产生一个出队编号的序列
 *
 * 思路：
 * 1.先构建一个单向环形链表
 * 2.找到编号为k的那个人，num=0
 * 3.遍历链表的同时num++，当num == m，则删除该节点，因为删除节点时需要拿到当前节点的前一个节点，所以需要一个prev节点
 * 4.以此类推，直到链表中只剩下一个节点时（当前节点 == 当前节点的prev），跳出循环
 */
public class Josephu {

    public static void main(String[] args) {
        CircleLinkedList linkedList = new CircleLinkedList(5, 2, 3);
        //假设有5个人(1, 2, 3, 4, 5)，从第2个人开始数，数到3的人出队，顺序应该是：
        //4
        //2
        //1
        //3
        //5
        List<Node> nodes = linkedList.outputQueue();
        for (Node node : nodes) {
            System.out.println(node.val);
        }
        System.out.println();
    }
}

class CircleLinkedList {

    /**
     * 每当数到m时，节点出队列
     */
    private final int m;
    /**
     * 最后添加的节点，也就是尾结点
     */
    public Node current = null;

    private int k;

    /**
     * 第一个节点
     */
    public Node first = null;

    public CircleLinkedList(int n, int k, int m) {
        //构建环形链表
        if (n < 1) {
            throw new RuntimeException("n必须>=1");
        }
        this.k = k;
        this.m = m;
        first = current = new Node(1);
        for (int i = 1; i < n; i++) {
            Node node = new Node(i + 1);
            current.next = node;  //现有尾结点的next指向新的节点
            node.next = first;  //重新设置尾结点的指向
            current = node;  //更新最后的节点
        }

    }

    public List<Node> outputQueue() {
        List<Node> list = new ArrayList<>();
        //1.找到first节点的前一个节点，因为删除时需要拿到前一个节点才可以删除
        Node node = first;
        while (node.next != first) {
            node = node.next;
        }
        Node prev = node;

        //2.找到编号为k的那个人,开始计数
        Node tmpNode = first;
        for (int i = 0; i < k - 1; i++) {
            tmpNode = tmpNode.next;
            prev = prev.next;
        }
        System.out.println("k节点val=" + tmpNode.val);
        int num = 0;
        while (tmpNode.next != tmpNode) {
            //3.当计数 == m，则出队
            if (++num == m) {
                prev.next = tmpNode.next;
                list.add(tmpNode);
                num = 0;
            }else {
//            tmpNode.next = null;
                prev = prev.next;
            }
            tmpNode = tmpNode.next;
        }
        list.add(tmpNode);

        return list;
    }
}
