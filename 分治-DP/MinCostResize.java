package com.lintcode.dp;

import java.util.ArrayList;

/**
 * @Description:给一个整数数组，调整每个数的大小，使得相邻的两个数的差不大于一个给定的整数target， 调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。
 * 你可以假设数组中每个整数都是正整数，且小于等于100。
 * @Author: Jingzeng Wang
 * @Date: Created in 22:22  2017/8/17.
 */
public class MinCostResize {
    /**
     * 定义状态---状态转移
     *
     * @param A:      An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() <= 0) {
            return 0;
        }
        //dp就是记录第i个数字，调整为j时的最小花费
        int[][] dp = new int[A.size()][101];
        //初始化  第一个调整到每个位置的代价
        for (int i = 0; i < 101; i++) {
            dp[0][i] = Math.abs(i - A.get(0));
        }
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < 101; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                //如果i 调整到j，则上一个数的范围
                int left = Math.max(j - target, 0);
                int right = Math.min(j + target, 100);
                int diff = Math.abs(j - A.get(i));
                for (int k = left; k <= right; k++) {
                    //转移方程，上一个数转移到k+加上这一个数装移到j 遍历k求最小的那个  上一个范围求最小
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + diff);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            if (dp[A.size() - 1][i] < min)
                min = dp[A.size() - 1][i];
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
