package com.wym.array;

/**
 * 稀疏数组的应用
 * 使用稀疏数组来保存五子棋棋盘棋子信息，恢复棋盘上次状态
 * 棋盘为11行，11列, 0表示该位置没有棋子，1表示白子，2表示黑子
 *
 * 稀疏数组保存棋子时的格式：
 * 1.一个棋子的位置需要用行号，列号来描述，所以稀疏数组需要保存一个棋子的行列值
 * 2.假设棋盘的行列数是不确定的，需要保存棋盘的行列数及现在棋盘上一共有多少个棋子
 */
public class SparseArray {


    public static void main(String[] args) {

        int[][] sparseArr = qiziToSparseArray();
        System.out.println();
        System.out.println("转换为稀疏数组后的结果：");
        showQiZi(sparseArr);

        sparseArrToQiZiArr(sparseArr);
    }

    private static int[][] qiziToSparseArray() {

        int[][] qiziArr = new int[11][11];

        qiziArr[1][2] = 1;
        qiziArr[2][3] = 2;
        qiziArr[10][10] = 2;

        System.out.println("棋盘状态：");
        showQiZi(qiziArr);

        //1. 获得棋子个数并设置
        int count = 0;
        for (int[] ints : qiziArr) {
            for (int i : ints) {
                if (i > 0) {
                    count++;
                }
            }
        }
        //定义稀疏数组
        int[][] sparseArr = new int[count + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = count;

        //2.遍历数组，将值不是0的位置（棋子）保存到稀疏数组

        int index = 1, val;
        for (int i = 0; i < qiziArr.length; i++) {
            for (int j = 0; j < qiziArr[i].length; j++) {
                if ((val = qiziArr[i][j]) > 0) {
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = val;
                    index++;
                }
            }
        }

        return sparseArr;
    }

    private static void sparseArrToQiZiArr(int[][] sparseArr) {

        int[][] qiziArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            int[] ints = sparseArr[i];
            qiziArr[ints[0]][ints[1]] = ints[2];
        }
        System.out.println();
        System.out.println("稀疏数组转原数组：");
        showQiZi(qiziArr);
    }

    private static void showQiZi(int[][] arr) {

        for (int[] ints : arr) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
