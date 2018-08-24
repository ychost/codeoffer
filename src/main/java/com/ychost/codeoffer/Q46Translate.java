package com.ychost.codeoffer;

/**
 * 剑指offer 面试题 46，把数字翻译成字符串
 * @author ychost
 * @date 2018/7/21
 */
public class Q46Translate {
    public int countTranslate(int num){
        if(num < 0){
            return -1;
        }
        String str = String.valueOf(num);
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for(int i=1;i<str.length();i++){
           String val = str.charAt(i-1) +""+str.charAt(i);
           if(i> 1 && Integer.valueOf(val) <= 'z'){
              dp[i] = Math.max(dp[i-1]+1,dp[i-2]+2);
           }else{
               dp[i] = dp[i-1] + 1;
           }
        }
        return dp[str.length() -1];
    }
}
