package com.ychost.leetcode.medium;

/**
 * @author ychost
 * @date 2018/8/22
 */
public class Q395LongSubStrWithKRepeatCh {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(),0,s.length(),k);
    }

    int helper(char[] chs,int start,int end,int k){
       if(end-start<k){
           return 0;
       }
       int[] count=new int[26];
       for(int i=start;i<end;i++){
           count[chs[i]-'a']+=1;
       }
       for(int i=0;i<26;i++){
           if(count[i]>0 && count[i]<k){
               for(int j=start;j<end;j++){
                   if(chs[j] == i+'a') {
                       int left = helper(chs, start, j, k);
                       int right = helper(chs, j + 1, end, k);
                       return Math.max(left, right);
                   }
               }
           }
       }
       return end-start;
    }
}
