package com.ychost.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q322CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null ||  coins.length == 0){
            return -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if(coins[i] <= j){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
           }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }


    int result = Integer.MAX_VALUE;
    void find(int[] array,List<Integer> values,int index,int res){
        if(res == 0){
            result = Math.min(values.size(),result);
        }else if(res > 0){
            for(int i=index;i<array.length;i++){
                values.add(array[i]);
                find(array,values,index,res-array[i]);
                values.remove(values.size() -1);
            }
        }
    }
}
