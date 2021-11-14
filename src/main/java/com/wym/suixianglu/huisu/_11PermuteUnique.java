package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class _11PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permuteUnique(nums, used);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    private void permuteUnique(int[] nums, boolean[] used){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            if(!used[i]){
                used[i] = true;
                list.add(nums[i]);
                permuteUnique(nums, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
