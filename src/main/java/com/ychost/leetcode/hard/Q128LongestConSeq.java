package com.ychost.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ychost
 * @date 2018/9/4
 */
public class Q128LongestConSeq {
    public int longestConsecutive(int[] nums) {
       Map<Integer,Integer> map = new HashMap<>();
       int res = 0;
        for (int num : nums) {
            if(map.containsKey(num)){
                continue;
            }
            int ls = map.getOrDefault(num-1,0);
            int rs = map.getOrDefault(num+1,0);
            int len = ls + rs + 1;
            map.put(num,len);
            res = Math.max(res,len);
            map.put(num-ls,len);
            map.put(num+rs,len);
        }

       return res;
    }
}
