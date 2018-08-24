package com.ychost.leetcode.medium;

/**
 * @author ychost
 * @date 2018/7/22
 */
public class Q162FindPeekElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length ==0 ){
            return -1;
        }
        int left = 0,right = nums.length-1;
        while (left < right){
            int mid = left + (right - left) /2;
            if(nums[mid] < nums[mid +1]) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}
