package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II
 *
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 */
public class _09SubsetII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        subsetsWithDup(nums, 0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    private void subsetsWithDup(int[] nums, int startIndex){
        result.add(new ArrayList<>(list));
        if(startIndex == nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
            if(i > startIndex && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            subsetsWithDup(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
