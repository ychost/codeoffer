package com.ychost.learn;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorITest {

    @Test
    public void calc() {
        String expr = "3+5 / 2";
        System.out.println(new CalculatorI().calc(expr));
    }
}