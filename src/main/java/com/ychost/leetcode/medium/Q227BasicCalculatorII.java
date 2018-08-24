package com.ychost.leetcode.medium;

import java.util.*;

/**
 * @author ychost
 * @date 2018/8/23
 */
public class Q227BasicCalculatorII {
    public int calculate2(String s){
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int num = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num *= 10;
                num += s.charAt(i) - '0';
                i += 1;
            }
            switch (op) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    break;
                default:
                    break;
            }
            if (i < s.length()) {
                op = s.charAt(i);
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res +=stack.pop();
        }
        return res;
    }
    public int calculate(String s) {
        Deque<String> deque1 = new ArrayDeque<>();
        StringBuilder nb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                if(nb.length() > 0){
                    deque1.offer(nb.toString());
                    nb.setLength(0);
                }
            }else if(ch >= '0' && ch <= '9'){
                nb.append(ch);
            }else{
                if(nb.length() > 0){
                    deque1.offer(nb.toString());
                    nb.setLength(0);
                }
                deque1.offer(String.valueOf(ch));
            }

        }
        if(nb.length() > 0) {
            deque1.offer(nb.toString());
        }
        Map<String,Function3<Integer,Integer,Integer>> funcMap = new HashMap<>();
        funcMap.put("+",(a,b)->a+b);
        funcMap.put("-",(a,b)->a-b);
        funcMap.put("*",(a,b)->a*b);
        funcMap.put("/",(a,b)->a/b);
        Integer res = null;
        String op = null;
        Deque<Object> deque2 = new ArrayDeque<>();
        while(!deque1.isEmpty()){
           String val = deque1.removeFirst();
           if("*".equals(val) || "/".equals(val)){
               op = val;
           }else if("+".equals(val) || "-".equals(val)){
               if(res != null) {
                   deque2.offer(res);
                   res = null;
               }
               deque2.offer(val);
               op = null;
           }else{
               Integer num = Integer.valueOf(val);
               if(res == null){
                   res = num;
               }else{
                   res= funcMap.get(op).apply(res,num);
               }
           }
        }
        if(res != null){
            deque2.offer(res);
        }
        op = null;
        res = null;
        while (!deque2.isEmpty()){
            Object val = deque2.removeFirst();
            if(val instanceof  Integer){
                if(res == null){
                    res = (Integer)val;
                }else{
                    res = funcMap.get(op).apply(res,(Integer)val);
                }
            }else{
                op = val.toString();
            }
        }

        return res.intValue();
    }
}
@FunctionalInterface
interface Function3<A,B,C> {
    public C apply( A a, B b);
}
