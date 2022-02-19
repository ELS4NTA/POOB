
/**
 * Write a description of class Dome here.
 * 
 * @author Angie Mojica - Daniel Santanilla
 * @version 0.0.1
 */
public class Dome {
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    Circle dome = new Circle();

    /**
     * Costructor del domo en una plaza.
     */
    public Dome(String newColor, int xPos, int yPos) {
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.color = newColor;
        dome.changeColor(color);
        dome.moveHorizontal(xPosition);
        dome.moveVertical(yPosition);
    }

    public int getPosx(){
        return this.xPosition;
    }
    
    public int getPosy(){
        return this.yPosition;
    }
    
    /**
     * Retorna el color del Domo
     * @return el color del Domo
     */
    public String getColor() {
        return this.color;
    }
    
    public void makeVisible(){
        isVisible = true;
        dome.makeVisible();
    }
    
    public void makeInvisible(){
        dome.makeInvisible();
        isVisible = false;
    }
}
