package com.ychost.codeoffer;

/**
 * 剑指Offer 面试题 39，数组中出现次数超过一半的数字
 * @author ychost
 * @date 2018/7/14
 */
public class Q39MoreHalfArray {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null ||array.length == 0){
            return 0;
        }
        int result = array[0],times = 1;
        for (int i = 1; i < array.length; i++) {
            if(times ==0){
                result = array[i];
            }
           if(array[i] == result){
               ++times;
           }else{
               --times;
           }
        }
        if(checkIsMoreHalf(result,array)){
            return result;
        }
        return 0;
    }

    boolean checkIsMoreHalf(int val,int[] array){
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == val){
                ++times;
            }
        }
        return times * 2 > array.length;
    }
}
