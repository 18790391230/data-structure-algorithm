package com.wym.suixianglu.huisu;


import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * https://leetcode-cn.com/problems/subsets/
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class _08Subset {

    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    private void subsets(int[] nums, int startIndex){
        result.add(new ArrayList<>(list));
        if(startIndex == nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
            list.add(nums[i]);
            subsets(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
