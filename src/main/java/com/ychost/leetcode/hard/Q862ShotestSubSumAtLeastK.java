package com.ychost.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ychost
 * @date 2018/8/4
 */
public class Q862ShotestSubSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] B = new int[A.length +1];
        for (int i = 0; i < A.length; i++) {
            B[i+1] = A[i]+B[i];
        }
        Integer res = null;
        for (int i = 0; i <= A.length; i++) {
            while(!deque.isEmpty() && B[i] - B[deque.getFirst()]>=K){
               if(res == null){
                   res =i- deque.pollFirst() ;
               }else{
                   res = Math.min(res,i-deque.pollFirst());
               }
            }
            while(!deque.isEmpty() && B[i] <= B[deque.getLast()]){
                deque.pollLast();
            }

            deque.addLast(i);
        }
        return res == null ? -1 : res;
    }
}
