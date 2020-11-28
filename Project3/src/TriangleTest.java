import org.junit.Test;

import static org.junit.Assert.*;
/**
 * @author Jackson Jacobs
 * */
public class TriangleTest {
    @Test
    public void getCenterTest(){
        Triangle tri = new Triangle(new Point(0,0), new Point(100,0), new Point(0,100));
        assertEquals("getCenter x", 33,tri.getCenter().getX(), 1);
        assertEquals("getCenter y", 33,tri.getCenter().getY(), 1);

    }

}