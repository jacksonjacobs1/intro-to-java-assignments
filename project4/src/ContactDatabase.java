import java.util.ArrayList;
import java.util.Scanner;
/**
 * A database specifically for contacts
 * @author Jackson Jacobs*/
public class ContactDatabase extends Database<Contact> {

    public ContactDatabase(){
        super();
    }
    /**
     * A method that prints an arrayList
     * @param list the list to print.*/
    public static void printList(ArrayList list){


    }

    /**
     * A parser for input strings
     * @param input the inputted string
     * @return a list of string keywords*/
    private static String[] inputParse(String input){
        StringBuilder[] output = new StringBuilder[]{new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder()};
        int inputLength = input.length();
        int inputIndex = 0;
        for(int i = 0; i < 4; i++){
            while(inputIndex < inputLength && input.charAt(inputIndex) != ' '){
                output[i].append(input.charAt(inputIndex));
                inputIndex++;
            }
            inputIndex++;
        }
        return new String[]{output[0].toString(), output[1].toString(), output[2].toString(), output[3].toString()};
    }

    public static void main(String[] args){
        ContactDatabase cdb = new ContactDatabase();
        Scanner s = new Scanner(System.in);
        boolean quitMet = false;
        // quit condition
        while(!quitMet){
            String[] input = inputParse(s.next());
            if(input[0].equals("quit")){
                quitMet = true;
            }
            // add condition
            else if(input[0].equals("add")){
                cdb.add(new Contact(input[1], input[2], input[3]));
            }
            // listby condition
            else if(input[0].equals("listby")){
                printList(cdb.getList(input[1]));
            }
            // find condition
            else if(input[0].equals("find")){
                Contact finder = null;
                if(input[1].equals("name")){
                    finder = new Contact(input[2], null, null);
                }
                else if(input[2].equals("number")){
                    finder = new Contact(null, input[2], null);
                }
                else if(input[3].equals("email")){
                    finder = new Contact(null, null, input[2]);
                }
                if(finder != null){
                    cdb.lookup(input[1], finder);
                }
            }
            // delete condition
            else if(input[0].equals("delete")){

            }
            // makeindex condition
            else if(input[0].equals("makeindex")){
                cdb.makeIndex(input[1]);
            }
        }
    }
}