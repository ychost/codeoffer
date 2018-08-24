package com.ychost.leetcode.easy;

/**
 * @author ychost
 * @date 2018/7/22
 */
public class Q852PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        if(A == null || A.length < 3){
            return -1;
        }
        int l=0,r=A.length -1;
        while(l<r){
            int mid = l +(r-l)/2;
            if(A[mid] > A[mid -1] && A[mid] > A[mid + 1]){
                return mid;
            }else if(A[mid] <= A[mid -1]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
