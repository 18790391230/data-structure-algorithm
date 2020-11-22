package com.wym.sort;

import java.util.Arrays;

/**
 * 快速排序，是对冒泡排序的一种优化，冒泡效率的问题是：每排序一个数字，需要对待排序的所有数据进行比较，
 * 而快速排序的思想是：选定一个数作为中轴数，将待排序集合分为左右两部分，比中间的数大的放到中轴数的右边，比中间的数小的放到
 * 中轴数的左边，这样，当需要对左边数据进行排序时，只需要对左边的数进行比较，而不是像冒泡那样将剩余所有待排序的数据进行比较
 *
 * 思路：
 * 1.选择中轴数，可以选择最右边的数据作为中轴数
 * 2.使用left指针和right指针向中间遍历，通过交换，大于中轴数的数放到中轴数的右边，小于中轴数的数放到中轴数的左边，
 * 最后将中轴数设置到left的位置，一轮排序完成后，再分别对左边数据和右边数据进行排序，当left>=right时，达到递归结束条件
 */
public class QuickSort {

    private static final int COUNT = 8;

    public static void main(String[] args) {

        int[] arr = new int[COUNT];
        int index = 0;
        for (int i = COUNT; i > 0; i--) {
            arr[index++] = i;
        }
        long startTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println("排序耗时：" + (System.currentTimeMillis() - startTime));
    }

    private static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        //选择最右边的数作为中轴数
        int pivot = arr[end];
        //设置左右指针
        int left = start, right = end;

        while (left < right) { //当left>=right时，一轮排序结束
            while (left < right && arr[left] < pivot) {
                left++;
            }
            arr[right] = arr[left];
            while (left < right && arr[right] > pivot) {
                right--;
            }
            arr[left] = arr[right];
        }
        arr[left] = pivot;
        if (left - 1 > start) {
            quickSort(arr, start, left - 1);
        }
        if (end > right - 1) {
            quickSort(arr, right + 1, end);
        }
    }
}
