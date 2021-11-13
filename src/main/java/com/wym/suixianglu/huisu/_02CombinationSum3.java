package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合求和III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 */
public class _02CombinationSum3 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3(k, n, 1, 0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    private void combinationSum3(int k, int n, int startIndex, int sum){
        if(list.size() == k){
            if(sum == n){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i = startIndex; i <= 9 - (k - list.size()) + 1; i++){
            list.add(i);
            combinationSum3(k, n, i + 1, sum + i);
            list.removeLast();
        }
    }
}
