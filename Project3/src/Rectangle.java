/**
 * Type consisting of two length dimensions and a center.
 * Describes a rectangle.
 * @author Jackson Jacobs
 * */
public class Rectangle extends Polygon {
    private double height;
    private double width;
    /**
     * Constructor for the Rectangle class.
     * @param center a point specifying the center of the rectangle.
     * @param height the height of the rectangle.
     * @param width the width of the rectangle.
     * */
    public Rectangle(Point center, double height, double width){
        super();
        this.height = height;
        this.width = width;

        //instantiates the points list of the rectangle.
        double p14x = center.getX() - (getWidth() / 2);
        double p23x = center.getX() + (getWidth() / 2);

        double p12y = center.getY() + (getHeight() / 2);
        double p34y = center.getY() - (getHeight() / 2);

        setPoints(new Point[]{new Point(p14x,p12y), new Point(p23x, p12y), new Point(p23x, p34y), new Point(p14x, p34y)});
    }


    /**
     * getter method for height.
     * @return the height
     * */
    public double getHeight(){
        return this.height;
    }
    /**
     * setter method for height
     * @param height the height
     * */
    public void setHeight(double height){
        this.height = height;
    }


    /**
     * getter method for the width
     * @return the width
     * */
    public double getWidth(){
        return this.width;
    }
    /**
     * setter method for width
     * @param width the width
     * */
    public void setWidth(double width){
        this.width = width;
    }

}
