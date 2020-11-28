//Jackson Jacobs

public class WaterUtility extends Utility{
    private int numBaths;
    private double bathFee;

    public int getNumBaths(){
        return this.numBaths;
    }

    public void setNumBaths(int numberOfBaths){
        this.numBaths = numberOfBaths;
    }

    public double getBathFee(){
        return this.bathFee;
    }

    public void setBathFee(double fee){
        this.bathFee = fee;
    }

    public double getMonthlyCharge(){
        return getMonthUsage() * getUtilityRate() + getNumBaths() * getBathFee();
    }

    /*The constructor sets the utility rate, anniversary date,
    * number of baths, and bath fee by passing their respective parameters.
    * uses the built in characteristics of setAnniversary date to manage the
    * input of February 29th*/

    public WaterUtility(double utilityRate, Date anniversaryDate, int numBaths, double bathFee){
        super(utilityRate, anniversaryDate);
        setNumBaths(numBaths);
        setBathFee(bathFee);
    }
}
