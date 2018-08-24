package com.ychost.codeoffer;

/**
 * 剑指Offer 面试题 4 二维数组中的查找
 */
public class Q4FindIn2DimArray {
    boolean find(int target, int [][] array) {
        if(array == null || array.length ==0 || array[0].length == 0){
            return false;
        }
        int i = 0,j=array[0].length -1;
        while (i< array.length && j>=0){
            if(array[i][j] == target){
                return true;
            }else if(array[i][j] > target){
                j-=1;
            }else{
                i+=1;
            }
        }
        return false;
    }
}
