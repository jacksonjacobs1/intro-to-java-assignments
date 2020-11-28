import org.junit.Test;

import static org.junit.Assert.*;
/**
 * @author Jackson Jacobs
 * */
public class RectangleTest {
    @Test
    public void allGettersAndSetters(){
        Rectangle rect1 = new Rectangle(new Point(100,100), 20, 40);
        rect1.setWidth(100);
        rect1.setHeight(50);
        assertEquals(100, rect1.getWidth(), 0.001);
        assertEquals(50, rect1.getHeight(), 0.001);
    }
}