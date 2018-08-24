package com.ychost.codeoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/14
 */
public class Q40KthMinNumberTest {

    @Test
    public void getLeastNumbers_Solution() {
        int[] array = new int[]{4,2,3,1,5,4,7,8,5,4,9};
        ArrayList<Integer> result = new Q40KthMinNumber().GetLeastNumbers_Solution(array,4);
        System.out.println(Arrays.toString(result.toArray()));
    }
}