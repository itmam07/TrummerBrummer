/*
 * author: Itmam Alam
 * class: GeoArray
 * date: 07.10.2023
 * */

import java.util.ArrayList;
import java.io.*;

public class GeoArray {
    private ArrayList<Geo> geoArray;
    private int max;
    private final int T_Triangle = 1;
    private final int T_Square = 2;
    private final int T_Circle = 3;
    private final int T_Pyramid = 4;
    private final int T_Cuboid = 5;
    private final int T_Cylinder = 6;
    private final int T_Prism = 7;

    public GeoArray() {
        this(10);
    }

    public GeoArray(int max) {
        geoArray = new ArrayList<>();
        setMax(max);  // set new max for resetting the array
    }

    public void add(int type, String desc, Point[] points) {
        if (geoArray.size() < getMax()) {
            switch (type) {
                case T_Triangle:
                    geoArray.add(new Triangle(desc, points[0], points[1]));
                    break;
                case T_Square:
                    geoArray.add(new Square(desc, points[0], points[1]));
                    break;
                case T_Circle:
                    geoArray.add(new Circle(desc, points[0], points[1]));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown figure type. Allowed types are Triangle, Square, Circle");
            }
        } else throw new IllegalArgumentException("Array is full. Max size: " + getMax());
    }

    public void add(int type, String desc, Point[] points, int height) {
        if (geoArray.size() < getMax()) {
            switch (type) {
                case T_Pyramid:
                    geoArray.add(new Pyramid(desc, new Triangle(desc, points[0], points[1]), height));
                    break;
                case T_Cuboid:
                    geoArray.add(new Cuboid(desc, new Square(desc, points[0], points[1]), height));
                    break;
                case T_Cylinder:
                    geoArray.add(new Cylinder(desc, new Circle(desc, points[0], points[1]), height));
                    break;
                case T_Prism:
                    geoArray.add(new Prism(desc, new Triangle(desc, points[0], points[1]), height));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown figure type. Allowed types Pyramid, Cuboid, Cylinder, Prism");
            }
        } else throw new IllegalArgumentException("Array is full. Max size: " + getMax());
    }

    public void println() {
        for (Geo geo : geoArray) {
            geo.println();
        }
    }

    public void println(String desc) {
        for (Geo geo : geoArray) {
            if (geo.getDesc().equals(desc)) {
                geo.println();
                return;
            }
        }
    }

    public void remove(String desc) {
        for (Geo geo : geoArray) {
            if (geo.getDesc().equals(desc)) {
                System.out.println("Removed " + geo.getDesc());
                geoArray.remove(geo);
                return;
            }
        }
    }

    public void remove() {
        geoArray.clear();
    }

    public void readFrom(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            String[] parts;

            while ((line = br.readLine()) != null) {
                parts = line.split(";");

                if (parts.length == 6) {
                   // TODO
                } else if (parts.length == 9) {
                   // TODO
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("\nCheck path of " + fileName);
            System.err.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println("\nError while reading " + fileName);
            System.err.println(ioe.getMessage());
        }
    }

    public void add(Geo figure) {
        if (geoArray.size() < getMax()) {
            geoArray.add(figure);
        } else throw new IllegalArgumentException("Array is full. Max size: " + getMax());
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
