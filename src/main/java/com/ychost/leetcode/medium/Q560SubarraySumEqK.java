package com.ychost.leetcode.medium;

import java.util.*;

/**
 * @author ychost
 * @date 2018/8/20
 */
public class Q560SubarraySumEqK {

    public int subarraySum2(int[] nums, int k) {
        int[] sum = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i>0) {
                sum[i] = sum[i - 1] + nums[i];
            }else{
                sum[i] = nums[i];
            }
            int key = nums[i]-k;
            if(map.containsKey(key)){
               cnt+=map.get(key);
            }
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        return cnt;
    }
    public int subarraySum(int[] nums, int k) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        Map<Integer,List<Integer>> map = new HashMap<>();
        map.put(sum[0],new ArrayList<Integer>(){{add(0);}});
        for (int i = 1; i < nums.length; i++) {
            sum[i]= sum[i-1]+nums[i];
            if(!map.containsKey(sum[i])){
               map.put(sum[i],new ArrayList<>());
            }
            map.get(sum[i]).add(i);
        }
        int cnt = 0;
        for (int i = 0; i < sum.length; i++) {
            int key = sum[i]-k;
            if(key == 0){
                cnt+=1;
            }
            if(map.containsKey(key)){
                for(Integer idx : map.get(key)){
                    if(idx>i){
                      cnt+=1;
                    }
                }
            }
        }

        return cnt;
    }
}
