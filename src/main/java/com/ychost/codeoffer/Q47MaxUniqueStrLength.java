package com.ychost.codeoffer;

import java.util.Arrays;

/**
 * 剑指Offer 面试题 48，最长不含重复字符串的子字符串
 * @author ychost
 * @date 2018/7/21
 */
public class Q47MaxUniqueStrLength {
    public int getMaxLen(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int[] dp = new int[str.length()];
        int[] pos = new int[26];
        Arrays.fill(pos,-1);
        dp[0] =1;
        pos[str.charAt(0) - 'a'] = 0;
        for(int i=1;i<str.length();i++){
            int prePos = pos[str.charAt(i) - 'a'];
            if(prePos < 0 || (i - prePos) >= dp[i-1]){
                dp[i] = dp[i-1] +1;
            }else{
                dp[i] = i-prePos;
            }
            pos[str.charAt(i) - 'a'] = i;
        }
        return dp[str.length() -1];
    }

}
