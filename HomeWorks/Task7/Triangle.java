public class Triangle extends Polygon {
    private double length;
    private double width;

    public void shapeArea() {
        System.out.println("Площадь треугольника равна: " + length * width / 2);
    }

    public Triangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}
