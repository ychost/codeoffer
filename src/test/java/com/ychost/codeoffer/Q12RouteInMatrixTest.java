package com.ychost.codeoffer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/7
 */
public class Q12RouteInMatrixTest {

    @Test
    public void hasPath() {
        String matrixStr = "ABCESFCSADEE";
        String path = "ABCCED";
        Assert.assertTrue(new Q12RouteInMatrix().hasPath(matrixStr.toCharArray(),3,4,path.toCharArray()));
    }
}