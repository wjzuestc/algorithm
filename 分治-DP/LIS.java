package com.lintcode.dp;

/**
 * @Description:最长上升子序列  这可以不连续  用dp解决。  最长上升连续子序列 这可以直接for循环解决即可  时间复杂度O(n)
 * @Author: Jingzeng Wang
 * @Date: Created in 11:28  2017/8/18.
 */
public class LIS {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        //定义问题状态  ： 一维dp[i] 前i个的最长上升子序列
        int[] dp = new int[nums.length];
        //初始化 为1  因为最少也可以是其本身  Arrays.fill()....
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        //一维dp的状态转移的写法理解，，，结合背包问题空间优化的写法  //todo
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        //注意返回的是dp最大的
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        return max;
    }
}
