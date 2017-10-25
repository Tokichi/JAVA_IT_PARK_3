public class Circle extends Ellipse {

    public void shapeArea() {
        System.out.println("Площадь круга равна: " + 2 * Math.PI * getA() * getB());
    }

    public Circle(double radius) {
        super(radius,radius);

    }
}


