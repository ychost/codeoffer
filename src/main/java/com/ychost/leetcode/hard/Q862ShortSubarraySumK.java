package com.ychost.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ychost
 * @date 2018/8/21
 */
public class Q862ShortSubarraySumK {
    public int shortestSubarray(int[] A, int K)  {
        if(A == null || A.length ==0){
            return -1;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] sums = new int[A.length+1];
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            sums[i+1] = sums[i]+A[i];
        }
        for (int i = 0; i <= A.length; i++) {
            while(!deque.isEmpty() && sums[i]-sums[deque.getFirst()]>=K){
               cnt = Math.min(cnt,i-deque.pollFirst());
            }
            while (!deque.isEmpty() && sums[i] < sums[deque.getLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return cnt == Integer.MAX_VALUE? -1 : cnt;
    }
}
