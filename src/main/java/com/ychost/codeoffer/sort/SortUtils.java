package com.ychost.codeoffer.sort;

/**
 * @author ychost
 * @date 2018/7/14
 */
public class SortUtils {
    public static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
