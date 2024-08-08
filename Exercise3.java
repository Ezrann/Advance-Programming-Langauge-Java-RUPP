import java.util.Scanner;

class MyPoint {
    private Double x;
    private Double y;

    // one that does not accept any arguments or parameters
    // No-arg constructor that creates a point (0, 0)
    public MyPoint() {
        this(0, 0);
    }

    // Constructor that constructs a point with specified coordinates
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter method for x
    public Double getX() {
        return x;
    }

    // Getter method for y
    public Double getY() {
        return y;
    }


    // Method that returns the distance from this point to a specified point of the MyPoint type
    public Double distance(MyPoint point) {
        return distance(point.getX(), point.getY());
    }

    // Method that returns the distance from this point to another point with specified x- and y-coordinates
    public Double distance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));

    }

    // Static method that returns the distance from two MyPoint objects
    public static Double distance(MyPoint point1, MyPoint point2) {
        return point1.distance(point2);
    }
}

// Main method for testing
public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyPoint point1 = new MyPoint(4,6);
        MyPoint point2 = new MyPoint(5,7);

//        System.out.print("Enter value of X for point 1 : ");
//        double x1 = scanner.nextDouble();
//        System.out.print("Enter value of Y for point 1 : ");
//        double y1 = scanner.nextDouble();
//        MyPoint point1 = new MyPoint(x1, y1);
//
//        System.out.print("Enter value of X for point 2 : ");
//        double x2 = scanner.nextDouble();
//        System.out.print("Enter value of Y for point 2 : ");
//        double y2 = scanner.nextDouble();
//        MyPoint point2 = new MyPoint(x2, y2);

        System.out.println("Point1 : (" + point1.getX() + ", " + point1.getY() + ")");
        System.out.println("Point2 : (" + point2.getX() + ", " + point2.getY() + ")");

        System.out.println("Distance from point1 to point2 : " + point1.distance(point2));
        System.out.println("Distance from point1 to point of (0, 0): " + point1.distance(0, 0));
        System.out.println("Static distance from point1 to point2 : " + MyPoint.distance(point1, point2));

        scanner.close();
    }
}
