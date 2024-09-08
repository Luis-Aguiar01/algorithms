package fundamentals.chapter3;

import java.util.Stack;

/*
    Algoritmo de Dijkstra para Avaliação de Expressão.
    Basicamente, trabalhamos com duas pilhas, as quais
    uma empilha os operadores e a outras os números.
    Sempre que foi encontrado um parêntese de fechamento,
    é desempilhado o último operador, e os últimos dois números,
    sendo que sempre adicionamos o resultado da operação na pilha,
    fazendo com que ela sempre guarde o resultado da última operação,
    sendo este o nosso acumulador.
*/

public class DijkstraEvaluateExpression {
    public static void main(String[] args) {
        Stack<Character> ops = new Stack<>();
        Stack<Double> nums = new Stack<>();
        String expression =  "(1+((2+3)*(4*5)))";

        for (int i = 0; i < expression.length(); i++) {
            char value = expression.charAt(i);

            if (value == '(');
            else if (value == '*') ops.push(value);
            else if (value == '/') ops.push(value);
            else if (value == '+') ops.push(value);
            else if (value == '-') ops.push(value);
            else if (value == ')') {
                char op = ops.pop();
                double v = nums.pop();

                if (op == '+') v += nums.pop();
                else if (op == '-') v -= nums.pop();
                else if (op == '*') v *= nums.pop();
                else v /= nums.pop();

                nums.push(v);
            }
            else nums.push(Double.parseDouble(String.valueOf(value)));
        }

        System.out.println(nums.pop());
    }
}
