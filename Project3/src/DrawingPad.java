/**
 * @author Jackson Jacobs
 * DrawingPad type allows for various shapes to be drawn on a canvas.
 * */
import javax.swing.*;
import java.awt.*;


public class DrawingPad {
    private Graphics graphicsContext;
    private JFrame frame;
    private Canvas canvas;
    private JPanel panel;

    /**
     * Constructor for DrawingPad
     * @param width the width of the JFrame
     * @param height the height of the JFrame*/
    public DrawingPad(int width, int height){
        this.frame = new JFrame();
        this.canvas = new Canvas();
        this.panel = new JPanel();

        canvas.setSize(width, height);
        canvas.setBackground(Color.WHITE);

        panel.add(canvas);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public Graphics getGraphicsContext(){
        if(this.graphicsContext == null){
            this.graphicsContext = canvas.getGraphics();
            if(frame.isVisible()) {
                this.graphicsContext.setColor(Color.BLACK);
            }
            return this.graphicsContext;
        }
        else{
            return this.graphicsContext;
        }
    }

    public void draw(Polygon shape){
        Shape g ;
        for(Line line : shape.getLines()){

        }
    }

    public void erase(){

    }
}
