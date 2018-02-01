package com.blog.sort;

import java.util.Arrays;

/**
 * @Description: 选择排序 O(n^2) 时间复杂度与输入无关  不稳定
 * @Author: Jingzeng Wang
 * @Date: Created in 9:52  2017/8/26.
 */
public class SelectSort {
    /**
     * 选择排序：从待排序的序列中选出最小的放在序列开始位置，直至所有的数都排列完
     * 第一个for: 代表选出的最小的数，要替换的位置
     * 第二个for: 代表比较循环，从i+1开始，比较其与i的数值大小关系
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] array = {8, 5, 6, 9, 1, 2, 2, 3, 11};
        selectSort(array);
    }
}
