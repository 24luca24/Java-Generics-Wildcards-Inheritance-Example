import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")

public class Shape {
    public static void main(String[] args) {

    //GENERICS ASSIGNMENT

    //TODO: key concept
    /*
     * LISKOV PRINCIPLE -> "Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.”
     * 
     * INVARIANCY OF GENERICS -> Shape >= Triangle, but List<Shape> is not >= List<Triangle>
     */

    //#1 BASE CASE
    /*
    *Consider only the ArrayList implementation for the List interface. For each of the following variables, write:
    *1) all (possibly raw) types of ArrayList instances that can be assign to the variable
    *2) all (possibly raw) types that can be obtained from a get operation on list;
    *3) all (possibly raw) types that can be added to the list with an add operation. Consider null values 
     */

    //FIRST CASE List<Shape> listShape

        //1)ArrayList instances that can be assign
        List<Shape> listShape = new ArrayList<Shape>();   
        List<Shape> listShape1 = new ArrayList<>(); 
        List<Shape> listShape2 = new ArrayList();

        //2)types that can be obtained from a get operation //!subclasses can't be retrieved
        Shape shape = listShape.get(0);
        Object obj = listShape.get(0);
        //Rectangle rectangle = listShape.get(0) 
        //!For istance If it was possible, I could get an Ellipse from the list and assign it to a square ABSURD.

        //3)types that can be added to the list with an add operation 
        listShape.add(new Shape());
        listShape.add(new Rectangle(3, 4));
        listShape.add(new Square(4));
        listShape.add(new Ellipse(3, 4));
        listShape.add(new Circle(3));
        listShape.add(new Triangle(3, 4, 5));
        listShape.add(null);
        //listShape.add(new Object()); //!wrong 

    //SECOND CASE List<? extends Ellipse> list //TODO: here Ellipse is the upperBound, meaning that the list can contain Ellipse or subtype

        //1)ArrayList instances that can be assign
        List<? extends Ellipse> listEllipses = new ArrayList<Ellipse>();
        List<? extends Ellipse> listEllipses1 = new ArrayList();
        List<? extends Ellipse> listEllipses2 = new ArrayList<>();
        List<? extends Ellipse> listEllipses3 = new ArrayList<Circle>();
        //List<? extends Ellipse> listEllipses4 = new ArrayList<Shape>(); //!wrong Shape is a super class of Ellipse 

        //2)types that can be obtained from a get operation
        Ellipse ellipse = listEllipses.get(0);
        Shape shape1 = listEllipses.get(0);
        Object object = listEllipses.get(0);
        //Circle circle = listEllipses.get(0);
        //Rectangle rect = listEllipses.get(0); 
        //!here is only possible to retrieve element of the upperbound type, so they can be assigned also to supertype (Shape/Object)

        //3)types that can be added to the list with an add operation 
        listEllipses.add(null);
        //listEllipses.add(new Ellipse(2, 3));
        //listEllipses.add(new Circle(3));
        //!here we cannot add element to the list except null. The compiler doesn't know if the list is declared of type Ellipse or Circle (see 1)
        //!so if it was possible I could have add an Ellipse to a list of Circle 

    //THIRD CASE List<? super Triangle> list
        
        //1)ArrayList instances that can be assign //TODO: here Triangle is a lowerBound, meaning that the list can contain Triangle or supertype
        List<? super Triangle> listTriangle = new ArrayList<Triangle>();
        List<? super Triangle> listTriangle1 = new ArrayList();
        List<? super Triangle> listTriangle2 = new ArrayList<>();
        List<? super Triangle> listTriangle3 = new ArrayList<Object>();
        List<? super Triangle> listTriangle4 = new ArrayList<Shape>();
        //List<? super Triangle> listTriangle3 = new ArrayList<SubtypeTriangle>(); //!wrong subtype is a subtype of Triangle
        
        //2)types that can be obtained from a get operation
        //Triangle traingle = listTriangle.get(0); //!here we can only retrieve Object because it's the supertype of everything
        Object o = listTriangle.get(0);
        //TODO: in the list we can have Shape. Imagine assign to a rectangle an object of type Shape. That's why is not allowed to retrieve object

        //3)types that can be added to the list with an add operation 
        listTriangle.add(new Triangle(3,4, 5));
        listTriangle.add(new SubtypeTriangle(1, 3, 5));
        listTriangle.add(null);
        //listTriangle.add(new Shape()); //!not allowed we can only add Triangle or subtype
        //TODO: if it was possible I could have add to a list of Triangle an Ellipse because Ellipse is a Shape
    }
    


    //default methods to be overriden by subclasses 
    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }
}