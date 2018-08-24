package com.ychost.codeoffer;

import java.util.ArrayList;

/**
 * 剑指Offer 面试题 40，最小的 K 个数
 * @author ychost
 * @date 2018/7/14
 */
public class Q40KthMinNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || input.length ==0 || input.length < k || k <= 0){
            return result;
        }
        size = input.length;
        array = input;
        init();
        for (int i = 0; i < k; i++) {
           result.add(poll());
        }
        return result;
    }
    int size = 0;
    int[] array = null;

    int poll(){
       int val = array[0];
       array[0] = array[size -1];
       --size;
       shiftdown(0);
       return val;
    }

    void init(){
        for(int i=(size-1)/2;i>=0;i--){
            shiftdown(i);
        }
    }

    void shiftdown(int i){
        int leftIndex = (2 * i) +1;
        int rightIndex = (2 * i)+ 2;
        if(leftIndex>= size){
            return;
        }
        int minIndex = leftIndex;
        if(rightIndex<size && array[leftIndex]>array[rightIndex]){
            minIndex = rightIndex;
        }
        if(array[i] > array[minIndex]){
            swap(array,i,minIndex);
            shiftdown(minIndex);
        }
    }

    void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
