package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class _01Combine {

    public List<List<Integer>> combine(int n, int k) {

        combine(n, k, 1);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    private void combine(int n, int k, int startIndex){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = startIndex; i <= n - (k - list.size()) + 1; i++){
            list.add(i);
            combine(n, k, i + 1);
            list.removeLast();
        }
    }
}
