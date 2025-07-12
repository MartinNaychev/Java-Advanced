package Polymorphism.Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        setHeight(height);
       setWidth(width);
    }

    @Override
    public void calculatePerimeter() {
        System.out.println(2 * getWidth() + 2 * getHeight());

    }

    @Override
    public void calculateArea() {
        System.out.println(getHeight() * getWidth());
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
