package com.ychost.codeoffer;

import java.util.Stack;

/**
 * 剑指Offer 面试题 9，用两个栈实现队列
 * @author ychost
 * @date 2018/7/7
 */
public class Q9QueueBy2Stack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
               stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
