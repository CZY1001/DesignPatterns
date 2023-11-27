package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * 15. 三数之和  -(2023,10.13百度笔试出现过)
 * <p>
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class fifteen {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        //先校验
        if (nums == null || len < 3) {
            return ans;
        }
        //先给他排个序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                //如果说当前这个数大于0，那么他后面的数加一起肯定是大于0 的，没有意义
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //如果当前这个数等于前面这个，那就是重复了，没什么意义
                continue;
            }
            //左右俩指针
            int zuo = i + 1;
            int you = len - 1;
            while (zuo < you) {
                int sum = nums[i] + nums[zuo] + nums[you];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[zuo], nums[you]));
                    /*while (you < zuo && nums[zuo] == nums[you+1]){
                        you++;
                    }*/
                    zuo++;
                    you--;
                } else if (sum > 0) {
                    you--;
                } else if (sum < 0) {
                    zuo++;
                }
            }
        }
        return ans.stream().distinct().collect(Collectors.toList());

    }
}
