/**
 * @author Jackson Jacobs
 * Triangle type describes a polygon made up of three points.
 * */
public class Triangle extends Polygon {
    /**
     * Constructor takes three points as parameters and passes them to Polygon as a Point array.
     * */
    public Triangle(Point p1, Point p2, Point p3){
        super(new Point[]{p1, p2, p3});
    }
    /**
     * Default constructor for triangle so that EquilateralTriangle may be constructed without
     * passing three points to Triangle*/
    public Triangle(){
        super();
    }

    /**
     * Triangle calculates its center in a different way than its parent class.
     * @return the center*/
    @Override
    public Point getCenter(){
        double x1 = getPoints()[0].getX();
        double y1 = getPoints()[0].getY();
        double x2 = (getPoints()[1].getX() + getPoints()[2].getX())/2;
        double y2 = (getPoints()[1].getY() + getPoints()[2].getY())/2;

        double x3 = getPoints()[1].getX();
        double y3 = getPoints()[1].getY();
        double x4 = (getPoints()[0].getX() + getPoints()[2].getX())/2;
        double y4 = (getPoints()[0].getY() + getPoints()[2].getY())/2;

        double centerX = ((x1*y2 - y1*x2)*(x3-x4) - (x1-x2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        double centerY = ((x1*y2 - y1*x2)*(y3-y4) - (y1-y2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        return new Point(centerX,centerY);
    }





}
