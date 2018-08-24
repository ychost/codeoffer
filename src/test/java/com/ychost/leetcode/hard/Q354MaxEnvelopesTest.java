package com.ychost.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/22
 */
public class Q354MaxEnvelopesTest {

    @Test
    public void maxEnvelopes() {
        int[][] array = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        int result = new Q354MaxEnvelopes().maxEnvelopes(array);
        System.out.println(result);
    }
}