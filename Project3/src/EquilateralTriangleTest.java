import org.junit.Test;

import static org.junit.Assert.*;
/**
 * @author Jackson Jacobs
 * */
public class EquilateralTriangleTest {
    @Test
    public void EquilateralTriangleTest(){
        EquilateralTriangle triangle = new EquilateralTriangle(new Point(100,100), 50);
        assertEquals("getCenter x", 100, triangle.getCenter().getX(), 0.001);
        assertEquals("getCenter y", 100, triangle.getCenter().getY(), 0.001);
    }
}