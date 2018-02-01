package com.blog.sort;

/**
 * @Description:
 * @Author: Jingzeng Wang
 * @Date: Created in 18:54  2017/12/21.
 */
public class MegerSort {

    private static int[] nums = {1, 34, 5, 67, 2, 4, 5, 7, 8, 9};
    private static int[] result = new int[nums.length];

    public static void megerSort(int[] nums, int left, int right, int[] result) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        megerSort(nums, left, mid, result);
        megerSort(nums, mid + 1, right, result);
        meger(nums, left, mid, mid + 1, right, result);
    }

    private static void meger(int[] nums, int left1, int right1, int left2, int right2, int[] result) {
        int k = 0;
        int left = left1;
        while (left1 <= right1 && left2 <= right2) {
            if (nums[left1] <= nums[left2]) {
                result[k++] = nums[left1++];
            } else {
                result[k++] = nums[left2++];
            }
        }
        while (left1 <= right1) {
            result[k++] = nums[left1++];
        }
        while (left2 < right2) {
            result[k++] = nums[left2++];
        }
        for (int i = 0; i < k; i++) {
            nums[left++] = result[i];
        }
    }

    public static void main(String[] args) {
        megerSort(nums, 0, nums.length - 1, result);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
