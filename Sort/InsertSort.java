package com.blog.sort;

import java.util.Arrays;

/**
 * @Description: 直接插入排序 O(n^2)  其时间复杂度与输入有关   如果输入是有序的话，则时间复杂度为O(n)
 * 稳定的排序算法
 * @Author: Jingzeng Wang
 * @Date: Created in 9:42  2017/8/26.
 */
public class InsertSort {

    /**
     * 直接插入排序：将数字插入到已经排序的序列中，使之还是有序的
     * 第一个for: 依次插入的数
     * 第二个： 将要插入的数与前i个数比较  （或 break  来结束不必要的比较）
     * 此操作将算法的最优时间复杂度变为O(n)
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
        int[] array = {11, 12, 3, 8, 5, 1, 2, 3, 18};
        insertSort(array);
    }
}
