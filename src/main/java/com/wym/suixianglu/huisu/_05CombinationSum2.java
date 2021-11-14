package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class _05CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, 0, result, list);
        return result;
    }

    private void combinationSum2(int[] candidates, int target, int startIndex, int sum, List<List<Integer>> result, LinkedList<Integer> list){
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            if(i > 0 && candidates[i] == candidates[i - 1] && i > startIndex){
                continue;
            }
            list.add(candidates[i]);
            combinationSum2(candidates, target, i + 1, candidates[i] + sum, result, list);
            list.removeLast();
        }

    }
}
