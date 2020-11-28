import java.util.Comparator;

/**
 * A type to be stored in a database
 * @author Jackson Jacobs*/
public class Contact implements DatabaseType, Comparator<Contact> {
    private String name;
    private String phoneNum;
    private String email;
    private String trait;

    /**
     * Constructor for Contact.
     * @param name the name.
     * @param phoneNum the phone number.
     * @param email the email.
     **/
    public Contact(String name, String phoneNum, String email){
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    /**
     * Getter for name.
     * @return the name.
     **/
    public String getName() {
        return name;
    }
    /**
     * Setter for name.
     * @param name the name.
     **/
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter for the phone number.
     * @return the phone number.
     **/
    public String getPhoneNum() {
        return phoneNum;
    }
    /**
     * Setter for the phone number.
     * @param phoneNum the phone number.
     **/
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    /**
     * Getter for the email.
     * @return the email.
     **/
    public String getEmail() {
        return email;
    }
    /**
     * Setter for the email.
     * @param email the email.
     **/
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Getter for the trait currently used to compare.
     * @return the trait.*/
    public String getTrait(){
        return this.trait;
    }
    public void setTrait(String trait){
        this.trait = trait;
    }

    /**
     * The numberParse method is used to convert a phone number to an int, allowing the number to be compared.
     * @param input the phoneNum string to parse.
     * @return the parsed string typecast to an int.
     **/
    public static int numberParse(String input){
        StringBuilder parsed = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) > 47 && input.charAt(i) < 58){
                parsed.append(input.charAt(i));
            }
        }
        return Integer.parseInt(parsed.toString());
    }

    /**
     * Creates a String from three of the private fields that make up a contact.
     * @return the name, number, and email of the contact.
     **/
    @Override
    public String toString(){
        return "Name: " + name + ", Number: " + phoneNum + ", Email: " + email;
    }

    /**
     * Evaluates whether two contacts are considered to be equal.
     * @param o the contact to be compared with.
     * @return whether or not the two objects are equal contacts.
     **/
    @Override
    public boolean equals(Object o){
        if(o instanceof Contact){
            Contact e = (Contact) o;
            return name.equals(e.name) && phoneNum.equals(e.phoneNum) && email.equals(e.email);
        }
        else{
            return false;
        }
    }

    /**
     * Compares two contacts on based on one of three options, their names, phone numbers, or emails.
     * @param c1 the first contact.
     * @param c2 the second contact.
     * @return the order in which these two objects would be sorted.
     **/
    @Override
    public int compare(Contact c1, Contact c2) {
        return getComparatorByTrait(getTrait()).compare(c1, c2);
    }

    /**
     * Chooses which comparator to use given an input trait.
     * @param trait the desired trait to compare by.
     * @return a NameComparator, PhoneNumberComparator, or EmailComparator.
     **/
    @Override
    public Comparator<Contact> getComparatorByTrait(String trait) {
        if(trait.equals("name")){
            return new NameComparator();
        }
        else if(trait.equals("phone")){
            return new PhoneNumberComparator();
        }
        else if(trait.equals("email")){
            return new EmailComparator();
        }
        return null;
    }

    /**
     * A class describing how contacts might be compared by name.
     **/
    public class NameComparator implements Comparator<Contact>{
        /**
         * Compares two contacts by their names in alphabetical order.
         * @param c1 the first contact.
         * @param c2 the second contact.
         * @return the earliest difference between characters.
         * */
        @Override
        public int compare(Contact c1, Contact c2) {
            for(int i = 0; i < c1.getName().length(); i++){
                if(c1.getName().charAt(i) != c2.getName().charAt(i)){
                    return c1.getName().charAt(i) - c2.getName().charAt(i);
                }
            }
            return 0;
        }
    }

    /**
     * A class describing how contacts might be compared by phone number.
     **/
    public class PhoneNumberComparator implements Comparator<Contact>{
        /**
         * Compares two contacts by their Phone Number in order of the larger phone number.
         * @param c1 the first contact.
         * @param c2 the second contact.
         * @return the difference between the two numbers.
         * */
        @Override
        public int compare(Contact c1, Contact c2) {
            int n1 = numberParse(c1.getPhoneNum());
            int n2 = numberParse(c2.getPhoneNum());
            return n1 - n2;
        }
    }

    /**
     * A class describing how contacts might be compared by email.
     * */
    public class EmailComparator implements Comparator<Contact>{
        /**
         * Compares two contacts by their emails in alphabetical order.
         * @param c1 the first contact.
         * @param c2 the second contact.
         * @return the earliest difference between characters.
         * */
        @Override
        public int compare(Contact c1, Contact c2){
            for(int i = 0; i < c1.getEmail().length(); i++){
                if(c1.getEmail().charAt(i) != c2.getEmail().charAt(i)){
                    return c1.getEmail().charAt(i) - c2.getEmail().charAt(i);
                }
            }
            return 0;
        }
    }
}
