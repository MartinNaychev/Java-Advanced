package WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }


    public boolean Contains(Point point) {

        boolean isContain = false;

        if (point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY()
                && point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX()) {
            isContain = true;
        }

        return isContain;
    }
}
