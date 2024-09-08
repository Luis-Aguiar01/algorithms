package fundamentals.chapter2.exercises;

import java.awt.geom.Point2D;
import java.util.Random;

public class EX_1_2_1 {
    public static void main(String[] args) {
        int n = 3;
        Point2D[] points = new Point2D[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            points[i] = new Point2D.Double(x, y);
        }

        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = points[i].distance(points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        System.out.println("Min distance: " + minDistance);
    }
}
