package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 */
public class _10Permute {

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permute(nums, used);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    private void permute(int[] nums, boolean[] used){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            permute(nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
