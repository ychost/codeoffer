package com.ychost.leetcode.hard;

import java.util.*;

/**
 * @author ychost
 * @date 2018/7/22
 */
public class Q354MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0){
           return 0;
        }
        List<int[]> envList = new ArrayList<>(Arrays.asList(envelopes));
        envList.sort((a,b)->{
            if(a[0] > b[0]){
                return 1;
            }else if(a[0] < b[0]){
                return -1;
            }else {
                return a[1] - b[1];
            }
        });
        int res = Integer.MIN_VALUE;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envList.size(); i++) {
            for (int j = 0; j < i; j++) {
               if(envList.get(i)[0] > envList.get(j)[0] && envList.get(i)[1] > envList.get(j)[1]){
                   dp[i] = Math.max(dp[i],dp[j] +1);
               }
            }
            res  = Math.max(dp[i],res);
        }
        return res+1;
    }
}

