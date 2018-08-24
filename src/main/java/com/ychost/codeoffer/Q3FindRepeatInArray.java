package com.ychost.codeoffer;

/**
 * 剑指Offer 面试题3 数组中重复的数字
 */
public class Q3FindRepeatInArray {

    /**
     * 该方法修改了数组的元素，但是数组中可以不存在重复元素
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length < length || numbers.length == 0 || length <= 0) {
            return false;
        }
        boolean contains0= false;
        for (int i = 0; i < length; i++) {
            int v1 = Math.abs(numbers[i]);
            int v2 = numbers[v1];
            if(v2 < 0){
                duplication[0] = v1;
               return true;
            }else if(v2 == 0){
                if(contains0){
                    duplication[0] = 0;
                    return true;
                }
                contains0 = true;
            }
            numbers[v1] = -numbers[v1];
        }
        return false;
    }

    /**
     * 该方法不修改数组元素
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length > length || numbers.length ==0 || length <=0){
            return false;
        }
        int start = 1;
        int end = length-1;
        while(start <= end){
            int mid = start + (end - start) /2;
            int count = countRage(numbers,length,start,mid);
            if(count > (mid - start +1)){
                if(start == end){
                    duplication[0] = start;
                    return true;
                }
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return false;
    }

    int countRage(int[] numbers,int length,int start,int end){
       int count = 0;
       for(int i=0;i<length;i++){
           if(numbers[i] >= start && numbers[i] <= end){
              count +=1;
           }
       }
       return count;
    }


}
