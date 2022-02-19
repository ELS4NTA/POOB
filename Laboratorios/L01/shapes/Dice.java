import java.util.Random;

/**
 * A Dice that can be manipulated and that draws itself on a canvas.
 * 
 * @author Angie Mojica and Daniel Santanila 
 * @version 0.0.1
 */
public class Dice
{
    // instance variables - replace the example below with your own
    private byte digit;
    private String color;
    private String colorpoint;
    private int xPosition;
    private int yPosition;
    private boolean isVisible;
    private Rectangle cara;
    private Circle point1;
    private Circle point2;
    private Circle point3;
    private Circle point4;
    private Circle point5;
    private Circle point6;
    private Circle point7;

    /**
     * Constructor for objects of class Dice
     * @param valor is between 1 and 6
     */
    public Dice(byte valor) {
        digit = valor;
        color = "yellow";
        colorpoint = "black";
        xPosition = 70;
        yPosition = 15;
        isVisible = false;
        cara = new Rectangle();
        point1 = new Circle();
        point2 = new Circle();
        point3 = new Circle();
        point4 = new Circle();
        point5 = new Circle();
        point6 = new Circle();
        point7 = new Circle();
        cara.changeSize(100,100);
        cara.changeColor(color);

        point1.changeSize(20);
        point1.moveVertical(10);
        point1.moveHorizontal(60);
        point1.changeColor(colorpoint);
        
        point2.changeSize(20);
        point2.moveVertical(10);
        point2.moveHorizontal(120);
        point2.changeColor(colorpoint);
        
        point3.changeSize(20);
        point3.moveVertical(40);
        point3.moveHorizontal(60);
        point3.changeColor(colorpoint);
        
        point4.changeSize(20);
        point4.moveVertical(40);
        point4.moveHorizontal(120);
        point4.changeColor(colorpoint);
        
        point5.changeSize(20);
        point5.moveVertical(70);
        point5.moveHorizontal(60);
        point5.changeColor(colorpoint);

        point6.changeSize(20);
        point6.moveVertical(70);
        point6.moveHorizontal(120);
        point6.changeColor(colorpoint);
        
        point7.changeSize(20);
        point7.moveVertical(40);
        point7.moveHorizontal(90);
        point7.changeColor(colorpoint);
    }
    
    /**
     * Get a value of Dice 
     */
    public byte get(){
        return digit;
    }
    
    
    /**
     * Add 1 to digit
     */
    public void next(){
        if (digit != 6){
            digit += 1;
            draw();
        }
        else {
            digit = 1;
            draw();
        }
    }
    
    /**
     * Change the digit of Dice
     * @param valor is between 1 and 6
     */
    public void change(byte newDigit){
        digit = newDigit;
        draw();
    }
    
    /**
     * Change the digit random
     * @param valor is between 1 and 6
     */
    public void change(){
       byte numDice = (byte)(Math.random()*6+1);
       change(numDice);
       draw();
    }
    
    /**
     * Make the Dice visible
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make the Dice Invisible
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    private void draw(){
        if  (isVisible) {
            if (digit == 1){
                erase();
                cara.makeVisible();
                point7.makeVisible();
            }
            else if (digit == 2){
                erase();
                cara.makeVisible();
                point1.makeVisible();
                point6.makeVisible();
            }
            else if (digit == 3){
                erase();
                cara.makeVisible();
                point2.makeVisible();
                point5.makeVisible();
                point7.makeVisible();
            }
            else if (digit == 4){
                erase();
                cara.makeVisible();
                point1.makeVisible();
                point2.makeVisible();
                point5.makeVisible();
                point6.makeVisible();
            }
            else if (digit == 5){
                erase();
                cara.makeVisible();
                point1.makeVisible();
                point2.makeVisible();
                point5.makeVisible();
                point6.makeVisible();
                point7.makeVisible();
            }
            else {
                erase();
                cara.makeVisible();
                point1.makeVisible();
                point2.makeVisible();
                point3.makeVisible();
                point4.makeVisible();
                point5.makeVisible();
                point6.makeVisible();
            }
        }
    }
    
    private void erase(){
        if(isVisible) {
            cara.makeInvisible();
            point1.makeInvisible();
            point2.makeInvisible();
            point3.makeInvisible();
            point4.makeInvisible();
            point5.makeInvisible();
            point6.makeInvisible();
            point7.makeInvisible();
        }
    }
    
    /**
     * Move the Dice.
     * @param x, y distance the desired distance in pixels
     */
    public void moveTo(int x, int y){
        erase();
        xPosition = x;
        yPosition = y;
        // mover todo dependiendo x
        cara.moveHorizontal(x);
        point1.moveHorizontal(x);
        point2.moveHorizontal(x);
        point3.moveHorizontal(x);
        point4.moveHorizontal(x);
        point5.moveHorizontal(x);
        point6.moveHorizontal(x);
        point7.moveHorizontal(x);
        // mover todo dependiendo y
        cara.moveVertical(y);
        point1.moveVertical(y);
        point2.moveVertical(y);
        point3.moveVertical(y);
        point4.moveVertical(y);
        point5.moveVertical(y);
        point6.moveVertical(y);
        point7.moveVertical(y);
        
        draw();
    }
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        cara.changeColor(color);
        draw();
    }
}
