package fundamentals.chapter1.exercises;

/*
* Check if all arguments passed via args are equal.
*/
public class Ex1_1_3 {
    public static void main(String[] args) {
        boolean isAllEqual = true;
        int size = args.length;

        for (int i = 0; i < size - 1 && isAllEqual; i++) {
            if (!args[i].equals(args[i + 1])) {
                isAllEqual = false;
            }
        }

        if (isAllEqual) {
            System.out.println("Equal.");
        }
        else {
            System.out.println("Not equal.");
        }
    }
}
