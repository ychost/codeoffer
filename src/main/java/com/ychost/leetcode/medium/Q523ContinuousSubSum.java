package com.ychost.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ychost
 * @date 2018/8/20
 */
public class Q523ContinuousSubSum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int[] sums = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        // 1. 当 sums[i] % k == 0 的时候 sums[i] 即为所求
        // 2. 当 k == 0 的时候，sums[i] == 0 即为所求
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            int pre = i ==0 ? 0 : sums[i-1];
            sums[i] = pre + nums[i];
            int key = -sums[i];
            if(k!=0) {
                sums[i] %= k;
                key = sums[i];
            }
            if(map.containsKey(key)){
                // 题目要求序列个数至少为 2
               if(i-map.get(sums[i])>1){
                   return true;
               }
            }else{
                // 只保留最小索引
                map.put(sums[i],i);
            }
        }
        return false;
    }
}
