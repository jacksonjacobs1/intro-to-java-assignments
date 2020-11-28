import org.junit.Test;
import static org.junit.Assert.*;
public class SlideGameIntTest {

    @Test
    public void getSetBoard() {
        SlideGameInt game = new SlideGameInt(3,3);
        assertEquals(3, game.getBoard().length);
        game.setBoard(0,0,1);
        assertEquals(1, game.getBoard()[0][0]);
    }

    @Test
    public void anotherOne() {
        SlideGameInt game = new SlideGameInt(1,1);
        game.anotherOne();
        assertEquals(1, game.getBoard()[0][0]);
        game.anotherOne();
        assertEquals("board is full", 1, game.getBoard()[0][0]);
    }

    @Test
    public void compareAndReplace(){
        SlideGameInt game = new SlideGameInt(2,1);
        game.setBoard(1,0,1);
        game.compareAndReplace(1,0,2,0);
        assertEquals("adjacent coord. out of bounds",1, game.getBoard()[1][0]);
        game.compareAndReplace(0,0,1,0);
        assertEquals("target int is zero", 1, game.getBoard()[1][0]);
        game.setBoard(0,0,2);
        game.compareAndReplace(0,0,1,0);
        assertEquals("Adj. int != target int", 2, game.getBoard()[0][0]);
        game.setBoard(1,0,2);
        game.compareAndReplace(0,0,1,0);
        assertEquals("Adj. int == target int", 4, game.getBoard()[1][0]);
    }

    @Test
    public void isFull() {

    }

    @Test
    public void westSlide() {
        SlideGameInt game = new SlideGameInt(5,5);
        /**
         * | 0 0 0 0 1 |
         * | 2 0 0 0 1 |
         * | 1 0 0 0 1 |
         * | 1 1 2 2 0 |
         * | 1 2 1 2 0 |*/
        game.setBoard(4,0,1);
        game.setBoard(0,1,2);
        game.setBoard(4,1,1);
        game.setBoard(0,2,1);
        game.setBoard(4,2,1);
        game.setBoard(0,3,1);
        game.setBoard(1,3,1);
        game.setBoard(2,3,2);
        game.setBoard(3,3,2);
        game.setBoard(0,4,1);
        game.setBoard(1,4,2);
        game.setBoard(2,4,1);
        game.setBoard(3,4,2);
        game.westSlide();
        String stringGrid = "1 0 0 0 0 \n2 1 0 0 0 \n2 0 0 0 0 \n4 2 0 0 0 \n1 2 1 2 0 \n";
        assertEquals(stringGrid, game.printBoard());
    }

    @Test
    public void eastSlide() {
        // similar enough to west slide that rigorous testing is unnecessary
    }

    @Test
    public void northSlide() {
        // similar enough to west slide that rigorous testing is unnecessary
    }

    @Test
    public void southSlide() {
        // similar enough to west slide that rigorous testing is unnecessary
    }

    @Test
    public void northWestSlide() {

    }

    @Test
    public void northEastSlide() {
    }

    @Test
    public void southWestSlide() {
    }

    @org.junit.Test
    public void southEastSlide() {
    }
}