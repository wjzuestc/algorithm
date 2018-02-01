package com.blog.sort;

import java.util.Arrays;

/**
 * @Description: 计数排序  它与桶排序、基数排序都是线性排序  是不基于比较的排序方法   时间复杂度是线性的
 * 其实是利用 hash原理，以空间换时间    还有限制 ：就是排序数组的最大值为k
 * 基本思想：计数排序要求数据的范围在0到k之间的整数，引入了一个辅助数组countArray，数组countArray的大小为k，存储了待排序数组中值小于等于countArray的索引值的个数。
 * 1. 统计出待排序数组值为i的元素个数，存入辅助数组countArray的第i项中
 * 2. 对countArray中的数据进行累加，每一项的值等于本项值加上前一项的值
 * 3. 扫描待排序数组，每扫描一项m，将其存入新的数组的第countArray(m)项，对countArray(m)的值减一
 * @Author: Jingzeng Wang
 * @Date: Created in 22:17  2017/8/26.
 */
public class CountSort {

    public static int[] countSort(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return null;
        }
        int[] countArray = new int[k + 1];  //辅助数组  以待排序数组值作为数组索引
        int[] array = new int[nums.length]; //排好序的数组
        //统计每个元素的出现的次数
        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i]]++;
        }
        //countArray  存储小于等于index的值的个数
        for (int i = 1; i <= k; i++) {
            countArray[i] += countArray[i - 1];
        }
        //扫描待排序的数组，将值放入array中
        for (int i = 0; i < nums.length; i++) {
            array[countArray[nums[i]] - 1] = nums[i];
            countArray[nums[i]]--;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {11, 12, 3, 8, 5, 1, 2, 3, 18};
        System.out.println(Arrays.toString(countSort(array, 18)));
    }
}
