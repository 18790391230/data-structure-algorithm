package com.wym.recursion;

/**
 * 迷宫问题本质：
 * 只走没走过的路，对走过的路进行标记，走的过程需要一定的策略，假设先向下，再向右，后向上，最后向左
 * 找不到出路的情况
 *
 * 使用二维数组描述迷宫的每个位置，0表示这个位置没有走过，1表示墙，2表示这个点可以走并已经走过,3表示这个点已经走过，但是走不通
 */
public class MazeIssue {

    public static void main(String[] args) {

        int[][] map = new int[8][7];

        //初始化墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //初始化挡板
        map[3][1] = 1;
        map[3][2] = 1;
        showMap(map);
        System.out.println();
        System.out.println();

        //从1,2位置开始走
        setWay(map, 2, 1);
        showMap(map);
    }

    private static boolean setWay(int[][]map, int i, int j) {

        if (map[4][1] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) { //此路没走过，尝试走一下
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    System.out.println("i=" + i + "  j=" + j);
                    return true;
                }else if (setWay(map, i, j + 1)) {
                    System.out.println("i=" + i + "  j=" + j);
                    return true;
                }else if (setWay(map, i - 1, j)) {
                    System.out.println("i=" + i + "  j=" + j);
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    System.out.println("i=" + i + "  j=" + j);
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    private static void showMap(int[][] map) {
        for (int[] ints : map) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
