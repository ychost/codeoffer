package com.ychost.leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/8/22
 */
public class Q139WordBreakTest {

    @Test
    public void wordBreak() {
        List<String> dict = Arrays.asList( "cats","dog","sand","and","cat");
        System.out.println(new Q139WordBreak().wordBreak("catsandog",dict));
        String s = "abcv";
        System.out.println(s.substring(s.length()));

    }
}