package com.wym.query;

import java.util.Arrays;

/**
 * 二分查找
 *
 * 要求带查找的集合是有序的，每次查找时，都查找中间位置的值，如果中间位置的值小于带查找的值，则以中间位置为起点，原来的终点为终点，
 * 再次查找中间位置的值，如果可以查找到，返回数字所在索引，否则，返回-1
 */
public class BinaryQuery {


    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));


        int index = binaryQuery(arr, 0, arr.length - 1, -70);
        System.out.println("index===" + index);

    }

    private static int binaryQuery(int[] arr, int start, int end, int target) {

        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binaryQuery(arr, start, mid - 1, target);
        }else if (arr[mid] < target) {
            return binaryQuery(arr, mid + 1, end, target);
        }
        return -1;
    }

}
