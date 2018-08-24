package com.ychost.codeoffer;

import org.junit.Test;

import static org.junit.Assert.*;

/*
 *
 *@author ychost.yc
 *@date   2018/7/7
 */public class Q5ReplaceSpaceTest {

    @Test
    public void replaceSpace() {
        StringBuffer stringBuffer = new StringBuffer("hello world in java ");
        System.out.println(new Q5ReplaceSpace().replaceSpace(stringBuffer));
    }

}