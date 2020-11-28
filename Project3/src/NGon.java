/**
 * @author Jackson Jacobs
 * Type describes a regular polygon of an arbitrary amount of sides.
 * */
public class NGon extends Polygon {
    private double sideLength;
    private int numSides;
    private Point nGonCenter;


    /**
     * NGon constructor calls the empty constructor of polygon.
     * @param sideLength the side length
     * @param center the center
     * @param numSides the "N" of the Gon
     * */
    public NGon(double sideLength, int numSides, Point center){
        super();
        this.sideLength = sideLength;
        this.numSides = numSides;
        this.nGonCenter = center;

        double distanceToTop = numSides/(2 * Math.tan(Math.PI / numSides));
        Point[] pointList = new Point[numSides];
        pointList[0] = new Point(getCenter().getX() - sideLength / 2,getCenter().getY() + distanceToTop);
        for(int i = 1; i < numSides - 1; i++){
            Point currentPoint = new Point(pointList[i-1].getX(), pointList[i-1].getY());
            currentPoint.rotateAbout(getCenter(), 2 * Math.PI / numSides);
            pointList[i] = currentPoint;
        }
        setPoints(pointList);
    }

    /**
     * Instead of calculating the center, this method accesses a private field.
     * @return the center of the NGon
     * */
    @Override
    public Point getCenter(){
        return this.nGonCenter;
    }

    /**
     * Getter method for sideLength.
     * @return the sideLength
     * */
    public double getSideLength(){
        return this.sideLength;
    }
    /**
     * Setter method for the side length.
     * @param sideLength the uniform length of a side.
     * */
    public void setSideLength(double sideLength){
        this.sideLength = sideLength;
    }


    /**
     * Getter method for the number of sides.
     * @return the number of sides.
     * */
    public int getNumSides(){
        return this.numSides;
    }
}
