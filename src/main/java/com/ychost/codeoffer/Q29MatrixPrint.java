package com.ychost.codeoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指Offer 面试题 29，顺时针打印矩阵
 * @author ychost
 * @date 2018/7/14
 */
public class Q29MatrixPrint {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if(matrix== null || matrix.length ==0 || matrix[0] == null ||matrix[0].length == 0){
            return result;
        }
        int i =0;
        while(i<=matrix.length/2 && i<= matrix[0].length /2){
            result.addAll(getOneLayer(matrix,i));
            if(result.size() == matrix.length * matrix[0].length){
                return result;
            }
            i++;
        }
        return result;
    }

    List<Integer> getOneLayer(int[][] matrix, int cell){
       List<Integer> layerList = new ArrayList<>();
        // top
        for(int i=cell;i<matrix[0].length - cell;i++){
            layerList.add(matrix[cell][i]);
        }
        // right
        for(int i=cell+1;i<matrix.length-cell;i++){
            layerList.add(matrix[i][matrix[0].length-cell-1]);
        }
        // bottom
        if(matrix.length-cell -1 != cell) {
            for (int i = matrix[0].length - cell - 2; i >= cell; i--) {
                layerList.add(matrix[matrix.length - cell - 1][i]);
            }
        }
        // left
        if(matrix[0].length-cell -1 != cell) {
            for (int i = matrix.length - cell - 2; i > cell; i--) {
                layerList.add(matrix[i][cell]);
            }
        }
       return layerList;
    }
}
