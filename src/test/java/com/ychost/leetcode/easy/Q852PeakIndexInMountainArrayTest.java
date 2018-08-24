package com.ychost.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/22
 */
public class Q852PeakIndexInMountainArrayTest {

    @Test
    public void peakIndexInMountainArray() {
        int[] A = {1,2,1};
        int peek = new Q852PeakIndexInMountainArray().peakIndexInMountainArray(A);
        System.out.println(peek);
    }
}