package com.wym.linkedlist;

public abstract class LinkedListUtils {


    public static LinkedList getLinkedList(int nodeCount) {
        LinkedList list = new LinkedList();

        for (int i = 0; i < nodeCount; i++) {
            LinkedList.Node node = new LinkedList.Node(i + 1);
            node.name = (i + 1) + "";
            list.add(node);
        }

        return list;
    }
}
