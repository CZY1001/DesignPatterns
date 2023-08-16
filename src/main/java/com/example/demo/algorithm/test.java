package com.example.demo.algorithm;

/**
 * @author czy
 * @description
 * @date 2023/8/15
 */
public class test {
    public static void main(String[] args) {

    }

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int res = 0;
        while (i< j){
            res = height[i] < height[j] ? Math.max(res , (j-i) * height[i++]):Math.max(res, (j-i) * height[j--]);
        }
        return res;
    }



    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 例如，121 是回文，而 123 不是。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x <0){
            return false;
        }
        int cur = 0;
        int num = x;
        while (num != 0){
            cur = cur*10 + num % 10;
            num/= 10;
        }
        return x==cur;
    }
}
















