package fundamentals.chapter2.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EX_1_2_2 {
    public static void main(String[] args) {
        int N = 5;
        List<Interval1D> intervals = new ArrayList<>();
        Random random = new Random();

        try {
            for (int i = 0; i < N; i++) {
                double min = random.nextDouble(100);
                double max = random.nextDouble(100);
                intervals.add(new Interval1D(min, max));
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(i).intersects(intervals.get(j))) {
                    System.out.println(intervals.get(i) + " " + intervals.get(j));
                }
            }
        }
    }
}
