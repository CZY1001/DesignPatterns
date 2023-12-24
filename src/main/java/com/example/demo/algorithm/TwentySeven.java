package com.example.demo.algorithm;


/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class TwentySeven {

    public int removeElement(int[] nums, int val) {
        //本质上也是双指针往后，把原始数组当做一个空容器，遍历原始数组，如果不等于指定元素，就添加覆盖到原始容器里，从头开始
        int ans = 0;
        for (int i: nums){
            if (i!=val){
                nums[ans] = i;
                ans++;
            }
        }
        return ans;
    }
}
