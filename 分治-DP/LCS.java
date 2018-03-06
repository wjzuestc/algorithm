package com.lintcode.dp;

/**
 * @Description:给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。 子序列要求相对位置一致即可
 * @Author: Jingzeng Wang
 * @Date: Created in 9:28  2017/8/18.
 */
public class LCS {
    public static int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || A.length() <= 0 || B == null || B.length() <= 0) {
            return 0;
        }
        //定义问题状态  dp[i][j] 代表匹配到A的i位置，匹配到B的j位置
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        //状态转移：注意因为dp[0][0]的第一行和第一列是初始化的A和B分别没元素的情况，所以要注意写法与公式下标的不同
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ABCD", "EACB"));
    }
}
