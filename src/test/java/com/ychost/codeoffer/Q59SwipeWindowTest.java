package com.ychost.codeoffer;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/21
 */
public class Q59SwipeWindowTest {

    @Test
    public void maxInWindows() {
        int[] array = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer>  result = new Q59SwipeWindow().maxInWindows(array,3);
        for (Integer val : result) {
            System.out.print(val +",");
        }
    }
}