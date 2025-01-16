public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }
    
    public static int getArea(int side) {
        return side * side;
    }

    public static int getPerimeter(int side) {
        return 4 * side;
    }
}
