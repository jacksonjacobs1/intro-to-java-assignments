//Jackson Jacobs

public class GasUtility extends Utility{
    //fields
    private boolean isInstallmentPlan;
    private double installmentAmount;

    //constructor for GasUtility is inherited from the parent class.
    public GasUtility(double utilityRate, Date anniversaryDate){
        super(utilityRate,anniversaryDate);
    }

    //getters and setters

    //returns whether the instance of GasUtility is under the installment plan
    public boolean isInstallmentPlan(){
        return this.isInstallmentPlan;
    }

    //sets is installment plan to either true or false
    public void setInstallmentPlan(boolean isInstallmentPlan){
        this.isInstallmentPlan = isInstallmentPlan;
    }

    //gets the installment amount
    public double getInstallmentAmount(){
        return this.installmentAmount;
    }

    //sets the installment amount
    public void setInstallmentAmount(double installmentAmount){
        this.installmentAmount = installmentAmount;
    }

    //methods

    //overrides the version in the Utility class so that the installment amount can be set
    @Override
    public void endOfYearProcessing(){
        setInstallmentAmount((double)getYearUsage() / 12);
        updateYearUsage(-1 * getYearUsage());
    }

    //overrides the version in Utility so that it can either return the installment amount or the monthly charge
    public double getMonthlyCharge(boolean bool){
        if(bool){
            return getInstallmentAmount();
        }
        else{
            return super.getMonthlyCharge();
        }
    }

    //overrides the Utility constructor so that it takes the installment amount into account
    public void endOfMonthProcessing(){
        if(isInstallmentPlan()){
            setMonthBill(getInstallmentAmount() * getSalesTaxRate() + getAmountDelinquent());
        }
        else{
            super.endOfMonthProcessing();
        }
    }
}
