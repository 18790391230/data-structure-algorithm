package com.wym.stack;

import java.util.Stack;

public class BracketsCheck {

    public static void main(String[] args) {
        String str = "{{()()}}{}";
//        String str = "{{(})()}}{}";

        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            switch (c) {
                case '{':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if ('{' == stack.peek()) {
                        stack.pop();
                    } else {
                        throw new RuntimeException("表达式不合法！");
                    }
                    break;
                case ')':
                    if ('(' == stack.peek()) {
                        stack.pop();
                    }else {
                        throw new RuntimeException("表达式不合法！");
                    }
                    break;

            }
        }
        System.out.println("表达式是否合法：" + stack.isEmpty());

    }
}
