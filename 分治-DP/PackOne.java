package com.lintcode.dp;

/**
 * @Description:在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 * @Author: Jingzeng Wang
 * @Date: Created in 20:57  2017/8/17.
 */
public class PackOne {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public static int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length <= 0) {
            return m;
        }
        //初始化 他会默认初始化为0   dp表示从[i][v] 前i种物品在容量为v的情况下的最大填充
        int[][] dp = new int[A.length][m + 1];
        for (int i = 0; i < A.length; i++) {
            dp[i][0] = 0;   //初始化，在容量为0 的情况下，所填充的最大值
        }
        //初始化有第一种物品时  这样就可以使A[0]表示为有第一种物品
        for (int i = 0; i <= m; i++) {
            if (i >= A[0]) {
                dp[0][i] = A[0];
            }
        }
        //状态转移 实际上是从第二种开始的
        for (int i = 1; i < A.length; i++) {
            for (int c = 1; c <= m; c++) {
                if (c >= A[i]) {
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - A[i]] + A[i]);
                } else {
                    //如果小于它的容量就只能选择和上次一样
                    dp[i][c] = dp[i - 1][c];
                }
            }
/*            for (int c = 0; c <= m; c++) {
                dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - A[i]] + A[i]);
            }*/
        }
        return dp[A.length - 1][m];
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 8, 5};
        System.out.println(backPack(10, a));
    }
}
