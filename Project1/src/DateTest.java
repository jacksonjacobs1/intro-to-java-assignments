//Jackson Jacobs

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DateTest {
    @Test
    /*this tester method sets each field to something new, then tests the getter method on those new values*/
    public void testAllGettersAndSetters(){
        Date testDate = new Date(2020,1,1);
        testDate.setYear(2019);
        testDate.setMonth(2);
        testDate.setDay(3);
        assertEquals(2019, testDate.getYear());
        assertEquals(2,testDate.getMonth());
        assertEquals(3,testDate.getDay());
    }

    @Test
    //tests the constructor
    public void testConstructor(){
        Date x = new Date(1,1,1);
        //tests that x was initialized to the correct values
        assertEquals(1, x.getDay());
        assertEquals(1, x.getMonth());
        assertEquals(1, x.getYear());
    }


    @Test
    //tests the isLeapYear method
    public void testIsLeapYear(){
        //tests the case of a year divisible by 400
        assertTrue(Date.isLeapYear(2000));
        //tests the case of divisible by 4 but not 100
        assertTrue(Date.isLeapYear(2020));
        //tests the case of not divisible by 400 but divisible by 100
        assertFalse(Date.isLeapYear(2300));

    }

    @Test
    //tests the daysPerMonth method
    public void testDaysPerMonth(){
        //tests the 31 days output case
        assertEquals(31, Date.daysPerMonth(3,2020));
        //tests the 30 days output case
        assertEquals(30, Date.daysPerMonth(6, 2020));
        //tests the (not leap year) february case
        assertEquals(28, Date.daysPerMonth(2, 2021));
        //tests the (leap year) february case
        assertEquals(29,Date.daysPerMonth(2,2020));
    }

    @Test
    //tests the sameEffectiveDate method
    public void testSameEffectiveDate(){
        Date testDate = new Date(1,2,28);
        //tests the case when this date is the same as the input date
        assertTrue(testDate.sameEffectiveDate(new Date(1,2,28)));
        //tests the case when this date is the last day of the month and is less than the input date
        assertTrue(testDate.sameEffectiveDate(new Date(1,1,31)));
    }

    @Test
    //tests the incrementDate mehthod
    public void testIncrementDate(){
        Date testDate = new Date(1,3,30);
        //tests when the day is not the last day of the month
        testDate.incrementDate();
        assertEquals(31,testDate.getDay());
        //tests when the day is the last day of the month
        testDate.incrementDate();
        assertEquals(4,testDate.getMonth());
        assertEquals(1,testDate.getDay());
    }

    @Test
    //tests the equals method
    public void testEquals(){
        //tests when the date has the same day and same month
        Date testDate = new Date(1,1,1);
        assertTrue(testDate.equals(1,1));
        //tests when the dates have different days and months
        assertFalse(testDate.equals(2,2));
    }

    @Test
    //tests the toString method
    public void testToString(){
        //tests the case of a normal date
        Date testDate = new Date(1,1,1);
        assertEquals("January 1, 1",testDate.toString());
        //tests the case when an invalid date is created
        Date test2 = new Date(0,0,0);
        assertEquals("January 1, 0",test2.toString());
    }




}