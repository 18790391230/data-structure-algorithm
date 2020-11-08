package com.wym.stack;


import java.util.Stack;

/**
 * 中缀表达式实现计算器，使用栈来实现
 * 栈的操作有：入栈和出栈
 * 暂只考虑+、-、*、/，不考虑括号，则只有2个优先级，+、-相同优先级，*、/相同优先级
 * 所以要先计算*、/ 可以在入栈时进行*、/操作
 * 再计算+、- 可以在出栈时进行+、-操作
 *
 */
public class ZhongzhuiExpressionCalculator {

    public static void main(String[] args) {
        String expression = "1 + 2 * 3 - 4 * 5".replace(" ","");
        //定义两个栈，一个存放操作符，一个存放操作数
        Stack<Character> oprStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (Character c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (oprStack.isEmpty()) {
                    oprStack.push(c);
                } else {
                    if (isGreater(oprStack, c)) {  //当前操作符大于栈顶操作符，直接入栈
                        oprStack.push(c);
                    } else {
                        //当前运算符小于等于栈顶操作符，则从数栈pop出2个数，从符号栈pop一个符号进行运算，将结果push数栈
                        Integer num2 = numStack.pop();
                        Integer num1 = numStack.pop();
                        numStack.push(calc(oprStack.pop(), num1, num2));
                        oprStack.push(c);
                    }
                }
            } else {
                numStack.push(Integer.parseInt(c.toString()));
            }
        }

        //当符号栈不为空时，从符号栈pop出一个操作符，从操作数栈pop出2个数，进行运算，运算后将结果pop到操作数栈
        while (!oprStack.isEmpty()) {
            Integer num2 = numStack.pop();
            Integer num1 = numStack.pop();
            numStack.push(calc(oprStack.pop(), num1, num2));
        }

        System.out.println(expression + "的计算结果是：" + numStack.pop());
    }

    public static int calc(char opr, int num1, int num2) {
        switch (opr) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }

    /**
     * 判断当前操作符c的计算优先级是否大于栈顶操作符的优先级
     * @param oprStack
     * @param c
     * @return
     */
    private static boolean isGreater(Stack<Character> oprStack, Character c) {

        if (oprStack.peek().equals('*') || oprStack.peek().equals('/')) {
            return false;
        }
        if ((oprStack.peek().equals('+') || oprStack.peek().equals('-'))
                && (c.equals('*') || c.equals('/'))) {
            return true;
        }
        throw new RuntimeException("不支持的操作符：" + c);
    }
}
