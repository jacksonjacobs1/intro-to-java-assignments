import org.junit.Test;

import static org.junit.Assert.*;
/**
 * @author Jackson Jacobs
 * */
public class PointTest {
    @Test
    public void allGettersAndSetters(){
        Point p1 = new Point(0,100);
        p1.setX(10);
        p1.setY(20);
        assertEquals("Testing getX", 10, p1.getX(), 0);
        assertEquals("Testing getY", 20, p1.getY(), 0);
    }

    @Test
    public void rotateAbout(){
        Point p1 = new Point(100,0);
        Point origin = new Point(0,0);
        p1.rotateAbout(origin, Math.PI / 2);
        assertEquals("About origin x", 0.0, p1.getX(), 0.001);
        assertEquals("About origin y", 100, p1.getY(), 0.001);
        Point p2 = origin;
        Point offOrigin = new Point(100,100);
        p2.rotateAbout(offOrigin, Math.PI/2);
        assertEquals("About non-origin x", 200, p2.getX(), 0.001);
        assertEquals("About non-origin y", 0, p2.getY(), 0.001);
    }

    @Test
    public void testToString(){
        Point point = new Point(0,0);
        assertEquals("(0.0, 0.0)", point.toString());
        point.setX(100);
        point.setY(100);
        assertEquals("(100.0, 100.0)", point.toString());
        point.setX(10000);
        point.setY(10000);
        assertEquals("(10000.0, 10000.0)", point.toString());
    }

}