package com.ychost.codeoffer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/7
 */
public class Q11MinInRotateArrayTest {

    @Test
    public void minNumberInRotateArray() {
        int[] array = new int[]{1,0,1,1,1,1,1};
        Assert.assertEquals(new Q11MinInRotateArray().minNumberInRotateArray(array),0);
    }
}