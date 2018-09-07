package com.ychost.leetcode.hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/9/5
 */
public class Q329LongestIncPathInMatrixTest {

    @Test
    public void longestIncreasingPath() {
        int[][] matrix = {{0},{1},{5},{5}};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(null);
        list.add(2);
        String s = Arrays.toString(list.toArray());
        s = s.substring(1,s.length()-2);
        System.out.println(s);
        String[] array = s.split(", ");

        System.out.println(new Q329LongestIncPathInMatrix().longestIncreasingPath(matrix));

    }
}