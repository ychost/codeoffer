package com.ychost.codeoffer;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/15
 */
public class Q41StreamMedianTest {

    @Test
    public void insert() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((s,v)->v-s);
        priorityQueue.offer(1);
        priorityQueue.offer(3);
        priorityQueue.offer(2);
        priorityQueue.offer(4);
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}