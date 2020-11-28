import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * An application that creates a GUI for the SlideGameInt class.
 * @author Jackson Jacobs
 **/
public class SlideGame extends Application {
    private SlideGameInt intgame;
    private Button[][] buttonGrid;

    /**
     * Getter for the integer version of the game.
     * @return the intgame
     **/
    public SlideGameInt getIntgame(){
        return this.intgame;
    }
    /**
     * Setter for intgame
     * @param intgame the intgame
     **/
    public void setIntgame(SlideGameInt intgame){
        this.intgame = intgame;
    }
    /**
     * Sets the specified button to a label
     * @param col the col index.
     * @param row the row index.
     * @param label the button label.
     **/
    public void updateButtonLabel(int col, int row, String label){
        getButtonGrid()[col][row].setText(label);
        getButtonGrid()[col][row].setStyle("-fx-border-color: #000000; -fx-border-width: 2px;");
        if(label.equals("")){
            getButtonGrid()[col][row].setStyle("-fx-background-color: #eeeeee");
        }
        else if(label.equals("1")){
            getButtonGrid()[col][row].setStyle("-fx-background-color: #bbbbbb");
        }
        else if(label.equals("2")){
            getButtonGrid()[col][row].setStyle("-fx-background-color: #F2D19F");
        }
        else if(label.equals("4")){
            getButtonGrid()[col][row].setStyle("-fx-background-color: #FFAE6F");
        }
        else if(label.equals("8")){
            getButtonGrid()[col][row].setStyle("-fx-background-color: #FF8967");
        }
        else if(label.equals("16")){
            getButtonGrid()[col][row].setStyle("-fx-background-color: #FF7B60");
        }
        else if(label.equals("32")){
            getButtonGrid()[col][row].setStyle("-fx-background-color: #6A7B60");
        }
        else if(label.equals("64")){
            getButtonGrid()[col][row].setStyle("-fx-background-color: #6A3A60");
        }
        else if(label.equals("128")){
            getButtonGrid()[col][row].setStyle("-fx-background-color: #6A1A60");
        }
    }
    /**
     * Getter method for the buttonGrid
     * @return the buttonGrid
     **/
    public Button[][] getButtonGrid(){
        return this.buttonGrid;
    }

    /**
     * Method to be invoked once the game is lost.
     **/
    private void clearButtonGrid(){
        for(int col = 0; col < getButtonGrid().length; col++){
            for(int row = 0; row < getButtonGrid()[0].length; row++){
                getButtonGrid()[col][row].setText("");
            }
        }
        getButtonGrid()[0][0].setText("GAME OVER");
    }

