package com.ychost.leetcode;

import com.ychost.leetcode.medium.Q162FindPeekElement;
import org.junit.Test;

/**
 * @author ychost
 * @date 2018/7/22
 */
public class Q162FindPeekElementTest {

    @Test
    public void findPeakElement() {
        int result = new Q162FindPeekElement().findPeakElement(new int[]{1,2,1,3,5,6,4});
        System.out.println(result);
    }
}