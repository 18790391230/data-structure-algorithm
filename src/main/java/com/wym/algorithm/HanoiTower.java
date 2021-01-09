package com.wym.algorithm;

/**
 * 汉诺塔问题
 * 属于分治算法
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    private static void hanoiTower(int num, char source, char temp, char target) {
        if (num == 1) {
            System.out.println(source + " -> " + target+"---");
        } else {
            //1.A塔上面所有的盘放到B塔(除最下面一个盘外)
            hanoiTower(num - 1, source, target, temp);
            //2.A塔最下面的盘放到C塔
            System.out.println(source + " -> " + target);
            //3.将B塔所有盘放到C塔
            hanoiTower(num - 1, temp, source, target);
        }
    }
}
