import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Jackson Jacobs

class UtilityTest {
    Utility u1 = new Utility(0.5,new Date(1,1,1));

    @Test
    //tests every getter and setter in the class
    void testAllGettersAndSetters() {
        //tests the utilityRate getter and setter
        u1.setUtilityRate(0.2);
        assertEquals(0.2, u1.getUtilityRate());
        //tests the monthUsage getter and setter
        u1.setMonthUsage(5);
        assertEquals(5, u1.getMonthUsage());
        //tests the update year usage and get year usage methods
        u1.updateYearUsage(1);
        assertEquals(1, u1.getYearUsage());
        //tests the monthBill getter and setter
        u1.setMonthBill(500);
        assertEquals(500,u1.getMonthBill());
        //tests the getBalance and update balance methods
        u1.updateBalance(500);
        assertEquals(500, u1.getBalance());
        //tests the getAmountPaidThisMonth and updateAmountPaidThisMonth methods
        u1.updateAmountPaidThisMonth(500);
        assertEquals(500, u1.getAmountPaidThisMonth());
        //tests the amountDelinquent getter and setter
        u1.setAmountDelinquent(500);
        assertEquals(500, u1.getAmountDelinquent());

    }

    @Test
    //tests the make payment method
    void testMakePayment() {
        //tests the case of adding a payment greater than zero
        u1.makePayment(300);
        assertEquals(-300, u1.getBalance());
        assertEquals(300, u1.getAmountPaidThisMonth());
        //tests the case of adding zero as payment
        u1.makePayment(0);
        assertEquals(-300, u1.getBalance());
        assertEquals(300, u1.getAmountPaidThisMonth());
    }

    @Test
    //tests the endOfMonthProcessing method
    void testEndOfMonthProcessing() {
        Utility u2 = new Utility(0.0, new Date(1,1,1));
        u2.endOfMonthProcessing();
        //tests the zero case
        assertEquals(0, u2.getBalance());
        //tests the positive amount owed case
        u2.setMonthBill(200);
        u2.updateAmountPaidThisMonth(100);
        u2.endOfMonthProcessing();
        assertEquals(100, u2.getAmountDelinquent());

    }

    @Test
    //tests the endOfYearProcessing
    void testEndOfYearProcessing() {
        u1.endOfYearProcessing();
        assertEquals(0, u1.getYearUsage());
    }
}