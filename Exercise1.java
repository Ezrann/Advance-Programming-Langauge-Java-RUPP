class Rectangle {
    private double width;
    private double height;

    // Default constructor
    public Rectangle() {
        this.width = 1;
        this.height = 2;
    }

    // Constructor with specified width and height
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Method to get the area of the rectangle
    public double getArea() {
        return this.width * this.height;    // Formula area of Rectangle
    }

    // Method to get the perimeter of the rectangle

    public double getPerimeter() {
        return 2 * (this.width + this.height); // Formula perimeter of Rectangle
    }

    // Getters for width and height
    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public static void main(String[] args) {
        // Creating two Rectangle objects
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.7);

        // Displaying details of rectangle1

        System.out.println("Rectangle 1 :");
        System.out.println("Width of Rectangle 1 : " + rectangle1.getWidth());
        System.out.println("Height of Rectangle 1 : " + rectangle1.getHeight());
        System.out.println("Area of Rectangle 1 : " + rectangle1.getArea());
        System.out.println("Perimeter of Rectangle 1 : " + rectangle1.getPerimeter());

        // Displaying details of rectangle2

        System.out.println("\nRectangle 2 :");
        System.out.println("Width of Rectangle 2 : " + rectangle2.getWidth());
        System.out.println("Height of Rectangle 2 : " + rectangle2.getHeight());
        System.out.println("Area of Rectangle 2 : " + rectangle2.getArea());
        System.out.println("Perimeter of Rectangle 2 : " + rectangle2.getPerimeter());
    }
}
