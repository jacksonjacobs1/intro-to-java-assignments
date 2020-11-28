/**
 * Jackson Jacobs
 * The polygon class represents an abstract template for various subclass shapes
 * including the rectangle and triangle classes.
 * */
public class Polygon {
    private Point[] points;
    /**
     * Constructor for Polygon
     * @param points list of points that describe the polygon
     * precondition: the provided points array must be in order and not null
     * */
    public Polygon(Point[] points){
        this.points = points;
    }
    /**
     * Default polygon constructor allows construction of specific polygons
     * without passing a points array to the super(Point[]) constructor.
     * */
    public Polygon(){}


    /**
     * Returns the list of points that make up the shape.
     * @return the list of points.
     * */
    public Point[] getPoints(){
        return this.points;
    }
    /**
     * setter method for the points array.
     * @param points the points contained
     *               in the polygon.
     * */
    public void setPoints(Point[] points){
        this.points = points;
    }


    /**
     * returns the center of the shape
     * @return the center.
     * */
    public Point getCenter(){
        Point[] pointList = getPoints();
        double xMax = pointList[0].getX();
        double xMin = pointList[0].getX();
        double yMax = pointList[0].getY();
        double yMin = pointList[0].getY();
        for(int i = 1; i < pointList.length; i++){
            if(pointList[i].getX() >= xMax){
                xMax = pointList[i].getX();
            }
            else{
                xMin = pointList[i].getX();
            }
            if(pointList[i].getY() >= yMax){
                yMax = pointList[i].getY();
            }
            else{
                yMin = pointList[i].getY();
            }
        }
        double centerX = (xMax + xMin)/2;
        double centerY = (yMax + yMin)/2;
        return new Point(centerX,centerY);
    }
    /**
     * Shifts each point by the vector defined by the vector between the old and new centers,
     * then sets the old center to be the new center.
     * @param newCenter This is the new center.
     * */
    public void setCenter(Point newCenter){
        double deltaX = newCenter.getX() - getCenter().getX();
        double deltaY = newCenter.getY() - getCenter().getY();
        Point thisPoint;
        for(int i = 0; i < getPoints().length; i++){
            thisPoint = getPoints()[i];
            getPoints()[i] = new Point(thisPoint.getX() + deltaX, thisPoint.getY() + deltaY);
        }
    }


    /**
     * Returns a list of lines that make up the shape
     * @return the list of lines.
     * */
    public Line[] getLines(){
        Line[] lines = new Line[getPoints().length];
        for(int lineIndex = 0; lineIndex < getPoints().length - 1; lineIndex++){
            lines[lineIndex] = new Line(getPoints()[lineIndex], getPoints()[lineIndex + 1]);
        }
        lines[lines.length - 1] = new Line(getPoints()[getPoints().length-1], getPoints()[0]);
        return lines;
    }


    /**
     * Rotates each point around the center of the polygon
     * @param angle The angle of rotation
     * */
    public void rotate(double angle){
        Point center = getCenter();
        for(int i = 0; i < getPoints().length; i++){
            getPoints()[i].rotateAbout(center, angle);
        }
    }

}
