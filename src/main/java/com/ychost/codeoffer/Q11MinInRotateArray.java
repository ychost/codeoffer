package com.ychost.codeoffer;

/**
 * 剑指Offer
 * @author ychost
 * @date 2018/7/7
 */
public class Q11MinInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            return -1;
        }
        int start = 0,end = array.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(start == end - 1){
                return Math.min(array[start],array[end]);
            }else if(equals(array[start],array[end],array[mid])){
               int min = array[0];
                for (int i = 1; i < array.length; i++) {
                   min = Math.min(array[i],min);
                }
                return min;
            }
            else if(array[mid] >= array[start]){
                start = mid;
            }else if(array[mid] <= array[end]){
                end = mid ;
            }
        }
        return -1;
    }

    boolean equals(int... a){
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] != a[i+1]){
                return false;
            }
        }
        return true;
    }
}
