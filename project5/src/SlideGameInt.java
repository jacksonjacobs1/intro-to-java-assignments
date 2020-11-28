/**
 * A class describing a 2D array of ints, manipulable using methods that are analagous to the 2048 game.
 * @author Jackson Jacobs
 **/
public class SlideGameInt {
    private int[][] board;

    /**
     * Constructor for for the SlideGame in int form.
     * @param numCols the number of columns in the board.
     * @param numRows the number of rows in the board.
     **/
    public SlideGameInt(int numCols, int numRows){
        this.board = new int[numCols][numRows];
    }

    /**
     * Gets the board of ints.
     * @return the board.
     **/
    public int[][] getBoard(){
        return board;
    }
    /**
     * Sets an item inside the board.
     * @param col the column location.
     * @param row the row location.
     * @param item the integer to replace the value at the location.
     **/
    public void setBoard(int col, int row, int item){
        board[col][row] = item;
    }
    /**
     * Returns whether the game is over.
     * @return whether the game is over.
     **/

    /**
     * Adds another 1 to an empty spot on the board.
     **/
    public void anotherOne(){
        int randomCol = (int)(Math.random() * getBoard().length);
        int randomRow = (int)(Math.random() * getBoard()[0].length);

        if(getBoard()[randomCol][randomRow] == 0){
            setBoard(randomCol, randomRow, 1);
        }
        else{
            anotherOne();
        }
    }

    /**
     * Decides whether the board is full or not.
     * @return false if there are empty spaces.
     **/
    public boolean isGameOver(){
        for(int col = 1; col < getBoard().length - 1; col++){
            for(int row = 1; row < getBoard()[0].length - 1; row++){
                if(getBoard()[col-1][row-1] == 0 || getBoard()[col-1][row-1] == getBoard()[col][row]){
                    return false;
                } else if(getBoard()[col][row-1] == 0 || getBoard()[col][row-1] == getBoard()[col][row]){
                    return false;
                } else if(getBoard()[col+1][row-1] == 0 || getBoard()[col+1][row-1] == getBoard()[col][row]){
                    return false;
                } else if(getBoard()[col+1][row] == 0 || getBoard()[col+1][row] == getBoard()[col][row]){
                    return false;
                } else if(getBoard()[col+1][row+1] == 0 || getBoard()[col+1][row+1] == getBoard()[col][row]){
                    return false;
                } else if(getBoard()[col][row+1] == 0 || getBoard()[col][row+1] == getBoard()[col][row]){
                    return false;
                } else if(getBoard()[col-1][row+1] == 0 || getBoard()[col-1][row+1] == getBoard()[col][row]){
                    return false;
                } else if(getBoard()[col-1][row] == 0 || getBoard()[col-1][row] == getBoard()[col][row]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Compares a target location to an adjacent location, effectively sliding the int along an axis
     * until it meets a wall or a different number.
     * @param col1 the x position of the target location.
     * @param row1 the y position of the target location.
     * @param col2 the x position of the adjacent tile.
     * @param row2 the y position of the adjacent tile.
     **/
    public void compareAndReplace(int col1, int row1, int col2, int row2){
        if(col2 >= 0 && col2 < getBoard().length && row2 >= 0 && row2 < getBoard()[0].length){
            if(getBoard()[col1][row1] != 0){
                int xVector = col2 - col1;
                int yVector = row2 - row1;
                if(getBoard()[col2][row2] == 0){
                    setBoard(col2,row2,getBoard()[col1][row1]);
                    setBoard(col1,row1,0);
                    compareAndReplace(col2, row2, col2 + xVector, row2 + yVector);
                }
                else if(getBoard()[col2][row2] == getBoard()[col1][row1]){
                    setBoard(col2, row2, getBoard()[col2][row2] * 2);
                    setBoard(col1, row1, 0);
                }
            }
        }
    }

    /**
     * Slides all pieces to the west, combining pieces that are equal.
     **/
    public void westSlide(){
        for(int row = 0; row < getBoard()[0].length; row++){
            for(int col = 0; col < getBoard().length; col++){
                compareAndReplace(col, row, col-1, row);
            }
        }
    }
    /**
     * Slides all pieces to the east, combining pieces that are equal.
     **/
    public void eastSlide(){
        for(int row = 0; row < getBoard()[0].length; row++){
            for(int col = getBoard().length - 1; col >= 0; col--){
                compareAndReplace(col, row, col+1, row);
            }
        }
    }
    /**
     * Slides all pieces to the north, combining pieces that are equal.
     **/
    public void northSlide(){
        for(int col = 0; col < getBoard().length; col++){
            for(int row = 0; row < getBoard()[0].length; row++){
                compareAndReplace(col, row, col, row - 1);
            }
        }
    }
    /**
     * Slides all pieces to the south, combining pieces that are equal.
     **/
    public void southSlide(){
        for(int col = 0; col < getBoard().length; col++){
            for(int row = getBoard()[0].length - 1; row >= 0; row--){
                compareAndReplace(col, row, col, row + 1);
            }
        }
    }
    /**
     * Slides all pieces to the northwest, combining pieces that are equal.
     **/
    public void northWestSlide(){
        for(int row = 0; row < getBoard()[0].length; row++){
            for(int col = 0; col < getBoard().length; col++){
                compareAndReplace(col, row, col - 1, row - 1);
            }
        }
    }
    /**
     * Slides all pieces to the northeast, combining pieces that are equal.
     **/
    public void northEastSlide(){
        for(int row = 0; row < getBoard()[0].length; row++){
            for(int col = 0; col < getBoard().length; col++){
                compareAndReplace(col, row, col + 1, row - 1);
            }
        }
    }
    /**
     * Slides all pieces to the southwest, combining pieces that are equal.
     **/
    public void southWestSlide(){
        for(int row = getBoard()[0].length - 1; row >= 0; row--){
            for(int col = 0; col < getBoard().length; col++){
                compareAndReplace(col, row, col - 1, row + 1);
            }
        }
    }
    /**
     * Slides all pieces to the southeast, combining pieces that are equal.
     **/
    public void southEastSlide(){
        for(int row = getBoard()[0].length - 1; row >= 0; row--){
            for(int col = getBoard().length - 1; col >=0; col--){
                compareAndReplace(col, row, col + 1, row + 1);
            }
        }
    }

    /**
     * Prints the board to a string output
     **/
    public String printBoard(){
        StringBuilder output = new StringBuilder();
        for(int row = 0; row < getBoard().length; row++){
            for(int col = 0; col < getBoard()[0].length; col++){
                output.append(getBoard()[col][row] + " ");
            }
            output.append("\n");
        }
        System.out.println(output.toString());
        return output.toString();
    }

    public static void main(String[] args){
        SlideGameInt game = new SlideGameInt(4,4);
        game.setBoard(0,0,1);
        game.setBoard(0,1,2);
        game.setBoard(1,1,1);
        game.setBoard(1,2,1);
        game.setBoard(1,3,1);
        game.setBoard(3,3,1);

        game.printBoard();
        System.out.println();
        game.southSlide();
        game.printBoard();
    }
}
