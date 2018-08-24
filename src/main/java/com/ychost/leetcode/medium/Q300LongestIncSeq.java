package com.ychost.leetcode.medium;

/**
 * @author ychost
 * @date 2018/8/20
 */
public class Q300LongestIncSeq {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int[] array = new int[nums.length];
        array[0]=nums[0];
        int len = 1;
        for (int num : nums) {
            if (num > array[len - 1]) {
                array[len] = num;
                len += 1;
            } else {
                // 找到第一个 >= nums[i] 的索引
                int idx = binSearch(array, 0, len - 1, num);
                if (idx >= 0 && idx < len) {
                    array[idx] = num;
                }
            }
        }
        return 0;
    }

    int binSearch(int[] array,int low,int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid]>target){
                high-=1;
            }else{
                low+=1;
            }
        }
        if(array[low]>target){
            return low;
        }else{
            return low+1;
        }

    }
}
