package com.wym.sort;


import java.util.Arrays;

/**
 * 归并排序
 * 思想：将两个有序集合合并为一个有序集合，一个无序集合怎样拆分为多个有序集合？当一个集合只有一个数据时，则这个集合是有序的，
 * 所以需要将无需集合进行递归拆分，拆分到每组集合之后一个数据，然后进行合并即可。
 *
 * 拆分时是连续位置拆分的，比如现在有8个数据
 * 第一次拆分结果：索引0 - 3为一组， 4 - 7一组
 * 第二次拆分结果：0 - 3拆分为0 - 1和2 - 3， 4 - 7拆分为4 - 5和5 - 6
 * 第三次拆分结果：索引为0,1,2,3,4,5,6,7各一组
 * 现在可以开始合并了...
 * 合并时需要知道两组数据分别的起始位置和结束位置，因为需要合并的两组数据索引时连续的，
 * 所以可以使用left表示左边的待合并集合起始索引
 * mid用来表示左边待排序集合的结束索引和右边待排序集合的起始索引，
 * right用来表示右边待排序集合的结束索引
 * 合并后的数据需要放到另外一个集合中，所以归并排序需要额外的空间
 *
 * 因为每组数据合并后的数据是放到了另外一个集合中，所以在每组数据合并完成后，需要将另外一个集合中的数据重新填充到待排序集合的对应位置！
 *
 * 综上，合并方法需要5个参数：
 * 1. left
 * 2. mid
 * 3. right
 * 4. arr：待排序数组
 * 5. tmp：临时数组
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println("排序后的结果是========");
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);

        //第一次调用到下面的一行代码是当拆分为每组只剩下一个元素时，这时到了该merge的时候了
        merge(arr, left, mid, right, temp);
    }


    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int index = 0;
        int l = left, r = mid + 1;
        //1.合并
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[index++] = arr[l];
                l++;
            } else {
                temp[index++] = arr[r];
                r++;
            }
        }

        //2.可能剩余一些未排序的数据
        while (l <= mid) {
            temp[index++] = arr[l];
            l++;
        }

        while (r <= right) {
            temp[index++] = arr[r];
            r++;
        }

        //3.拷贝数据
        index = 0;
        for (int i = left; i <= right; i++) {
            arr[i] = temp[index++];
        }

    }
}
