package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 */
public class _03LetterCombination {

    public static void main(String[] args) {

    }

    String[] arr = new String[]{null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        combination(digits, 0);
        return result;
    }

    private void combination(String digits, int index) {
        if (list.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            list.forEach(sb::append);
            result.add(sb.toString());
            return;
        }
        int temp = Integer.parseInt(digits.charAt(index) + "");
        for (int i = 0; i < arr[temp].length(); i++) {
            list.add(arr[temp].charAt(i) + "");
            combination(digits, index + 1);
            list.removeLast();
        }


    }

}
