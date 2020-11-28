import org.junit.Test;

import static org.junit.Assert.*;
/**
 * @author Jackson Jacobs
 * */
public class NGonTest {

    @Test
    public void NGonTester(){
        NGon square = new NGon(20,4,new Point(100,100));
        assertEquals(90, square.getPoints()[0].getX(),2);
        assertEquals(90, square.getPoints()[1].getX(), 2);
        assertEquals(110, square.getPoints()[2].getX(), 2);
        assertEquals(110, square.getPoints()[3].getX(), 2);
        assertEquals(110, square.getPoints()[0].getY(),2);
        assertEquals(90, square.getPoints()[1].getY(), 2);
        assertEquals(110, square.getPoints()[2].getY(), 2);
        assertEquals(90, square.getPoints()[3].getY(), 2);
    }

    @Test
    public void allGettersAndSetters(){
        NGon pentagon = new NGon(20,5,new Point(100,100));
        assertEquals("(100.0, 100.0)", pentagon.getCenter().toString());
        pentagon.setSideLength(40);
        assertEquals(40.0, pentagon.getSideLength(), 0.001);
        assertEquals(5, pentagon.getNumSides());
    }
}