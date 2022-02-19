
/**
 * Write a description of class Tourist here.
 * 
 * @author Angie Mojica - Daniel Santanilla 
 * @version 0.0.1
 */
public class Tourist
{
    private int xPosition;
    private int yPosition;
    private int pov;
    private String color;
    private boolean isVisible;
    Triangle turista = new Triangle();
    
    /**
     * Constructor for objects of class Tourist
     */
    public Tourist(String newColor, int xPos, int yPos, int angle) {
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.color = newColor;
        this.pov = angle;
        turista.changeColor(color);
        turista.moveHorizontal(xPosition);
        turista.moveVertical(yPosition);
    }
    
    public int getPosx(){
        return this.xPosition;
    }
    
    public int getPosy(){
        return this.yPosition;
    }
    
    /**
     * Retorna el color del turista
     * @return color
     */
    public String getColor() {
        return this.color;
    }
    
    public void makeVisible(){
        isVisible = true;
        turista.makeVisible();
    }
    
    public void makeInvisible(){
        turista.makeInvisible();
        isVisible = false;
    }
    
    public void moveHorizontal(int distance){
        turista.moveHorizontal(distance);
        this.xPosition = distance;
    }
    
    public void moveVertical(int distance){
        turista.moveVertical(distance);
        this.yPosition = distance;
    }
}
