package com.wym.sort;

import java.util.Arrays;

public class ShellSort {


    public static void main(String[] args) {

        int[] arr = new int[10];
        int index = 0;
        for (int i = 10; i > 0; i--) {
            arr[index++] = i;
        }
        System.out.println("排序前==============");
        System.out.println(Arrays.toString(arr));

        int step = arr.length;

        int temp = 0;
        while ((step = step / 2) > 0) {
            for (int i = step; i < arr.length; i++) {
                for (int j = i - step; j >= 0; j-=step) {
                    if (arr[j] > arr[j + step]) {
                        temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
        }

        System.out.println("排序后==============");
        System.out.println(Arrays.toString(arr));

    }
}
