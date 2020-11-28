//Jackson Jacobs

public class Customer {
    //fields
    private Utility electricUtility;
    private WaterUtility waterUtility;
    private GasUtility gasUtility;
    private Date currentDate;

    //constructor initializes only the current date
    public Customer(Date currentDate){
        this.currentDate = currentDate;
    }

    //constructor2 overloads the first Customer constructor and initializes all the fields
    public Customer(Date currentDate, Utility electricUtility, WaterUtility waterUtility, GasUtility gasUtility){
        this.currentDate = currentDate;
        this.electricUtility = electricUtility;
        this.waterUtility = waterUtility;
        this.gasUtility = gasUtility;
    }

    //getters and setters
    public Utility getElectricUtility(){
        return this.electricUtility;
    }

    public void setElectricUtility(Utility electricUtility){
        this.electricUtility = electricUtility;
    }

    public Utility getWaterUtility(){
        return this.waterUtility;
    }

    public void setWaterUtility(WaterUtility waterUtility){
        this.waterUtility = waterUtility;
    }

    public Utility getGasUtility(){
        return this.gasUtility;
    }

    public void setGasUtility(GasUtility gasUtility){
        this.gasUtility = gasUtility;
    }

    public Date getDate(){
        return this.currentDate;
    }

    public void setDate(Date currentDate){
        this.currentDate = currentDate;
    }

    /*increments date and decides whether to call either the endOfMonthProcessing
    * or endOfYearProcessing method on the customer's three utility fields depending
    * on the day
    */
    public void incrementDate(){
        currentDate.incrementDate();
        if(getDate().equals(electricUtility.getAnniversaryDate())){
            electricUtility.endOfYearProcessing();
        }
        if(getDate().equals(waterUtility.getAnniversaryDate())){
            waterUtility.endOfYearProcessing();
        }
        if(getDate().equals(gasUtility.getAnniversaryDate())){
            gasUtility.endOfYearProcessing();
        }

        if(getDate().sameEffectiveDate(electricUtility.getAnniversaryDate())){
            electricUtility.endOfMonthProcessing();
        }
        if(getDate().sameEffectiveDate(waterUtility.getAnniversaryDate())){
            waterUtility.endOfMonthProcessing();
        }
        if(getDate().sameEffectiveDate(gasUtility.getAnniversaryDate())){
            gasUtility.endOfMonthProcessing();
        }

    }
}
