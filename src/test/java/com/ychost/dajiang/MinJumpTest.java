package com.ychost.dajiang;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/8
 */
public class MinJumpTest {

    @Test
    public void getMinStep() {
        int[] array = new int[]{2,3,1,1,4};
        System.out.println(new MinJump().getMinStep(array));
    }
}