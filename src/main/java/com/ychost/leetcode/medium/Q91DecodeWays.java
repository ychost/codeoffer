package com.ychost.leetcode.medium;

public class Q91DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i=1;i<=s.length();i++){
            int cur = (s.charAt(i-1) - '0');
            if(i == 1){
                if(cur>=1 && cur<=26) {
                    dp[i] = 1;
                }else{
                    break;
                }
            }else if(i>=2){
                int pre = (s.charAt(i-2) - '0');
               int v = pre * 10 + cur;
               if(v >=1 && v<= 26 && cur !=0 && pre !=0){
                   dp[i] = dp[i-1] + dp[i-2];
               }else if(cur == 0 && v >=1 && v<=26){
                   dp[i] = dp[i-2];
               }else if(cur !=0){
                   dp[i] = dp[i-1];
               }else{
                   break;
               }
            }
        }
        return dp[s.length()];
    }
}
