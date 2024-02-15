/*
 * author: Itmam Alam
 * class: Main
 * date: 07.10.2023
 * */

public class Main {
    public static void main(String[] args) {
        Triangle t = new Triangle("Test", new Point(new int[]{1, 0}), new Point(new int[]{1,5}));
        Prism p = new Prism("Prism", t, 100);

        t.println();
        p.println();
    }
}