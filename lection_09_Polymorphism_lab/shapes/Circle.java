package lection_09_Polymorphism_lab.shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public final double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.pow(Math.PI * radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return  2 * Math.PI * radius;
    }
}
