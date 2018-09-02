package com.ychost.learn;

import java.util.Stack;

public class CalculatorI {
    public int calc(String expr){
        Stack<Integer> stack = new Stack<>();
        Integer num = null;
        char op = '+';
        for(int i=0;i<expr.length();i++){
            // 过滤掉空格
           if(expr.charAt(i) == ' '){
                continue;
           }
           // 解析出数字
           if(Character.isDigit(expr.charAt(i))){
               num = expr.charAt(i) - '0';
               while(i+1<expr.length() && Character.isDigit(expr.charAt(i+1))){
                   num = num * 10 + expr.charAt(i+1) - '0';
                   i+=1;
               }
           }
           if(num != null) {
               switch (op) {
                   case '+':
                       stack.push(num);
                       break;
                   case '-':
                       stack.push(-num);
                       break;
                       // 对于二级运算则先运算再放入栈中
                   case '*':
                       num = stack.pop() * num;
                       stack.push(num);
                       break;
                   case '/':
                       num = stack.pop() / num;
                       stack.push(num);
                       break;

               }
               num = null;
           }
           if(i<expr.length() && !Character.isDigit(expr.charAt(i)) && expr.charAt(i) != ' '){
               op = expr.charAt(i);
           }
        }
        int res = 0;
        // 栈中只剩下一级运算的数字，所以直接累加即可
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
