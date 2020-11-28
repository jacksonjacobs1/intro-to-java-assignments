//Jackson Jacobs
//this is the date class
public class Date {
    //fields
    private int year;
    private int month;
    private int day;

    /*constructor initializes the year, month, day fields
    within the valid ranges for a date*/
    public Date(int year, int month, int day){
        this.year = year;

        if(month < 1){this.month = 1;}
        else if(month > 12){this.month = 12;}
        else{this.month = month;}

        int maxDays = daysPerMonth(month,year);

        if(day < 1){this.day = 1;}
        else if(day > maxDays){this.day = maxDays;}
        else{this.day = day;}

    }
    //getters and setters

    //gets the current year
    public int getYear() {
        return this.year;
    }

    //sets the year
    public void setYear(int year) {
        this.year = year;
    }

    //gets the current month
    public int getMonth() {
        return this.month;
    }

    //sets the month to a value between 1 and 12
    public void setMonth(int month) {
        if(month >= 1 && month <= 12){
            this.month = month;
        }
        else{
            this.month = 1;
        }
    }

    //gets the day
    public int getDay() {
        return this.day;
    }

    //sets the day within a valid range determined by the daysPerMonth() method
    public void setDay(int day) {
        if(day > 1 && day <= daysPerMonth(getMonth(),getYear())){
            this.day = day;
        }
        else{
            this.day = 1;
        }
    }

    //methods

    //returns true if the input year is a leap year and false if it is not.
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0) {
            return year % 100 != 0;
        }
        return false;
    }

    //returns the days in a month.
    public static int daysPerMonth(int month, int year){
        if(month == 2){
            if(!isLeapYear(year)){
                return 28;
            }
            else{
                return 29;
            }
        }
        else if(month == 4){
            return 30;
        }
        else if(month == 6){
            return 30;
        }
        else if(month == 9){
            return 30;
        }
        else if(month == 11){
            return 30;
        }
        else{
            return 31;
        }
    }

    /* compares two dates and checks for either equivalence or whether it is the last day of the month and the input
    day is greater than that.
     */
    public boolean sameEffectiveDate(Date date){
        if(date.getDay() == getDay()){
            return true;
        }
        else if(date.getDay() > getDay() && getDay() == daysPerMonth(getMonth(),getYear())){
            return true;
        }
        else{
            return false;
        }
    }

    // inreases the day by one.
    public void incrementDate(){
        if(getDay() == daysPerMonth(getMonth(),getYear())){
            if(getMonth() == 12){
                setMonth(1);
                setDay(1);
                setYear(getYear() + 1);
            }
            else{
                setMonth(getMonth() + 1);
                setDay(1);
            }
        }
        else{
            setDay(getDay() + 1);
        }
    }

    //checks whether this day equals input day and this month equals input month.
    public boolean equals(int day, int month){
        return this.getDay() == day && this.getMonth() == month;
    }

    //converts the value of month to its name, and outputs a string form of the date.
    public String toString(){
        String monthName = "";
        if(getMonth() == 1){
            monthName = "January";
        }
        else if(getMonth() == 2){
            monthName = "February";
        }
        else if(getMonth() == 3){
            monthName = "March";
        }
        else if(getMonth() == 4){
            monthName = "April";
        }
        else if(getMonth() == 5){
            monthName = "May";
        }
        else if(getMonth() == 6){
            monthName = "June";
        }
        else if(getMonth() == 7){
            monthName = "July";
        }
        else if(getMonth() == 8){
            monthName = "August";
        }
        else if(getMonth() == 9){
            monthName = "September";
        }
        else if(getMonth() == 10){
            monthName = "October";
        }
        else if(getMonth() == 11){
            monthName = "November";
        }
        else if(getMonth() == 12){
            monthName = "December";
        }
        return monthName + " " + getDay() + ", " + getYear();
    }



}
