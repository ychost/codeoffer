package com.ychost.leetcode.medium;

/**
 * @author ychost
 * @date 2018/8/21
 */
public class Q718MaxRepeatSubArray {
    public int findLength(int[] A, int[] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0){
            return 0;
        }
        int[][] dp = new int[A.length+1][B.length+1];
        int maxLen = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(dp[i][j], maxLen);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return maxLen;
    }
}
