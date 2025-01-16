public class Triangle extends Shape {

    private int side1;
    private int side2;
    private int side3;

    public Triangle(int side1, int side2, int side3) {
        if (!isValidTriangle(side1, side2, side3)) {
            throw new IllegalArgumentException("Invalid sides for a triangle.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Instance method to calculate area
    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Instance method to calculate perimeter
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Check if the triangle is equilateral
    public boolean isEquilateral() {
        return side1 == side2 && side2 == side3;
    }

    // Check if the triangle is isosceles
    public boolean isIsosceles() {
        return side1 == side2 || side2 == side3 || side1 == side3;
    }

    // Check if the triangle is scalene
    public boolean isScalene() {
        return side1 != side2 && side2 != side3 && side1 != side3;
    }

    // Validate if the sides form a triangle
    private static boolean isValidTriangle(int side1, int side2, int side3) {
        return side1 > 0 && side2 > 0 && side3 > 0 &&
               (side1 + side2 > side3) &&
               (side2 + side3 > side1) &&
               (side1 + side3 > side2);
    }
}

