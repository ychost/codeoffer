package com.ychost.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ychost
 * @date 2018/8/20
 */
public class Q209MinimumSizeSubSum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] sums = new int[nums.length];
        int cnt=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int pre = i==0?0:sums[i-1];
            sums[i] = pre + nums[i];
            if(sums[i]>=s){
                cnt = Math.min(cnt,i+1);
            }
        }
        for (int i = 0; i < sums.length-1; i++) {
            int target = sums[i]+s;
            int idx = binSearch(sums,i+1,sums.length-1,target);
            if(idx>=0 && idx<sums.length){
               cnt = Math.min(cnt,idx-i);
            }
        }
        return cnt == Integer.MAX_VALUE ? 0 : cnt;
    }

    int binSearch(int[] array,int low,int high,int target){
        int end = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid]>target){
                high -=1;
            }else{
                low+=1;
            }
        }
        if(low<=end && array[low]>target){
            return low;
        }
       return low+1;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int cnt = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0,j=0; i < nums.length; i++) {
           sum += nums[i];
           while(sum-nums[j]>=s){
               sum-=nums[j];
               j+=1;
           }
           if(sum>=s){
               cnt = Math.min(cnt,i-j+1);
           }
        }
       return cnt == Integer.MAX_VALUE ? 0 : cnt;
    }
}
