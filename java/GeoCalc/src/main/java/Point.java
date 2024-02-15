/*
 * author: Itmam Alam
 * class: Point
 * date: 07.10.2023
 * */

public class Point {
    private int[] coordinates;

    public Point(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void set(int k, int d) {
        coordinates[d] = k;
    }

    public int getVal(int d) {
        return coordinates[d];
    }

    public int getDistance(Point p) {
        if (coordinates.length != p.coordinates.length) {
            throw new IllegalArgumentException("Given argument has different Dimension");
        }
        /* Pythagoras */
        int sum = 0;
        for (int i = 0; i < coordinates.length; i++) {
            int delta = coordinates[i] - p.coordinates[i];
            sum += delta * delta;
        }
        return (int) Math.sqrt(sum);  // cast to integer -> Math.sqrt() returns double
    }
}