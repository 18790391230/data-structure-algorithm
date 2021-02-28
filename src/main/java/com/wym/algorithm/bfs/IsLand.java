package com.wym.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 孤岛问题
 */
public class IsLand {


    public static void main(String[] args) {
        //使用二维数组描述孤岛

//        String[][] grid = {
//                {"1", "1", "1", "1", "0"},
//                {"1", "1", "0", "1", "0"},
//                {"1", "1", "0", "0", "0"},
//                {"0", "0", "0", "0", "0"}
//        };

        String[][] grid = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };
        //使用二维数组标记这个位置是否被访问过
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int number = 0;
        //遍历grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //只要等于1且未被访问过，则找到一个小岛
                if (grid[i][j].equals("1") && !visited[i][j]) {
                    bfs(i, j, grid, visited);
                    System.out.println("============================");
                    number++;
                }
            }
        }

        System.out.println("找到" + number + "个小岛！");

    }

    private static void bfs(int x, int y, String[][] grid, boolean[][] visited) {

        int[] xs = {1, -1, 0, 0};
        int[] ys = {0, 0, -1, 1};
        visited[x][y] = true;

        Queue<Integer> xQueue = new ArrayDeque<>();
        Queue<Integer> yQueue = new ArrayDeque<>();
        xQueue.add(x);
        yQueue.add(y);

        //开始根据x，y进行广度优先搜索
        while (!xQueue.isEmpty()) {
            Integer pollx = xQueue.poll();
            Integer polly = yQueue.poll();
            for (int i = 0; i < xs.length; i++) {
                int newX = pollx + xs[i];
                int newY = polly + ys[i];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY]) {
                    if (grid[newX][newY].equals("1")) {
                        xQueue.add(newX);
                        yQueue.add(newY);
                        visited[newX][newY] = true;
                    }
                }
            }
        }

    }


}
