package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 *
 */
public class _04CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates, 0, target, 0);
        return result;
    }
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    private void combinationSum(int[] candidates, int startIndex, int target, int sum){
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = startIndex; i < candidates.length && (candidates[i] + sum <= target); i++){
            list.add(candidates[i]);
            combinationSum(candidates, i, target, sum + candidates[i]);
            list.removeLast();
        }
    }
}
