package com.wym.datastructure.sort;

import java.util.Arrays;

public class SelectSort {


    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int temp = 0, index = 0;
        for (int i = 0; i < arr.length - 1; i++, index = 0) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            temp = arr[index];
            arr[index] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
