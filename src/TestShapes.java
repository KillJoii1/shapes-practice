import java.util.Arrays;
import java.util.List;

/**
 *
 * FIRST, COMPLETE Shape interface
 * THEN, COMPLETE Rectangle, Square, and Circle classes
 * LASTLY, COMPLETE TestShapes class
 */

public class TestShapes {
    public static void main(String[] args) {

        /*
        This will be our actual program that we request some information from user to create 3 objects
        We will create 1 Rectangle, 1 Square and 1 Circle object

        Information to create objects will be as below
         -width of the rectangle = 5.5
         -height of the rectangle = 6
         -side of the square = 2.5
         -radius of the circle = 4


         Then print each object
         And print area and perimeters of each object
         Find and print the object which has the largest area

         EXPECTED OUTPUT:
         Circle{radius=4.0}
         Area of the Circle is = 50.24
         Perimeter of the Circle is = 25.12

         Rectangle{width=5.5, height=6.0}
         Area of the Rectangle is = 33.0
         Perimeter of the Rectangle is = 23.0

         Square{side=2.5}
         Area of the Square is = 6.25
         Perimeter of the Square is = 10.0

         Circle has the largest area as 50.24
         */

        Rectangle r1 = new Rectangle();
        r1.setWidth(5.5);
        r1.setHeight(6);

        Square s1 = new Square();
        s1.setSide(2.5);

        Circle c1 = new Circle();
        c1.setRadius(4);

        System.out.println(c1);
        System.out.println("Area of the Circle is = " + c1.getArea());
        System.out.println("Perimeter of the Circle is = " + c1.getPerimeter() + "\n");

        System.out.println(r1);
        System.out.println("Area of the Rectangle is = " + r1.getArea());
        System.out.println("Perimeter of the Rectangle is = " + r1.getPerimeter() + "\n");

        System.out.println(s1);
        System.out.println("Area of the Square is = " + s1.getArea());
        System.out.println("Perimeter of the Square is = " + s1.getPerimeter() + "\n");

        List<Shape> list = Arrays.asList(s1, r1, c1);

        // the same way a list is an interface for ArrayList, LinkedList, etc. is the same way we can define
        // a Shape type to store an object that uses that Shape interface (Rectangle, Square, Circle)
        // All of this is done with the same concept of Polymorphism, allowing is to
        Shape s = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            s = getLargestArea(s, list.get(i));
        }

//        Shape s = list.stream().reduce(list.get(0), TestShapes::getLargestArea);

        System.out.println(s.getClass().getSimpleName() + " has the largest area as " + s.getArea());
    }

    // if both shapes have the same size, then keep the first one we found
    public static Shape getLargestArea(Shape s1, Shape s2) {
        if (s1.getArea() > s2.getArea()) return s1;
        else return s2;
    }
}
