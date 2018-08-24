package com.ychost.codeoffer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/7
 */
public class Q10FibonacciTest {

    @Test
    public void fibonacci() {
        Assert.assertEquals(new Q10Fibonacci().Fibonacci(6),8);
    }

    @Test
    public void frogStep() {
        Assert.assertEquals(new Q10Fibonacci().frogStep(5),8);
    }
}