public class Main {

    public static void main(String[] args) {
        Shape ellipse = new Ellipse(5, 6);
        Shape circle = new Circle(4);
        Shape triangle = new Triangle(6, 3);
        Shape rectangle = new Rectangle(5, 3);
        Shape square = new Square(7);


        Shape shapes[] = new Shape[5];
        shapes[0] = ellipse;
        shapes[1] = circle;
        shapes[2] = triangle;
        shapes[3] = rectangle;
        shapes[4] = square;

        for (int i = 0; i < shapes.length; i++) {
            shapes[i].shapeArea();
        }
    }
}
