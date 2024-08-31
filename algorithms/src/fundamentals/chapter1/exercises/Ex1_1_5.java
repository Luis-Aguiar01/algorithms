package fundamentals.chapter1.exercises;

/*
*   Check if x and y are between 0 and 1.
*/
public class Ex1_1_5 {
    public static void main(String[] args) {

        if (args.length >= 2) {
            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);

            if ((x >= 0 && x <= 1) && (y >= 0 && y <= 1)) {
                System.out.println("True.");
            } else {
                System.out.println("False.");
            }
        }
    }
}
