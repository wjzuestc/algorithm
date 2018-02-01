package com.blog.sort;

/**
 * @Description: 快速排序 划分 填坑
 * @Author: Jingzeng Wang
 * @Date: Created in 18:07  2017/12/21.
 */
public class QuickSort {

    private static int[] nums = {1, 23, 4, 5, 5, 6, 7, 9};

    public static void quickSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }
        int index = nums[left];
        int l = left;
        int r = right;
        while (left < right) {
            while (right > left && index < nums[right]) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && index >= nums[left]) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = index;
        quickSort(nums, l, left - 1);
        quickSort(nums, left + 1, r);
    }

    public static void main(String[] args) {
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
