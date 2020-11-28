import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Jackson Jacobs

class CustomerTest {
    Customer c = new Customer(new Date(1,1,2));
    @Test
    //tests all the getters and setters
    void testAllGettersAndSetters() {
        //tests the null return from getElectricUtility
        assertNull(c.getElectricUtility());
        //tests the electricUtility getter and setter
        c.setElectricUtility(new Utility(0.5, new Date(1,1,1)));
        assertEquals(0.5, c.getElectricUtility().getUtilityRate());
        //tests the null return from getWaterUtility
        assertNull(c.getWaterUtility());
        //tests the waterUtility getter and setter
        c.setWaterUtility(new WaterUtility(0.5, new Date(1,1,1), 5, 10));
        assertEquals(0.5, c.getWaterUtility().getUtilityRate());
        //tests the null return of getGasUtility
        assertNull(c.getGasUtility());
        //tests the gasUtility getter and setter
        c.setGasUtility(new GasUtility(0.5, new Date(1,1,1)));
        assertEquals(0.5, c.getGasUtility().getUtilityRate());
        //tests the date getter and setter
        c.setDate(new Date(1,1,1));
        assertEquals(1,c.getDate().getDay());

    }

    @Test
    //tests the increment date method
    void testIncrementDate() {
        c.setDate(new Date(1,1,1));
        c.setElectricUtility(new Utility(0.5, new Date(1,1,1)));
        c.setWaterUtility(new WaterUtility(0.5, new Date(1,1,1),5,10));
        c.setGasUtility(new GasUtility(0.5, new Date(1,1,1)));
        c.getElectricUtility().updateYearUsage(5);
        c.incrementDate();
        assertEquals(5, c.getElectricUtility().getYearUsage());

    }
}