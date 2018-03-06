package com.lintcode.dp;

/**
 * @Description:给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？
 * @Author: Jingzeng Wang
 * @Date: Created in 21:28  2017/8/17.
 */
public class PackTwo {

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A  & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public static int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if (A == null || A.length <= 0 || V == null || V.length <= 0 || m <= 0) {
            return 0;
        }
        int[][] dp = new int[A.length][m + 1];
        //初始化
        for (int i = 0; i < A.length; i++) {
            dp[i][0] = 0;
        }
        //下边的初始化是将第0个坐标当做为第一个i了
        for (int i = 0; i < m + 1; i++) {
            if (i >= A[0]) {
                dp[0][i] = V[0];
            }
        }
        //状态转移
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i]] + V[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            //这样不对，这意味着[i]，[A[i]]之前数值还是保持的初始化的水平，也就是0  所以要加判断，才能完成整个状态转移矩形的构建
/*            for (int j = A[i]; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i]] + V[i]);
            }*/
        }
        return dp[A.length - 1][m];
    }

    public static void main(String[] args) {
        int[] c = {77, 22, 29, 50, 99};
        int[] v = {92, 22, 87, 46, 90};
        System.out.println(backPackII(100, c, v));
    }
}
