import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0.  (15 July 2000) 
 */

public class Circle{

    public static final double PI=3.1416;
    
    private double diameter;
    private double area;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    
    

    public Circle(){
        diameter = 20;
        area = PI*Math.pow(diameter/2,2);
        xPosition = 0;
        yPosition = 0;
        color = "blue";
        isVisible = false;
    }


       
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Obtiene el color del circulo
     */
    public String getColor(){
        return color;
    }

    public void makeInvisible(){
        erase();
        isVisible = false;
    }

    private void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, 
                new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
            canvas.wait(10);
        }
    }

    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    /**
     * Move the circle a few pixels to the right.
     */
    public void moveRight(){
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp(){
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }

    /**
     * Move the circle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition = distance;
        draw();
    }

    /**
     * Move the circle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        erase();
        yPosition = distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the circle vertically
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        }else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size.
     * @param newDiameter the new size (in pixels). Size must be >=0.
     */
    public void changeSize(double newDiameter){
        erase();
        diameter = newDiameter;
        draw();
    }
    
    /**
     * The circle area.
     */
    public void area(){
        area = PI*Math.pow(diameter/2,2);
        System.out.println("AREA: " + area);
    }
    
    /**
     * Duplicate the circle area.
     */
    public void duplicate(){
        area *= 2;
        double newDiameter = 2*Math.sqrt(area/PI);
        this.changeSize(newDiameter);
        System.out.println("AREA: " + area);
    }
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }

    /**
     * Mode rainbow. 
     */
    public void rainbow(){
        short cont = 0;
        while (true) {
            color = "red";
            draw();
            color = "yellow";
            draw();
            color = "green";
            draw();
            color = "blue";
            draw();
            color = "magenta";
            draw();
            cont += 1;
        }
    }
    
    /**
     * Mode jump. 
     */
    public void boing(){
        int down = 80;
        int up = -70;
        
        while (up < 0) {
            slowMoveVertical(down);
            slowMoveVertical(up);
            down = -up;
            up += 5;
        }
    }
    
    /**
     * Get a value of position x 
     */
    public int getx(){
        return xPosition;
    }
    
    /**
     * Get a value of position x 
     */
    public int gety(){
        return yPosition;
    }
}

