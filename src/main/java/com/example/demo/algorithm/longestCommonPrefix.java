package com.example.demo.algorithm;

/**
 * @author czy
 * @description 最长公共前缀
 * @date 2023/8/17
 */
public class longestCommonPrefix {
    public static void main(String[] args) {

    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     *
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j<res.length() && j < strs[i].length() && res.charAt(j) == strs[i].charAt(j)){
                j++;
            }
            res = res.substring(0,j);
        }

        return res;
    }
}
