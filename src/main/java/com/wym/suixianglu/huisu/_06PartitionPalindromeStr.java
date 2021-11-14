package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 */
public class _06PartitionPalindromeStr {


    public List<List<String>> partition(String s) {
        partition(s, 0);
        return result;
    }

    LinkedList<String> list = new LinkedList<>();
    List<List<String>> result = new ArrayList<>();

    private void partition(String s, int startIndex){
        if(startIndex == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            if(isPalindrome(s, startIndex, i)){
                list.add(s.substring(startIndex, i + 1));
            }else{
                continue;
            }
            partition(s, i + 1);
            list.removeLast();
        }
    }


    private boolean isPalindrome(String s, int left, int right){
        for(int i = left, j = right; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
