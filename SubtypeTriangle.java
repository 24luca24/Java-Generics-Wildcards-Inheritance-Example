public class SubtypeTriangle extends Triangle {
    
    public SubtypeTriangle(int side1, int side2, int side3) {
        super(side1, side2, side3);
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }
}
