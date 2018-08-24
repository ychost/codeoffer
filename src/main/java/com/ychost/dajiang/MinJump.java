package com.ychost.dajiang;

/**
 * @author ychost
 * @date 2018/7/8
 */
public class MinJump {
    int getMinStep(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int[] dp = new int[array.length];
        dp[1] = 1;
        for (int i = 2; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
               if(array[j] >= (i-j)){
                   min = Math.min(dp[j]+1,min);
               }
            }
            dp[i] = min;
        }
        return dp[array.length-1];
    }
}
