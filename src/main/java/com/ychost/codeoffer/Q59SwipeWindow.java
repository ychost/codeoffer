package com.ychost.codeoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 剑指Offer 面试题 29，队列的最大值
 * @author ychost
 * @date 2018/7/21
 */
public class Q59SwipeWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(num == null || num.length < size || size <=0){
            return result;
        }
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
             while(!deque.isEmpty() && num[deque.getLast()] <= num[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i >= size -1){
               while(!deque.isEmpty() && (i - deque.getFirst()) > size -1 ){
                   deque.removeFirst();
               }
               int index= deque.getFirst();
               result.add(num[index]);
            }

        }
        return result;
    }
}
