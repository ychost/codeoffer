package com.ychost.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q324WiggleSortIITest {

    @Test
    public void wiggleSort() {
        int[] nums = {1,5,1,1,6,4};
        new Q324WiggleSortII().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}