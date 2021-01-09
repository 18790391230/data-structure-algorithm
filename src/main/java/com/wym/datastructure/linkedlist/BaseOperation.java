package com.wym.datastructure.linkedlist;


public class BaseOperation {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        addTest(list);

        list.showElements();

//        deleteTest(list);

        updateTest(list);
    }

    private static void addTest(LinkedList list) {

        LinkedList.Node node1 = new LinkedList.Node(1);
        node1.name = "aaa";
        list.add(node1);

//        LinkedList.Node node2 = new LinkedList.Node(2);
//        node2.name = "bbb";
//
//        LinkedList.Node node3 = new LinkedList.Node(3);
//        node3.name = "ccc";
//
//        LinkedList.Node node4 = new LinkedList.Node(4);
//        node4.name = "ddd";
//
//        list.add(node2);
//        list.add(node3);
//        list.add(node4);
    }

    private static void updateTest(LinkedList list) {

        LinkedList.Node node = new LinkedList.Node(400);
        node.name = "ddd";
        list.update(node);
        list.showElements();
    }

    private static void deleteTest(LinkedList list) {

        list.remove("aaa");
        list.showElements();
//
//        list.remove("ccc");
//        list.showElements();

        list.remove("ddd");
        list.showElements();
    }
}

class LinkedList{

    private Node head = null;
    private Node tail = null;

    public int length() {
        Node node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public void remove(String name) {
        if (head == null) {
            return;
        }
        Node node = head;
        Node pre = null;
        while (node != null) {
            if (name.equals(node.name)) {
                if (pre == null) { //第一个节点就找到了
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                    }
                } else {
                    pre.next = node.next;
                }
                break;
            }
            pre = node;
            node = node.next;
        }
    }

    public void update(Node node) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.name.equals(node.name)) {
                tmp.val = node.val;
                break;
            }
            tmp = tmp.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void add(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void showElements() {

        if (head == null) {
            System.out.println("null");
            return;
        }
        Node tmp = head;
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
    public static class Node extends AbstractNode{

        public Node next;

        public Node(Integer val) {
            super(val);
        }
    }

}
