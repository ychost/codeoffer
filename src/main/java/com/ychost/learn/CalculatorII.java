package com.ychost.learn;

import java.util.Stack;

public class CalculatorII {
    public int calc(String expr){
        Stack<Integer> stack = new Stack<>();
        int res = 0,sign=1,num = 0;
        for(int i=0;i<expr.length();i++){
            if(Character.isDigit(expr.charAt(i))) {
                num = expr.charAt(i) - '0';
                while (i + 1 < expr.length() && Character.isDigit(expr.charAt(i + 1))) {
                    num = num * 10 + expr.charAt(i + 1) - '0';
                    i += 1;
                }
                res += num * sign;
            }else if(expr.charAt(i) == '+'){
                sign = 1;
            }else if(expr.charAt(i) == '-'){
                sign = -1;
            }else if(expr.charAt(i) == '('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            }else if(expr.charAt(i) == ')'){
               res= res * stack.pop() + stack.pop();
            }

        }
        return res;
    }

    public int calculate(String expr) {
        if(expr == null || expr.length() == 0){
            return 0;
        }
        Integer num = null;
        int res = 0;
        char op = '+';
        for(int i=0;i<expr.length();i++){
            if(expr.charAt(i) == ' '){
                continue;
            }
            if(Character.isDigit(expr.charAt(i))){
                num = expr.charAt(i) - '0';
                while(i+1<expr.length() && Character.isDigit(expr.charAt(i+1))){
                    num = num * 10 + expr.charAt(i+1) - '0';
                    i+=1;
                }
            }else if(expr.charAt(i) == '('){
                int count = 0,j = i;
                for(;i<expr.length();i++){
                    if(expr.charAt(i) == '('){
                        count += 1;
                    }else if(expr.charAt(i) == ')'){
                        count -= 1;
                    }
                    if(count == 0){
                        break;
                    }
                }
                if(j+1<i){
                    num = calculate(expr.substring(j+1,i));
                }
            }
            if(num != null){
                if(op == '-'){
                    num = -num;
                }
                res += num;
                num = null;
            }
            if(i<expr.length() && !Character.isDigit(expr.charAt(i))){
                op = expr.charAt(i);
            }
        }
        return res;
    }
}
