package com.wym.sort;

import java.util.Arrays;

public class ShellSort {


    public static void main(String[] args) {

        int[] arr = new int[10];
        int index = 0;
        for (int i = 10; i > 0; i--) {
            arr[index++] = i;
        }
//        swap(arr);

        move(arr);
    }

    private static void move(int[] arr) {

        System.out.println("排序前==============");
        System.out.println(Arrays.toString(arr));

        int step = arr.length;

        while ((step = step / 2) > 0) {  //当step == 1时，是最后一轮排序
            for (int i = step; i < arr.length; i++) {  //这个循环每执行一次，相当于进行一次插入排序
                int insertVal = arr[i];
                int j = i;
                while (j - step >= 0 && insertVal < arr[j - step]) {
                    arr[j] = arr[j - step];
                    j -= step;
                }
                arr[j] = insertVal;
            }
        }

        System.out.println("排序后==============");
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr) {
        System.out.println("排序前==============");
        System.out.println(Arrays.toString(arr));

        int step = arr.length;

        int temp = 0;
        while ((step = step / 2) > 0) {
            for (int i = step; i < arr.length; i++) {  //这个循环每执行一次，相当于进行一次插入排序
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
