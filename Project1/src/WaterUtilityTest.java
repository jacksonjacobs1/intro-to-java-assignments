import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Jackson Jacobs

class WaterUtilityTest {
    WaterUtility wu = new WaterUtility(0.5, new Date(1,1,1), 7, 500);

    @Test
    //tests the getMonthlyCharge method
    void testGetMonthlyCharge() {
        assertEquals(3500, wu.getMonthlyCharge());
    }
}