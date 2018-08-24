package com.ychost.codeoffer.sort;

/**
 * @author ychost
 * @date 2018/7/14
 */
public abstract class AbstractSort implements ISort {

    long startTime;
    protected boolean beforeSort(int[] array){
        startTime = System.currentTimeMillis();
        if(array == null ||  array.length == 0){
            return false;
        }
        return true;
    }

    @Override
    public void sort(int[] array){
       if(!beforeSort(array)){
           return;
       }
       sortCall(array);
       afterSort(array);
    }

    /**
     * 排序算法本体
     * @param array
     */
    protected abstract void sortCall(int[] array);

    protected void afterSort(int[] array){
        long execTime = System.currentTimeMillis() - startTime;
        System.out.println("----"+getClass().getName()+"----- exec time: "+ execTime +" ms");
    }
}
