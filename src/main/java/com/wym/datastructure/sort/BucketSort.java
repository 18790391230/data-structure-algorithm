package com.wym.datastructure.sort;

import java.util.Arrays;

/**
 * 桶排序，又称为基数排序
 *
 * 思想：创建10个桶，每个桶的大小与待排序的集合大小相同，假设待排序的集合中最长的位数为3，即为最大数小于1000，则需要3轮就可以完成排序
 * 在第一轮进行排序时，对待排序的数据 %10 得到个位数，比如个位数是2，就把这个数放到索引为2的桶中（每个桶是一个一维数组），依次将
 * 待排序的数据放到桶中，然后按照索引从小到大的顺序从每个桶中取出数据，放到原来的数组中，这时数组中的数据已经完成了个位数的排序，
 * 接下来继续进行十位数的排序
 * 下面继续进行百位数的排序
 * ...
 * 最后将桶中的数据取出，则完成排序
 *
 * 概括：1. 将数据放到桶中; 2.然后取出来...
 *
 * 桶排序速度很快，但是很耗内存，加入待排序数据占用内存为n，则需要额外的4n空间才可以完成排序
 */
public class BucketSort {

    public static void main(String[] args) {

        int[] arr = new int[]{53, 3, 542, 748, 14, 214};

        int digitLength = String.valueOf(arr[0]).length();
        for (int i = 1; i < arr.length; i++) {
            int length = String.valueOf(arr[i]).length();
            if (length > digitLength) {
                digitLength = length;
            }
        }

        int[][] bucket = new int[10][arr.length];

        int[] bucketDataCount = new int[10];

        for (int bit = 0; bit < digitLength; bit++) {
            for (int i = 0; i < arr.length; i++) {
                int tmp = (int)Math.pow(10, bit);
                int bitDigit = arr[i] / tmp % 10;
                //1. 放到桶中
                bucket[bitDigit][bucketDataCount[bitDigit]] = arr[i];
                bucketDataCount[bitDigit]++;
            }

            //2. 从桶中取出来，放回到原数组中
            int index = 0;
            for (int j = 0; j < bucketDataCount.length; j++) {
                if (bucketDataCount[j] == 0) {
                    continue;
                }
                for (int i = 0; i < bucketDataCount[j]; i++) {
                    arr[index++] = bucket[j][i];
                }
            }
            //个数设置为0，未下一轮做准备
            for (int i = 0; i < bucketDataCount.length; i++) {
                bucketDataCount[i] = 0;
            }
        }

        System.out.println("一轮排序后的结果======");
        System.out.println(Arrays.toString(arr));

    }
}
