package com.ychost.leetcode.medium;

import java.util.Arrays;

public class Q324WiggleSortII {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        Arrays.sort(nums);
        int j = nums.length,k=(nums.length+1)/2;
        int[] wiggle = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            wiggle[i] = (i & 1) == 1 ? nums[--j] :nums[--k];
        }
        System.arraycopy(wiggle,0,nums,0,nums.length);
    }

    void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
