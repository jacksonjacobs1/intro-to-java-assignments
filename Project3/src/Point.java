/**
 * A type that stores a two dimensional coordinate
 * @author Jackson Jacobs
 * */
public class Point {
    private double x;
    private double y;

    /**
     * Constructor for Point class
     * @param x The x coordinate.
     * @param y The y coordinate.*/
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Setter for the x coordinate
     * @param x The x coordinate
     * */
    public void setX(double x){
        this.x = x;
    }

    /**
     * Getter for the x coordinate
     * @return The x coordinate
     * */
    public double getX(){
        return x;
    }

    /**
     * Setter for the y coordinate
     * @param y The y coordinate
     * */
    public void setY(double y){
        this.y = y;
    }

    /**
     * Getter for the y coordinate
     * @return The y coordinate
     * */
    public double getY() {
        return y;
    }

    /**
     * Rotates the point around the input point by the given angle
     * @param origin The center of rotation
     * @param angle The amount of rotation in radians
     * */
    public void rotateAbout(Point origin, double angle){
        double xShifted = getX() - origin.getX();
        double yShifted = getY() - origin.getY();
        double xPrime = xShifted * Math.cos(angle) - yShifted * Math.sin(angle);
        double yPrime = xShifted * Math.sin(angle) + yShifted * Math.cos(angle);
        setX(xPrime + origin.getX());
        setY(yPrime + origin.getY());
    }

    @Override
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }
}
