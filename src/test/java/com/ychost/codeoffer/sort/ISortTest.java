package com.ychost.codeoffer.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ychost
 * @date 2018/7/14
 */
public class ISortTest {
    Map<ISort,int[]> map ;

    @Before
    public void initMap(){
       map  = new HashMap<>();
       map.put(new HeapSort(),getArray());
    }

    @Test
    public void sort() {
        map.forEach(ISort::sort);
        map.forEach((k,array)->{
            for (int i = 0; i < array.length-1; i++) {
                Assert.assertTrue(array[i]<=array[i+1]);
            }
        });
    }

    private int[] getArray(){
        return new int[]{1,5,4,7,4,1,2,5,-8,5,4,7,100,2,5,4,7,-0,0,25,47,4,1,-8};
    }
}