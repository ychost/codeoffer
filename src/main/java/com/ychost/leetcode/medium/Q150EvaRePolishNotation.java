package com.ychost.leetcode.medium;

import java.util.Stack;

public class Q150EvaRePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer num = null;
        Character op= null;
        for (String token : tokens) {
            if(Character.isDigit(token.charAt(0))){
               num = Integer.valueOf(token);
            }else if(token.length()>1 && token.charAt(0) == '-'){
               num = Integer.valueOf(token);
            }else{
               op = token.charAt(0);
            }
            if(op != null){
               int p2 = stack.pop();
               int p1 = stack.pop();
               switch (op){
                   case  '+':
                       num = p1 + p2;
                       break;
                   case '-':
                       num = p1 - p2;
                       break;
                   case '*':
                       num = p1 * p2;
                       break;
                   case '/':
                       num = p1 / p2;
                       break;
               }
               stack.push(num);
            }else{
                stack.push(num);
            }
            num = null;
            op = null;
        }
        return stack.pop();
    }
}
