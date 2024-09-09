package fundamentals.chapter3.exercises;

// Balanço de Parenthesis

import fundamentals.chapter3.Stack;

public class EX_1_3_4 {
    public static void main(String[] args) {
        System.out.println(isBalanced("[()]{}{[()()]()}"));
        System.out.println(isBalanced("[(]"));
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            }
            else if (current == ']' || current == '}' || current == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (!isPairValid(top, current)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isPairValid(char top, char current) {
        return ((top == '(' && current == ')') ||
                (top == '[' && current == ']') ||
                (top == '{' && current ==  '}'));
    }
}
