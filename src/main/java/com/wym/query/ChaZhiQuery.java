package com.wym.query;

import java.util.Arrays;

/**
 * 插值查找
 * 属于二分查找的变种，适用于查找有序集合，且集合中的数字相差大小比较均匀的情况，如：等差数列
 * 在二分查找中，索引mid即为目标数据的位置，mid = left + (right - left) * 1/2,
 * 在插值查找中，唯一不同的就是mid的计算方式，mid = left + (right - left) * (targetVal - left) / (right - left)
 */
public class ChaZhiQuery {

    public static int invokeCount = 0;

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));


        int index = chaZhiQuery(arr, 0, 1, arr.length - 1);
        System.out.println("index===" + index);
        System.out.println("invokeCount====" + invokeCount);
    }

    private static int chaZhiQuery(int[] arr, int targetVal, int left, int right) {
        invokeCount++;
        if (left > right) {
            throw new RuntimeException("targetVal不存在");
        }
        int mid = left + (right - left) * (targetVal - left) / (right - left);
        if (arr[mid] == targetVal) {
            return mid;
        } else if (arr[mid] > targetVal) {
            return chaZhiQuery(arr, targetVal, left, mid - 1);
        } else {
            return chaZhiQuery(arr, targetVal, mid + 1, right);
        }
    }
}
