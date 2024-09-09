package fundamentals.chapter3.exercises;

import fundamentals.chapter3.Stack;

import java.util.List;

public class EX_1_3_2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        List<String> words = List.of(
                "it", "was", "-", "the", "best", "-",
                "of", "times", "-", "-", "-", "it", "was", "-",
                "the", "-", "-"
        );

        for (String word : words) {
            if (word.equals("-")) {
                System.out.println(stack.pop());
            } else {
                stack.push(word);
            }
        }
    }
}
