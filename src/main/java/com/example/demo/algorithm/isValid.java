package com.example.demo.algorithm;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author czy
 * @description 有效的括号
 * @date 2023/8/19
 */
public class isValid {
    public static void main(String[] args) {
        System.out.println(isValid("([{}])"));
    }


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     *
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        //先判断下字符串长度是不是偶数，如果不是，直接无脑false
        if (s.length() % 2 == 1){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //正括号全部进栈，反括号去map里面匹配，然后和栈顶元素匹配
            if(map.containsKey(ch)){
                if (stack.isEmpty()||stack.peek() != map.get(ch)){
                    return false;
                }
                //匹配上了，就把栈里的删一个
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
