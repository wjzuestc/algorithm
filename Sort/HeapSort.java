package com.blog.sort;

import java.util.Arrays;

/**
 * @Description: 堆排序  时间复杂度O(nlogn)   利用最大堆实现升序排序
 * 其原理是利用最大最小堆这种数据结构实现，其堆顶是序列的最大(最小值)
 * 堆是一种完全二叉树   一般用数组来实现。   存储是按照层次存储的
 * @Author: Jingzeng Wang
 * @Date: Created in 21:04  2017/8/26.
 */
public class HeapSort {
    private int[] nums;

    public HeapSort(int[] nums) {
        this.nums = nums;
    }

    public void maxHeapSort() {
        //先建立最大对
        buildMaxHeap();
        System.out.println(Arrays.toString(nums));
        //排序 将堆顶元素放到最后一个,把最后一个放在根节点，然后再从根节点开始调整
        //此过程与选择排序类似
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            maxHeapFixDown(nums, 0, i);
        }
    }

    /**
     * 初始化时建立最大堆
     * 把叶节点当做是已经符合最大堆特点了。所以建立最大堆时从最后一个非叶子节点开始调整
     */
    public void buildMaxHeap() {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapFixDown(nums, i, nums.length);
        }
    }

    /**
     * 从index处调整，使之符合最大堆的性质
     * 此调整相是适用于删除操作时的，删除操作时发生在堆顶，然后用最后一个节点替换到堆顶然后进行调整
     * 插入操作与此相反，插入是首先插入到数组最后，然后向上调整
     *
     * @param nums   要调整的数组
     * @param i      开始调整的索引
     * @param length 要调整的数组长度
     */
    public void maxHeapFixDown(int[] nums, int i, int length) {
        int leftChild = 2 * i + 1;
        int index = leftChild;
        while (index <= length - 1) {
            int rightChild = 2 * i + 2;
            //找到那个最大的那个数的索引
            if (rightChild <= length - 1 && nums[leftChild] < nums[rightChild]) {
                index = rightChild;
            }
            //如果根节点大于子节点，则调整结束
            if (nums[i] > nums[index]) {
                break;
            }
            // 不等于 则交换子节点和根节点
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;

            i = index;
            leftChild = 2 * i + 1;
            index = leftChild;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 12, 13, 8, 5, 1, 2, 4, 15, 3, 45};
        HeapSort heapSort = new HeapSort(array);
        heapSort.maxHeapSort();
        System.out.println(Arrays.toString(heapSort.nums));
    }
}
