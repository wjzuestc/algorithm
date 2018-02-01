package com.blog.sort;

import java.util.Arrays;

/**
 * @Description: 希尔排序  其时间复杂度最坏情况下是O(n^2)  其时间复杂度与步长的选择有关  这也是关于希尔排序的优化点
 * 插入排序一种改进方法  希尔排序的实质就是分组插入排序  缩小增量排序
 * 插入排序在对几乎已经排好序的数据操作时， 效率高， 即可以达到线性排序的效率   插入排序一般来说是低效的， 因为插入排序每次只能将数据移动一位
 * 它的基本思想是：对于n个待排序的数列，取一个小于n的整数gap(gap被称为步长)将待排序元素分成若干个组子序列，所有距离为gap的倍数的记录放在同一个组中；
 * 然后，对各组内的元素进行直接插入排序。 这一趟排序完成之后，每一个组的元素都是有序的。然后减小gap的值，并重复执行上述的分组和排序。
 * 重复这样的操作，当gap=1时，整个数列就是有序的。
 * @Author: Jingzeng Wang
 * @Date: Created in 11:35  2017/8/26.
 */
public class ShellSort {
    /**
     * 希尔排序代码可以简单写出：
     * 第一个for: 来确定步长，直到步长为1 结束算法
     * 第二个for: 是对每一个分组进行插入排序
     * 第三个和第四个for就是对每个组的插入排序算法
     *
     * @param nums
     */
    public static void shellSort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        //步长大小选择   gap也就是有几个组  当gap=1时结束
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            //对每一个组都进行插入排序
            for (int group = 0; group < gap; group++) {
                //每一组的插入排序
                for (int j = group; j < nums.length; j += gap) {
                    for (int k = j; k > group && nums[k] < nums[k - gap]; k -= gap) {
                        int temp = nums[k];
                        nums[k] = nums[k - gap];
                        nums[k - gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] array = {11, 12, 3, 8, 5, 1, 2, 3, 2};
        shellSort(array);
    }
}
