/**
 * @author Jackson Jacobs
 * the square type
 * */
public class Square extends Rectangle {
    /**
     * Constructor
     * @param sideLength the side length
     * @param center the center
     * */
    public Square(Point center, double sideLength){
        super(center, sideLength, sideLength);
    }
}
