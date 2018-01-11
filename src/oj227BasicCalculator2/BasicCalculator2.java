package oj227BasicCalculator2;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 Note: Do not use the eval built-in library function.

 * Created by xueyingbai on 18/1/10.
 */
public class BasicCalculator2 {
    public int calculate(String s) {
        int num = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char oper = '+';

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if(!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if(oper == '+') {
                    stack.push(num);
                } else if (oper == '-') {
                    stack.push(-num);
                } else if (oper == '*') {
                    int temp = stack.pop();
                    stack.push(temp * num);
                } else if (oper == '/') {
                    int temp = stack.pop();
                    stack.push(temp / num);
                }
                oper = c;
                num = 0;
            }
        }
        if(num != 0) stack.push(num);
        for(int i: stack) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator2 calculator2 = new BasicCalculator2();
        System.out.println(calculator2.calculate("0-2147483647"));
        System.out.println(calculator2.calculate(" 3/2 "));
    }
}
