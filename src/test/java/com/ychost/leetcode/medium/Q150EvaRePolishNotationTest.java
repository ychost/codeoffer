package com.ychost.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Q150EvaRePolishNotationTest {

    @Test
    public void evalRPN() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Q150EvaRePolishNotation().evalRPN(tokens));
    }
}