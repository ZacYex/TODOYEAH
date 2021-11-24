package algorithms;


import dataStruct.Stack;
import dataStruct.imp.ArrayStack;
import dataStruct.imp.LinkStack;

public class Expression {

    /**
     * 算术表达式求值
     *
     * @param expression 表达式
     * @return 值
     */
    public static Double experssionValue(String expression){
        // String转化为char数组
        char[] expressionArr = expression.toCharArray();
        // 装数值的栈
        Stack<Double> vals = new LinkStack<Double>();
        // 装运算符的栈
        Stack<Character> ops = new LinkStack<Character>();

        for (Character character: expressionArr) {
            if(character == '(');
            else if(character == '+'){ ops.push(character); }
            else if(character == '-'){ ops.push(character); }
            else if(character == '*'){ ops.push(character); }
            else if(character == '/'){ ops.push(character); }
            else if(character == ')'){
                double value = vals.pop();
                Character op = ops.pop();
                switch (op){
                    case '+' : value = value + vals.pop();break;
                    case '-' : value = value - vals.pop();break;
                    case '*' : value = value * vals.pop();break;
                    case '/' : value = value / vals.pop();break;
                }
                vals.push(value);
            }else {
                vals.push((double)character-(double)'0');
            }
        }

        return vals.pop();
    }
}
