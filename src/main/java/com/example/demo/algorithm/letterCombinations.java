package com.example.demo.algorithm;

import org.apache.logging.log4j.util.Strings;
import org.elasticsearch.index.Index;

import java.util.*;

/**
 * @author czy
 * @description 电话号码的字母组合
 * @date 2023/8/18
 */
public class letterCombinations {
    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     * <p>
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        Collections.sort(list);

        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        backtrack(list, phoneMap, digits, 0, new StringBuffer());
        return list;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer sbuf) {
        if (digits.length() == index) {
            combinations.add(sbuf.toString());
        } else {
            char digit = digits.charAt(index);
            //获取当前数字对应的map映射   abc   、  def
            String letters = phoneMap.get(digit);
            int length = letters.length();
            for (int i = 0; i < length; i++) {
                //添加当前位置上的字母
                sbuf.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, sbuf);
                sbuf.deleteCharAt(index);
            }
        }
    }
}
