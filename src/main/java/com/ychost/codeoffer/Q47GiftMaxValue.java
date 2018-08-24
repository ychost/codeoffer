package com.ychost.codeoffer;

/**
 * 面试题 47，礼物的最大价值
 * @author ychost
 * @date 2018/7/21
 */
public class Q47GiftMaxValue {
    public int maxValue(int[][] matrix){
        if(matrix == null || matrix.length ==0 || matrix[0] == null ||matrix[0].length ==0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 初始值
                if(i ==0 && j == 0){
                    dp[i][j] = matrix[i][j];
                     // 第一行
                }else if(i==0){
                   dp[i][j] = dp[i][j-1];
                   // 第一列
                }else if(j ==0){
                   dp[i][j] = dp[i-1][j];
                   //普通情况取向下或者向右的最大值
                }else {
                    int down = dp[i-1][j] + matrix[i][j];
                    int right = dp[i][j-1] + matrix[i][j];
                    dp[i][j] = Math.max(down,right);
                }
            }
        }
        return dp[matrix.length -1][matrix[0].length -1];
    }
}
