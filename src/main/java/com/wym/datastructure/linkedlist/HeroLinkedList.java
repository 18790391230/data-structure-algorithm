package com.wym.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 水浒英雄双向链表，按照val值排序(使用了虚拟头节点)
 */
public class HeroLinkedList {

    public static void main(String[] args) {
        HeroLinkedList list = new HeroLinkedList();
        HeroNode node1 = new HeroNode("AAA", 1);
        HeroNode node3 = new HeroNode("CCC", 3);
        HeroNode node2 = new HeroNode("BBB", 2);
        list.add(node1);
        list.add(node2);
        list.add(node3);

        list.showElements();
        System.out.println("===============");
        list.showReverseElements();

        System.out.println("========测试删除=======");
        list.remove("BBB");
        list.showElements();
        System.out.println("===============");
        list.showReverseElements();

        System.out.println("========测试删除=======");
        list.remove("CCC");
        list.showElements();
        System.out.println("===============");
        list.showReverseElements();
    }

    private HeroNode head = new HeroNode(-1);
    private HeroNode tail = head;

    public int length() {

        HeroNode node = head.next;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 删除节点
     * 分2种情况考虑
     * 1.需要删除的节点在链表中间（虚拟头节点与tail节点之间），则需要修改4个指针
     *  1.1 将delNode的prev的next指向delNode的next
     *  1.2 将delNode的next的prev指向delNode的prev
     *  1.3 将delNode的prev设置为null
     *  1.4 将delNode的next设置为null
     * @param name
     * 英雄的名字
     */
    public void remove(String name) {
        if (head == null) {
            return;
        }

        HeroNode node = head.next;
        while (node != null) {
            if (node.name.equals(name)) {
                node.prev.next = node.next;
                if (node.next != null) {
                    //如果要删除的节点是最后一个节点，则此语句不执行
                    node.next.prev = node.prev;
                } else {
                    tail = node.prev;  //更新tail
                }
                node.next = node.prev = null;
                break;
            }
            node = node.next;
        }
    }

    public HeroNode getHead() {
        return head;
    }

    /**
     * 增加节点
     * 1.如果链表为空，则直接设置为head的next
     * 2.如果链表不为空，则遍历链表，找到哪个节点（nodeA）的val大于传入的node的val，将传入的node添加到nodeA前面
     * 3.如果第2步没有找到对应的nodeA，则说明传入的node的val是最大的，需要添加到链表的末尾
     * @param node
     */
    public void add(HeroNode node) {
        HeroNode tmpHead = head;
        boolean found = false;
        //1.
        if(head.next == null) {
            head.next = node;
            node.prev = head;
            tail = node; //更新tail
            return;
        }
        //2.
        while (tmpHead.next != null) {
            if (tmpHead.next.val > node.val) {
                found = true;
                //修改指针指向
                HeroNode next = tmpHead.next;
                node.next = next;
                tmpHead.prev.next = node;

                node.prev = tmpHead.prev;
                next.prev = node;
                break;
            }
            tmpHead = tmpHead.next;
        }
        //3.
        if (!found) { //将node追加到链表最后
            tail.next = node;
            node.prev = tail;
            tail = node;  //重新设置tail
        }

    }

    public void showElements() {

        if (head.next == null) {
            System.out.println("null");
            return;
        }
        HeroNode tmp = head.next;
        while (tmp != null) {
            System.out.print(tmp.name);
            System.out.print(":");
            System.out.print(tmp.val);
            if (tmp.next != null) {
                System.out.print(" -> ");
            }
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void showReverseElements() {

        if (head.next == null) {
            System.out.println("null");
            return;
        }
        HeroNode tmp = tail;
        List<HeroNode> list = new ArrayList<>();
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.prev;
        }
        list.remove(list.size() - 1);
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).name);
            System.out.print(":");
            System.out.print(list.get(i).val);
            if (i != list.size() - 1) {
                System.out.print(" <- ");
            }
        }
        System.out.println();
    }

    static class HeroNode extends AbstractNode{

        public HeroNode next;

        public HeroNode prev;

        public HeroNode(String name, Integer val) {
            super(val);
            super.name = name;
        }

        public HeroNode(Integer val) {
            super(val);
        }

    }
}

