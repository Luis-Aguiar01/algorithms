package fundamentals.chapter3.exercises;

import fundamentals.chapter3.Stack;

public class EX_1_3_9 {
    public static void main(String[] args) {
        String result = infixWithParenthesis("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )");
        System.out.println(result);
    }

    public static String infixWithParenthesis(String expression) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                operands.push(String.valueOf(c));
            }
            else if (c == '+' || c == '-' || c == '*') {
                operators.push(String.valueOf(c));
            }
            else if (c == ')') {
                String right = operands.pop();
                String left = operands.pop();
                String op = operators.pop();
                operands.push("( " + left + " " + op + " " + right + " )");
            }
        }

        return operands.pop();
    }
}
