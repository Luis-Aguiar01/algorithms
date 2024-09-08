package fundamentals.chapter2.exercises;

public class Interval1D {
    private double min;
    private double max;

    public Interval1D(double min, double max) {
        if (min > max) throw new IllegalArgumentException();
        this.min = min;
        this.max = max;
    }

    public boolean intersects(Interval1D other) {
        return this.max >= other.getMin() && other.getMax() >= this.min;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "{ min: " + min + ", max: " + max + "} ";
    }
}
