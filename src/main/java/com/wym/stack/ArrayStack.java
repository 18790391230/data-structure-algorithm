package com.wym.stack;

public class ArrayStack {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(8);

        for (int i = 0; i < 8; i++) {
            stack.push(i);
        }

        System.out.println("stack.isEmpty():" + stack.isEmpty());
        System.out.println("stack.isFull():" + stack.isFull());
        System.out.println("stack.pop():" + stack.pop());
        System.out.println("stack.pop():" + stack.pop());
        System.out.println("stack.pop():" + stack.pop());
        System.out.println("stack.isFull():" + stack.isFull());
    }


    private int size = 0;

    private int top = -1;

    private Integer[] arr = null;

    public ArrayStack(int size) {
        this.size = size;
        arr = new Integer[size];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(Integer item) {
        arr[++top] = item;
    }

    public Integer pop() {
        Integer result = arr[top];
        arr[top] = null;
        top--;
        return result;
    }

    public void list() {
        if (top >= 0) {
            for (int i = 0; i <= top; i++) {
                System.out.println(arr[i]);
            }
        } else {
            System.out.println("null");
        }
    }
}
