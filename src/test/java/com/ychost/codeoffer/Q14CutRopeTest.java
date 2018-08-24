package com.ychost.codeoffer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/8
 */
public class Q14CutRopeTest {

    @Test
    public void cutRope() {
        Assert.assertEquals(18,new Q14CutRope().cutRope(8));
    }
}