package com.wym.array;

/**
 * 环形数组队列
 */
public class CircleArrayQueueTest {

    public static final int SIZE = 4;

    public static void main(String[] args) {

//        emptyTest();
//        fullTest();
        showData();

    }

    private static void emptyTest() {
        CircleArrayQueue queue = new CircleArrayQueue(SIZE);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("队列是否为空：" + queue.isEmpty());
        System.out.println("开始出队列：");
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println("队列是否为空：" + queue.isEmpty());
    }

    private static void fullTest() {
        CircleArrayQueue queue = new CircleArrayQueue(SIZE);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.getQueue());
        queue.add(4);
        System.out.println("队列是否已满：" + queue.isFull());
    }

    private static void showData() {
        CircleArrayQueue queue = new CircleArrayQueue(SIZE);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.showElements();
    }
}

/**
 * 队列需要具有的方法：
 * 1.队列是否为空
 * 2.队列是否已满
 * 3.出队列
 * 4.进队列
 * 5.队列中有效数据的个数
 * 6.打印队列中所有的数据
 *
 * 实现思路：
 * 1.需要有一个head变量及tail变量，其中head变量保存队列中第一个数据的索引位置，tail变量保存队列中最后一个数据索引位置的后一个索引
 * 2.使用数组模拟队列
 */
class CircleArrayQueue {

    private int size;
    private int[] arr = null;
    private int head = 0;
    private int tail = 0;

    public CircleArrayQueue(int size) {
        this.size = size;
        arr = new int[size];
    }

    /**
     * 队列是否满
     * head与tail的位置有2种情况
     * 1.head索引小于tail索引，则(tail + 1)%size == head
     * 2.head索引大于tail索引，则tail + 1 == head
     * @return
     */
    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void add(int val) {
        if (isFull()) {
            throw new RuntimeException("队列已满！");
        }

        //先将数据存到索引为tail的位置
        arr[tail] = val;
        //然后tail+1
        tail = (tail + 1)  % size;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }

        int val = arr[head];

        head = (head + 1)  % size;
        return val;
    }

    /**
     * 有效元素个数
     * @return
     */
    public int size() {
        //同样分两种情况
        //1.head索引小于tail索引, tail - head
        //2.head索引大于tail索引, (tail - head)%size
        return (tail - head + size) % size;
    }

    public void showElements() {
        for (int i = head; i < head + size(); i++) {
            System.out.print(arr[i % size] + "\t");
        }
        System.out.println();
    }
}
