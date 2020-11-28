import org.junit.Test;

import static org.junit.Assert.*;
/**
 * @author Jackson Jacobs
 * */
public class PolygonTest {

    @Test
    public void pointArrayGettersAndSetters() {
        Point[] pointList = new Point[]{new Point(0.0, 0.0), new Point(0,100.0), new Point(100,0)};
        Polygon x = new Polygon();
        x.setPoints(pointList);
        assertEquals(0.0,x.getPoints()[0].getX(),0);
        assertEquals(100, x.getPoints()[1].getY(),0);
        assertEquals(100, x.getPoints()[2].getX(),0);
    }

    @Test
    public void getCenter() {
        Polygon shape = new Polygon(new Point[]{new Point(0,0), new Point(100,0), new Point(0,100)});
        assertEquals("x value of center", 50, shape.getCenter().getX(), 0.001);
        assertEquals("y value of center", 50, shape.getCenter().getY(), 0.001);
    }

    @Test
    public void setCenter() {
        Polygon shape = new Polygon(new Point[]{new Point(0,0), new Point(100,0), new Point(0,100)});
        shape.setCenter(new Point(100,100));
        assertEquals("x value of new center", 100, shape.getCenter().getX(), 0.001);
        assertEquals("y value of new center", 100, shape.getCenter().getY(), 0.001);
    }

    @Test
    public void getLines() {
        Polygon shape = new Polygon(new Point[]{new Point(0,0), new Point(100,0), new Point(0,100)});
        Line[] lines = shape.getLines();
        assertEquals("","(0.0, 0.0)----(100.0, 0.0)", lines[0].toString());
        assertEquals("","(100.0, 0.0)----(0.0, 100.0)", lines[1].toString());
        assertEquals("","(0.0, 100.0)----(0.0, 0.0)", lines[2].toString());
    }

    @Test
    public void rotate() {
        Polygon shape = new Polygon(new Point[]{new Point(50,50), new Point(100,50), new Point(100,100)});
        shape.rotate(Math.PI/2);
        assertEquals("(100.0, 50.0)", shape.getPoints()[0].toString());
        assertEquals("(100.0, 100.0)", shape.getPoints()[1].toString());
        assertEquals("(50.0, 100.0)", shape.getPoints()[2].toString());

    }
}