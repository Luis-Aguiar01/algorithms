package fundamentals.chapter1.exercises;

public class Ex1_1_11 {
    public static void main(String[] args) {
        boolean[][] array = new boolean[5][5];

        array[0][0] = true;
        array[1][1] = true;
        array[2][2] = true;
        array[3][3] = true;
        array[4][4] = true;

        array[0][4] = true;
        array[1][3] = true;
        array[3][1] = true;
        array[4][0] = true;

        for (boolean[] booleans : array) {
            for (boolean value : booleans) {
                if (value) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
