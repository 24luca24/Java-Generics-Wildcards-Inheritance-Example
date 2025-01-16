public class Ellipse extends Shape {

    private int majorAxis; // Semi-major axis
    private int minorAxis; // Semi-minor axis

    public Ellipse(int majorAxis, int minorAxis) {
        if (majorAxis <= 0 || minorAxis <= 0) {
            throw new IllegalArgumentException("Axes must be positive values.");
        }
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    // Getter for the area of the ellipse
    @Override
    public double getArea() {
        return Math.PI * majorAxis * minorAxis;
    }

    // Getter for the perimeter (using Ramanujan's approximation)
    @Override
    public double getPerimeter() {
        // Ramanujan's approximation:
        double h = Math.pow((double)(majorAxis - minorAxis) / (majorAxis + minorAxis), 2);
        return Math.PI * (majorAxis + minorAxis) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }

    // Getters for axes
    public int getMajorAxis() {
        return majorAxis;
    }

    public int getMinorAxis() {
        return minorAxis;
    }

    // Setters for axes (optional, if you want to allow updates)
    public void setMajorAxis(int majorAxis) {
        if (majorAxis <= 0) {
            throw new IllegalArgumentException("Major axis must be positive.");
        }
        this.majorAxis = majorAxis;
    }

    public void setMinorAxis(int minorAxis) {
        if (minorAxis <= 0) {
            throw new IllegalArgumentException("Minor axis must be positive.");
        }
        this.minorAxis = minorAxis;
    }
}
