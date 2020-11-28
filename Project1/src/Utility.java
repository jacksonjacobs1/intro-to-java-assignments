//Jackson Jacobs

public class Utility {
    //fields
    private double utilityRate;
    private int monthUsage;
    private int yearUsage;
    private double monthBill;
    private double balance;
    private double amountDelinquent;
    private double amountPaidThisMonth;
    private static double salesTaxRate;
    private static double interestRate;
    private Date anniversaryDate;

    //constructor
    public Utility(double utilityRate, Date anniversaryDate){
        this.utilityRate = utilityRate;
        if(anniversaryDate.getMonth() == 2 && anniversaryDate.getDay() == 29){
            anniversaryDate.setDay(28);
        }
        this.anniversaryDate = anniversaryDate;
    }


    //getters and setters

    //gets the utility rate
    public double getUtilityRate(){
        return this.utilityRate;
    }

    //sets the utility rate
    public void setUtilityRate(double rate){
        this.utilityRate = rate;
    }

    //gets the monthly usage
    public int getMonthUsage(){
        return this.monthUsage;
    }

    //sets the monthly usage
    public void setMonthUsage(int amount){
        this.monthUsage = amount;
    }

    //gets the yearly usage
    public int getYearUsage(){
        return this.yearUsage;
    }

    //adds a certain amount to the yearly total usage
    public void updateYearUsage(int addedAmount){
        this.yearUsage += addedAmount;
    }

    //gets the monthly bill
    public double getMonthBill(){
        return this.monthBill;
    }

    //sets the monthly bill
    public void setMonthBill(double billAmount){
        this.monthBill = billAmount;
    }

    //gets the balance
    public double getBalance(){
        return this.balance;
    }

    //updates the balance to be
    public void updateBalance(double incrementAmount){
        this.balance += incrementAmount;
    }

    //gets the amount the user paid that month
    public double getAmountPaidThisMonth(){
        return this.amountPaidThisMonth;
    }

    //adds a new payment to the total payment that month
    public void updateAmountPaidThisMonth(double newPayment){
        this.amountPaidThisMonth += newPayment;
    }

    //gets the amount owed
    public double getAmountDelinquent(){
        return this.amountDelinquent;
    }

    //sets the amount owed
    public void setAmountDelinquent(double amountOwed){
        this.amountDelinquent = amountOwed;
    }

    //adds the new payment to amountPaidThisMonth and subtracts it from the balance
    public void makePayment(double payment){
        updateBalance(-1 * payment);
        updateAmountPaidThisMonth(payment);
    }

    //gets the date of when the account was started
    public Date getAnniversaryDate(){
        return this.anniversaryDate;
    }

    //sets the anniversary date
    public void setAnniversaryDate(Date newDate){
        if(!(newDate.getMonth() == 2 && newDate.getDay() == 29)){
            this.anniversaryDate = newDate;
        }
    }

    //gets the sales tax rate from the Utility class
    public static double getSalesTaxRate(){
        return salesTaxRate;
    }

    //sets the sales tax rate in the Utility class
    public static void setSalesTaxRate(double taxRate){
        salesTaxRate = taxRate;
    }

    //gets the interest rate from the Utility class
    public static double getInterestRate(){
        return interestRate;
    }

    //sets the interest rate in the Utility class
    public static void setInterestRate(double newRate){
        interestRate = newRate;
    }

    //calculates the monthly charge
    public double getMonthlyCharge(){
        return getMonthUsage() * getUtilityRate();
    }

    /*Calculates the final balance at the end of the month, and
    * applies extra fees to calculate the monthly bill. Then
    * resets the amount paid that month to zero*/
    public void endOfMonthProcessing(){
        updateBalance(getMonthlyCharge());
        updateBalance(getMonthlyCharge() * getSalesTaxRate());
        double owedThisMonth = getMonthBill() - getAmountPaidThisMonth();
        setAmountDelinquent(getAmountDelinquent() + owedThisMonth);

        if(getAmountDelinquent() > 0){
            setAmountDelinquent(getAmountDelinquent() * (1 + getInterestRate()));
            updateBalance(getAmountDelinquent() * getInterestRate());
        }

        setMonthBill(getBalance());
        updateAmountPaidThisMonth(-1 * getAmountPaidThisMonth());

    }

    //sets the yearly usage to zero
    public void endOfYearProcessing(){
        updateYearUsage(-1 * getYearUsage());
    }
}
