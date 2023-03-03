package lection_01_WorkingWithAbstraction_lab.PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return (point.getX() >= bottomLeft.getX() && point.getY() >= bottomLeft.getY()) &&
                (point.getX() <= topRight.getX() && point.getY() <= topRight.getY());
    }
}
