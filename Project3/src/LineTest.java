import org.junit.Test;

import static org.junit.Assert.*;
/**
 * @author Jackson Jacobs
 * */
public class LineTest {
    @Test
    public void gettersAndSetters(){
        Line l1 = new Line();
        l1.setFirstPoint(new Point(0,0));
        l1.setSecondPoint(new Point(100,100));
        Point p1 = l1.getFirstPoint();
        Point p2 = l1.getSecondPoint();
        assertEquals("getFirstPoint x", 0, p1.getX(), 0.001);
        assertEquals("getfirstPoint y", 0, p1.getY(), 0.001);
        assertEquals("getSecondPoint x", 100, p2.getX(), 0.001);
        assertEquals("getSecondPoint y", 100, p2.getY(), 0.001);
    }

    @Test
    public void testToString(){
        Line l1 = new Line(new Point(0,0), new Point(100,100));
        assertEquals("(0.0, 0.0)----(100.0, 100.0)", l1.toString());
    }

    @Test
    public void getLines(){
        Line l1 = new Line(new Point(0,0), new Point(100,100));
        //the getLines method should return an array containing a line equal to the object.
        assertEquals(l1.toString(), l1.getLines()[0].toString());
    }

}