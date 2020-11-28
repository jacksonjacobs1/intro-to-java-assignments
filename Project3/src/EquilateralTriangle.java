/**
 * @author Jackson Jacobs
 * Type of triangle consisting of a center and a sidelength.*/
public class EquilateralTriangle extends Triangle{
    private double sideLength;

    /**
     * Constructor for EquilateralTriangle
     * @param center the center
     * @param sideLength the sideLength
     * */
    public EquilateralTriangle(Point center, double sideLength){
        super();
        double yShift = Math.sqrt(3) * sideLength / 4;
        Point p1 = new Point(center.getX() - sideLength/2, center.getY() - yShift);
        Point p2 = new Point(center.getX() + sideLength/2, center.getY() - yShift);
        Point p3 = new Point(center.getX(), center.getY() + yShift);
        setPoints(new Point[]{p1,p2,p3});
        this.sideLength = sideLength;
    }


}
