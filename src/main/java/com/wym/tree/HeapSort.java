package com.wym.tree;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆排序：分为大顶堆和小顶堆
 * 大顶堆定义：每个节点的值大于或等于其左右子节点的值，但左右节点无序
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("待排序数组：");
        System.out.println(Arrays.toString(arr));
        System.out.println();


        //1. 将数据构造成一个大顶堆
        for (int i = arr.length / 2 + 1; i >= 0 ; i--) {
            adjustTree(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            //2. 最大值与末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //3. 重新调整堆，使其满足大顶堆定义
            adjustTree(arr, 0, i);
        }

        System.out.println("排序结果：");
        System.out.println(Arrays.toString(arr));
    }

    private static void adjustTree(int[] arr, int index, int length) {

        int temp = arr[index];
        for (int i = 2 * index + 1; i < length; i = i * 2 + 1) {
            //index左子节点小于右子节点
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++; //使i指向index的右子节点，也就是指向index子节点中的最大值
            }
            if (temp < arr[i]) { //index的2个子节点比index节点大
                arr[index] = arr[i];
                index = i;  //调整后可能导致下面的子树不满足大顶堆定义，所以需要继续向下调整
            } else {
                break;
            }

        }
        arr[index] = temp;

    }

}
