package com.ychost.codeoffer;

/**
 * 剑指Offer 面试题 14，剪绳子
 * @author ychost
 * @date 2018/7/8
 */
public class Q14CutRope {
    int cutRope(int n){
       if(n < 2){
           return 0;
       }else if(n == 3){
          return 2;
       }else if(n == 2){
           return 1;
       }
       int[] dp = new int[n+1];
        for (int i = 0; i <= 3; i++) {
            dp[i] = i;
        }
       for (int i = 4; i <= n; i++) {
           int max = 0;
           for (int j = 1; j <= i/2; j++) {
               max = Math.max(dp[j] * dp[i-j],max);
           }
           dp[i] = max;
       }
       return dp[n];
    }
}
