import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Jackson Jacobs

class GasUtilityTest {
    GasUtility gu = new GasUtility(0,new Date(1,1,1));
    @Test
    //tests all getters and setters
    void testAllGettersAndSetters() {
        //tests installmentPlan getter and setter
        gu.setInstallmentPlan(true);
        assertTrue(gu.isInstallmentPlan());
        //tests installment amount getter and setter
        gu.setInstallmentAmount(300);
        assertEquals(300, gu.getInstallmentAmount());
    }

    @Test
    //tests the endOfYearProcessing
    void endOfYearProcessing() {
        //tests the case when yearUsage == 0
        gu.endOfYearProcessing();
        assertEquals(0, gu.getInstallmentAmount());
        assertEquals(0, gu.getYearUsage());
        //tests the case when yearUsage !=
        gu.updateYearUsage(12);
        gu.endOfYearProcessing();
        assertEquals(1, gu.getInstallmentAmount());
        assertEquals(0, gu.getYearUsage());
    }

    @Test
    //tests the getMonthlyCharge method override
    void getMonthlyCharge() {
        //tests the true case, where the overridden method is changed
        assertEquals(gu.getInstallmentAmount(), gu.getMonthlyCharge(true));
        //tests the false case, where the overridden method is used as is
        assertEquals(gu.getMonthUsage() * gu.getUtilityRate(), gu.getMonthlyCharge(false));

    }

    @Test
    //tests the endOfMonthProcessing method
    void endOfMonthProcessing() {
        //tests the override case
        gu.setInstallmentPlan(true);
        gu.setInstallmentAmount(300);
        Utility.setSalesTaxRate(0.5);
        gu.setAmountDelinquent(100);
        gu.endOfMonthProcessing();
        assertEquals(250, gu.getMonthBill());
        //tests the case when installment plan is false, meaning the super method is used.
        gu.setInstallmentPlan(false);
        gu.endOfMonthProcessing();
        assertEquals(0, gu.getMonthBill());

    }
}