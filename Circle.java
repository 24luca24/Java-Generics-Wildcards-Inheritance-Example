public class Circle extends Ellipse {
    
    private int radius;
    
    public Circle(int radius) {
        super(radius, radius);
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
}
