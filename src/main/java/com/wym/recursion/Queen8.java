package com.wym.recursion;

/**
 * 八皇后问题
 */
public class Queen8 {

    private static int count = 0;
    public static void main(String[] args) {

        int[] arr = new int[8];
        check(arr, 0);

        System.out.println("count=" + count);
    }

    /**
     *
     * @param arr 存放皇后的数组
     * @param n 第n个皇后
     */
    private static void check(int[] arr, int n) {

        if (n == 8) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            count++;
            System.out.println();
            System.out.println();
            return;
        }
        for (int i = 0; i < 8; i++) {
            arr[n] = i;
            if (judge(arr, n)) {  //第n个皇后放在索引为i的位置时合适的，不会互相攻击
                check(arr, n + 1);   //查找下一个皇后应该放置的位置
            }
        }
    }

    private static boolean judge(int[] arr, int n) {

        for (int j = 0; j < n; j++) {
            //不能同列或互为对角线
            if (arr[j] == arr[n] || n - j == Math.abs(arr[n] - arr[j])) {
                return false;
            }
        }
        return true;
    }
}
