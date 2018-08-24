package com.ychost.codeoffer;

/**
 * 剑指Offer 面试题 10，斐波那契数列
 * @author ychost
 * @date 2018/7/7
 */
public class Q10Fibonacci {

    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        int[] dp = new int[]{0,1};
        for(int i=2;i<=n;i++){
           int val = dp[0]+dp[1];
           dp[0] = dp[1];
           dp[1] = val;
        }
        return dp[1];
    }

    /**
     * 青蛙跳台阶问题
     * @param n
     * @return
     */
    public int frogStep(int n){
        if(n <=0 ){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
           dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
