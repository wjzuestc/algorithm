package com.blog.sort;

import java.util.Arrays;

/**
 * @Description: 冒泡排序 O(n^2)  可通过改进将最优的时间复杂度变为：O(n)
 * 稳定的排序算法  排序的稳定性指的是是否具备原序列中相等的元素排序后相对位置不变的性质
 * 判断稳定可以在脑海中过一遍算法流程
 * @Author: Jingzeng Wang
 * @Date: Created in 9:25  2017/8/26.
 */
public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        /**
         * 第一层for：代表比较趟数，趟数为num.length-1
         * 第二层for：代表每趟需要比较的数：每次只需比较num.length - i 次
         * 冒泡排序的原理就是通过若干趟比较，每一次把最大的沉入到最下边
         * 可改进1：设置标志位，明显如果有一趟没有发生交换（flag = false)，说明排序已经完成
         *          此改进可以将冒泡排序的最佳时间变为：O(n)
         */
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] array = {8, 5, 6, 9, 1, 2, 3, 11};
        bubbleSort(array);
    }

}
