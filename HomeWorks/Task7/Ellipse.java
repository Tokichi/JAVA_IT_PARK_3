public class Ellipse extends Shape {
    private double a;
    private double b;
    public void shapeArea(){
        System.out.println("Площадь эллипса равна: " + Math.PI * a * b);
    }

    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
