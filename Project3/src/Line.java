/**
 * Type consisting of two points
 * @author Jackson Jacobs
 * */
public class Line {
    private Point firstPoint;
    private Point secondPoint;

    /**
     * Line constructor takes four ints and creates two points out of them
     *
     * Points are used in the constructor instead of coordinates for simplicity's
     * sake in the polygon method setLines().
     * @param p1 first point
     * @param p2 second point
     * */
    public Line(Point p1, Point p2){
        this.firstPoint = p1;
        this.secondPoint = p2;
    }
    /**
     * blank constructor for line allows for the creation of an empty line.
     * */
    public Line(){}

    /**
     * Gets the first point of the line
     * @return The first point
     * */
    public Point getFirstPoint() {
        return firstPoint;
    }

    /**
     * Sets the first point.
     * @param firstPoint The first point.
     * */
    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    /**
     * Gets the second point
     * @return The second point.
     * */
    public Point getSecondPoint() {
        return secondPoint;
    }

    /**
     * Sets the second point
     * @param secondPoint The second point
     * */
    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    /**
     * Gets the list of lines
     * @return list of lines
     * */
    public Line[] getLines(){
        return new Line[]{this};
    }

    @Override
    public String toString(){
        if(getFirstPoint() == null){
            return "";
        }
        else{
            StringBuilder output = new StringBuilder();
            output.append("(" + getFirstPoint().getX() + ", " + getFirstPoint().getY() + ")");
            output.append("----");
            output.append("(" + getSecondPoint().getX() + ", " + getSecondPoint().getY() + ")");
            return output.toString();
        }
    }
}
