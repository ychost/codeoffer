package com.ychost.netease;

import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/8/11
 */
public class Q1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        String[] line3 = scanner.nextLine().split(" ");
        int n =Integer.parseInt(line1[0]),k = Integer.parseInt(line1[1]);
        int[] score = new int[n];
        boolean[] isAwake = new boolean[n];
        for(int i=0;i<n;i++){
            score[i] = Integer.parseInt(line2[i]);
        }
        for(int i=0;i<n;i++){
            if(Integer.parseInt(line3[i]) == 1){
                isAwake[i] = true;
            }
        }
        System.out.println(getMaxScore(score,isAwake,k));
    }

    static  int getMaxScore(int[] score,boolean[] isAwake,int k){
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            if(isAwake[i]){
                sum += score[i];
            }
        }
        int maxSum = sum;
        for(int i=0;i<score.length;i++){
            if(!isAwake[i]){
                int subSum = getSubSum(score, isAwake, i, k);
                maxSum = Math.max(maxSum, subSum + sum);
            }
        }
        return maxSum;
    }

    static int getSubSum(int[] array,boolean[] isAwake,int start,int count){
        int sum = 0;
        for(int i=start;i<start+count;i++){
            if(i>=array.length){
                break;
            }
            if(!isAwake[i]) {
                sum += array[i];
            }
        }
        return sum;
    }
}