    /**
     * Starts the SlideGame application.
     * @param primaryStage the stage on which the application runs.
     **/
    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);

        setIntgame(new SlideGameInt(8,8));
        this.buttonGrid = new Button[getIntgame().getBoard().length][getIntgame().getBoard().length];

        primaryStage.setWidth(getIntgame().getBoard().length * 100 + 20);
        primaryStage.setHeight(getIntgame().getBoard()[0].length * 100 + 38);

        // creates instances of button and adds them to the pane
        for(int col = 0; col < getButtonGrid().length; col++){
            for(int row = 0; row < getButtonGrid()[0].length; row++){
                getButtonGrid()[col][row] = new Button();
                getButtonGrid()[col][row].setMinSize(100, 100);
                getButtonGrid()[col][row].setMaxSize(100,100);
                pane.add(getButtonGrid()[col][row], col, row);
            }
        }

        //set the on actions of the corners
        int lastColIndex = getButtonGrid().length - 1;
        int lastRowIndex = getButtonGrid()[0].length - 1;
        getButtonGrid()[0][0].setOnAction(new NWEvent());
        getButtonGrid()[0][lastRowIndex].setOnAction(new SWEvent());
        getButtonGrid()[lastColIndex][lastRowIndex].setOnAction(new SEEvent());
        getButtonGrid()[lastColIndex][0].setOnAction(new NEEvent());

        //set the on action of the top and bottom rows
        for(int col = 1; col < lastColIndex; col++){
            getButtonGrid()[col][0].setOnAction(new NorthEvent());
            getButtonGrid()[col][lastRowIndex].setOnAction(new SouthEvent());
        }

        //set the on action of the left and rightmost rows
        for(int row = 1; row < lastRowIndex; row++){
            getButtonGrid()[0][row].setOnAction(new WestEvent());
            getButtonGrid()[lastColIndex][row].setOnAction(new EastEvent());
        }
        getIntgame().anotherOne();
        copyToButtonArray();
        primaryStage.show();
    }

    /**
     * A nested class that handles a button press by sliding all button titles coherently with its respective
     * directional intgame method.
     **/
    public class WestEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            getIntgame().westSlide();
            getIntgame().anotherOne();
            SlideGame.this.copyToButtonArray();
            if(getIntgame().isGameOver()){
                clearButtonGrid();
            }
        }
    }
    /**
     * A nested class that handles a button press by sliding all button titles coherently with its respective
     * directional intgame method.
     **/
    public class EastEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            getIntgame().eastSlide();
            getIntgame().anotherOne();
            SlideGame.this.copyToButtonArray();
            if(getIntgame().isGameOver()){
                clearButtonGrid();
            }
        }
    }
    /**
     * A nested class that handles a button press by sliding all button titles coherently with its respective
     * directional intgame method.
     **/
    public class NorthEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            getIntgame().northSlide();
            getIntgame().anotherOne();
            SlideGame.this.copyToButtonArray();
            if(getIntgame().isGameOver()){
                clearButtonGrid();
            }
        }
    }
    /**
     * A nested class that handles a button press by sliding all button titles coherently with its respective
     * directional intgame method.
     **/
    public class SouthEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            getIntgame().southSlide();
            getIntgame().anotherOne();
            SlideGame.this.copyToButtonArray();
            if(getIntgame().isGameOver()){
                clearButtonGrid();
            }
        }
    }
    /**
     * A nested class that handles a button press by sliding all button titles coherently with its respective
     * directional intgame method.
     **/
    public class NWEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            getIntgame().northWestSlide();
            getIntgame().anotherOne();
            SlideGame.this.copyToButtonArray();
            if(getIntgame().isGameOver()){
                clearButtonGrid();
            }
        }
    }
    /**
     * A nested class that handles a button press by sliding all button titles coherently with its respective
     * directional intgame method.
     **/
    public class NEEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            getIntgame().northEastSlide();
            getIntgame().anotherOne();
            SlideGame.this.copyToButtonArray();
            if(getIntgame().isGameOver()){
                clearButtonGrid();
            }
        }
    }
    /**
     * A nested class that handles a button press by sliding all button titles coherently with its respective
     * directional intgame method.
     **/
    public class SWEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            getIntgame().southWestSlide();
            getIntgame().anotherOne();
            SlideGame.this.copyToButtonArray();
            if(getIntgame().isGameOver()){
                clearButtonGrid();
            }
        }
    }
    /**
     * A nested class that handles a button press by sliding all button titles coherently with its respective
     * directional intgame method.
     **/
    public class SEEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            getIntgame().southEastSlide();
            getIntgame().anotherOne();
            SlideGame.this.copyToButtonArray();
            if(getIntgame().isGameOver()){
                clearButtonGrid();
            }
        }
    }

    public void copyToButtonArray(){
        for(int col = 0; col < getIntgame().getBoard().length; col++){
            for(int row = 0; row < getIntgame().getBoard()[0].length; row++){
                if(getIntgame().getBoard()[col][row] == 0){
                    updateButtonLabel(col, row, "");
                }
                else{
                    updateButtonLabel(col, row, getIntgame().getBoard()[col][row] + "");
                }
            }
        }
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
        Scanner s = new Scanner(System.in);
        boolean quitMet = false;
        while(!quitMet){
            String[] input = inputParse(s.next());
            if(input[0].equals("q")){
                quitMet = true;
            }
            else if(input[0].equals("SlideGame") && input[1] != null){
                Application.launch();
            }
            else if(input[0].equals("SlideGame")){
                Application.launch();
            }
        }
        s.close();
    }
}
