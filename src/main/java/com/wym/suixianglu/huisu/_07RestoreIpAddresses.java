package com.wym.suixianglu.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按 任何 顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 */
public class _07RestoreIpAddresses {


    public List<String> restoreIpAddresses(String s) {
        restoreIpAddress(s, 0);
        return result;
    }

    List<String> result = new ArrayList<>();
    List<String> list = new ArrayList<>();

    private void restoreIpAddress(String s, int startIndex) {
        if (list.size() == 4) {
            if(startIndex == s.length()){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    if (i > 0) {
                        sb.append(".");
                    }
                    sb.append(list.get(i));
                }
                result.add(sb.toString());
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isDigit(s, startIndex, i + 1)) {
                list.add(s.substring(startIndex, i + 1));
            } else {
                break;
            }
            restoreIpAddress(s, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private boolean isDigit(String s, int i, int j) {
        String substr = s.substring(i, j);
        if (substr.length() > 1 && substr.startsWith("0")) {
            return false;
        }
        if (substr.length() > 3) {
            return false;
        }
        if (Integer.parseInt(substr) > 255) {
            return false;
        }
        return true;
    }

}
