package com.ychost.codeoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/14
 */
public class Q29MatrixPrintTest {

    @Test
    public void printMatrix() {
        int[][] matrix ={{1},{2},{3},{4},{5}};
        ArrayList<Integer> result = new Q29MatrixPrint().printMatrix(matrix);
        System.out.println(Arrays.toString(result.toArray()));
    }
}