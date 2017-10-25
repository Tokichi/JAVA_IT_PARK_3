public class Square extends Rectangle {
    public void shapeArea(){
        System.out.println("Площадь к вадрата равна: " + getLength() * getWidth());
    }

    public Square(double lenght) {
        super(lenght, lenght);
    }
}
