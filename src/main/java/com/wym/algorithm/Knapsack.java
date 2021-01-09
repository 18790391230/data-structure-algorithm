package com.wym.algorithm;


/**
 * 背包问题
 *
 * 动态规划类型
 */
public class Knapsack {

    public static void main(String[] args) {

        int[] weight = new int[]{1, 4, 3};
        int[] val = new int[]{1500, 3000, 2000};
        String[] goods = new String[]{"吉他", "音响", "电脑"};
        int max = 4; //背包最大容量

        //v[i][j]表示在前i个物品中能够装入容量为j背包的最大价值
        int[][] v = new int[val.length + 1][max + 1];
        //记录物品放入情况
        int[][] path = new int[v.length][v[0].length];
        
        //第一行及第一列初始化为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }
        
        //从第一行第一列开始
        for (int goodsIndex = 1; goodsIndex < v.length; goodsIndex++) {
            for (int packageCapacity = 1; packageCapacity < v[0].length; packageCapacity++) {
                //背包容量大于等于物品磅数
                if (packageCapacity >= weight[goodsIndex - 1]) {
//                    v[goodsIndex][packageCapacity] = Math.max(v[goodsIndex - 1][packageCapacity],
//                            val[goodsIndex - 1] + v[goodsIndex - 1][packageCapacity - weight[goodsIndex - 1]]);
                    if (v[goodsIndex - 1][packageCapacity] >= val[goodsIndex - 1] +
                            v[goodsIndex - 1][packageCapacity - weight[goodsIndex - 1]]) {
                        v[goodsIndex][packageCapacity] = v[goodsIndex - 1][packageCapacity];
                    } else {
                        v[goodsIndex][packageCapacity] = val[goodsIndex - 1] +
                                v[goodsIndex - 1][packageCapacity - weight[goodsIndex - 1]];
                        path[goodsIndex][packageCapacity] = 1;
                    }
                } else {
                    v[goodsIndex][packageCapacity] = v[goodsIndex - 1][packageCapacity];
                }
            }
        }

        print(v);

        print(path);

        int i = v.length - 1;
        int j = v[0].length - 1;
        while (i >= 0 && j >= 0) {
            if (path[i][j] == 1) {
                System.out.println(goods[i - 1] + "放入背包");
                j -= weight[i - 1];
            }
            i--;
        }
        
    }

    private static void print(int[][] v) {

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("=======================================");
    }
}
