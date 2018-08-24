package com.ychost.leetcode.medium;

/**
 * @author ychost
 * @date 2018/8/20
 */
public class Q344IncreasingTripletSubseq {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length<3){
            return false;
        }
        int[] array = new int[nums.length];
        int len = 1;
        array[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>array[len-1]){
                array[len] = nums[i];
                len+=1;
                if(len == 3){
                    return true;
                }
            }else{
                for(int j=0;j<len;j++){
                    if(array[j] == nums[i]){
                        break;
                    }
                    if(array[j]>nums[i]){
                        array[j]=nums[i];
                        break;
                    }
                }
            }
        }
        return false;
    }

    int binSearch(int[] array,int target,int start,int end){
       int low = start;
       int high=end-1;
       while(low<= high){
           int mid = low+(high-low)/2;
           if(array[mid]==target){
               return mid;
           }else if(array[mid]>target){
               high=mid-1;
           }else{
               low=mid+1;
           }
       }
       if(array[low]<target){
          return low;
       }
       return low+1;
    }
}
