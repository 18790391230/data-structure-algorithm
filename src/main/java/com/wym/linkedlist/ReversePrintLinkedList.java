package com.wym.linkedlist;

import java.text.MessageFormat;
import java.util.Stack;

/**
 * 逆序打印单向链表
 * 思路：两种方式
 * 1. 先将链表反转，然后打印
 * 2. 使用栈
 */
public class ReversePrintLinkedList {


    public static void main(String[] args) {
        LinkedList list = LinkedListUtils.getLinkedList(5);

        LinkedList.Node node = list.getHead();

        Stack<LinkedList.Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node); //入栈
            node = node.next;
        }

        while (stack.size() > 0) {
            LinkedList.Node tmp = stack.pop(); //出栈
            System.out.println(MessageFormat.format("name={0}, val={1}", tmp.name, tmp.val));
        }

    }
}
