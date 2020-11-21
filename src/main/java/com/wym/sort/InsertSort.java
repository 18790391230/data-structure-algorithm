package com.wym.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -2};

        for (int i = 1; i < arr.length; i++) {
//            doSort(arr, i);
            doSort2(arr, i);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void doSort(int[] arr, int index) {

        int maxIndex = index - 1;
        int insertVal = arr[index];
        while (true) {
            if (maxIndex >= 0 && arr[maxIndex] < insertVal) {
                arr[maxIndex + 1] = arr[maxIndex];
            } else {
                arr[maxIndex + 1] = insertVal;
                break;
            }
            maxIndex--;
        }
    }

    private static void doSort2(int[] arr, int index) {

        int insertVal = arr[index];
        int i = index;
        while (i - 1 >= 0 && insertVal > arr[i - 1]) {
            arr[i] = arr[i - 1];
            i--;
        }
        arr[i] = insertVal;
    }
}
