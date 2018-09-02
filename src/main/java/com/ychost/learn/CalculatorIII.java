package com.ychost.learn;

import sun.management.snmp.util.SnmpTableCache;

import java.util.Scanner;
import java.util.Stack;

public class CalculatorIII {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();
        System.out.println(calc(expr));
    }
    public static int calc(String expr){
        // 去除中括号，大括号
        expr = expr.replace("{","(").
                replace("[","{").
                replace("}",")").
                replace("]",")");
        int res = 0;
        Integer num = null;
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<expr.length();i++) {
            // 找出数字
            if (Character.isDigit(expr.charAt(i))) {
                num = expr.charAt(i) - '0';
                while (i + 1 < expr.length() && Character.isDigit(expr.charAt(i + 1))) {
                    num = num * 10 + expr.charAt(i + 1) - '0';
                    i += 1;
                }
            } else if (expr.charAt(i) == '(') {
                int j = i, count = 0;
                for (; i < expr.length(); i++) {
                    if (expr.charAt(i) == '(') {
                        count += 1;
                    } else if (expr.charAt(i) == ')') {
                        count -= 1;
                    }
                    if (count == 0) {
                        break;
                    }
                }
                if(j+1<i-1) {
                    num = calc(expr.substring(j + 1, i ));
                }
            }
            if(num != null) {
                fillStack(stack,num,op);
                num = null;
            }
            if(i<expr.length() && !Character.isDigit(expr.charAt(i))){
                op = expr.charAt(i);
            }
        }
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    static void fillStack(Stack<Integer> stack,int num,char op){
        switch (op){
            case '+':
                break;
            case '-':
                num = -num;
                break;
            case '*':
                num = stack.pop() * num;
                break;
            case '/':
                num = stack.pop() / num;
                break;
        }
        stack.push(num);
    }
}
