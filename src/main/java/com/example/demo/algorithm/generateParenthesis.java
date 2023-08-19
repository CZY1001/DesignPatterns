package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author czy
 * @description 括号生成
 * @date 2023/8/19
 */
public class generateParenthesis {


    public static void main(String[] args) {
        generateParenthesis generateParenthesis = new generateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(4);
        System.out.println(strings);
    }

    /**
     *
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：["()"]
     *
     *
     * @param n
     * @return
     */
    List<String> res  = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }
    /**
     * 添加一个递归方法
     * @param str
     * @param left
     * @param right
     */
    private  void getParenthesis(String str,int left,int right){
        if (left ==0 && right == 0){
            res.add(str);
            return;
        }
        if (left == right){
            //如果左括号和右括号一样，那下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        } else if (left < right) {
            //剩余左括号小于右括号,下一个可以用左括号也可以用右括号
            if (left>0){
                getParenthesis(str + "(",left-1,right);
            }
            getParenthesis(str + ")", left, right-1);
        }
    }
}
