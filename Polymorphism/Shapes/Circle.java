package Polymorphism.Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        setRadius(radius);
    }

    @Override
    public void calculatePerimeter() {
        System.out.println(2*Math.PI * getRadius());
    }

    @Override
    public void calculateArea() {
        System.out.println(Math.PI * getRadius() * getRadius());
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
