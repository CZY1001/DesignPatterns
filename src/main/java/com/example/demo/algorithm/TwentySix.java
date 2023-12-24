package com.example.demo.algorithm;

/**
 * 删除有序数组中的重复项
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 */
public class TwentySix {
    public int removeDuplicates(int[] nums) {
        //校验长度为空的情况
        if (nums.length ==0){
            return 0;
        }
        //快慢指针来做
        int i = 0;
        //慢指针指向当前数组第一个参数、快指针指向第二个
        for (int j = 1 ;j < nums.length;j++){
            //当前数据和下一个数据不一样的时候
            if (nums[i]!= nums[j]){
                //慢指针往后走，交换保存、这样所有的重复数据都被一点点的移到了后面
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
