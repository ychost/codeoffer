package com.ychost.codeoffer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q3FindRepeatInArrayTest {

    @Test
    public void duplicate() {
        int[] array = new int[]{0,1,3,3,2};
        int[] dup = new int[1];
        Assert.assertTrue(new Q3FindRepeatInArray().duplicate(array, array.length, dup));
        Assert.assertEquals(dup[0],3);
    }

    @Test
    public void duplicate2() {
        int[] array = new int[]{1,2,3,4,5,6,7};
        int[] dup = new int[1];
        Assert.assertTrue(!new Q3FindRepeatInArray().duplicate2(array,array.length,dup));
        Assert.assertEquals(dup[0],0);
    }
}