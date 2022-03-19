package domain;
import java.awt.Color;


/**
 * Una bombillo {@link Agent}
 * 
 * @author Angie Mojica - Daniel Santanilla
 * @version 18-03-22
 */
public class Bulb extends Agent implements Item{
    private CellularAutomata automata;
    private int nextShape;
    private Color color;
    private int row,column;
    private char nextState;
    
    /**
     * Constructor for objects of class Bulb
     */
    public Bulb(CellularAutomata ac,int row, int column) {
        automata=ac;
        this.row=row;
        this.column=column;
        nextState=Agent.ALIVE;
        nextShape=Item.SQUARE;
        automata.setItem(row,column,(Item)this);  
        color = Color.yellow;
    }
    
    /**Decide its next state
     */
    public void decide() {
        if (getAge()>100){
            nextState=Agent.DEAD;
            color = Color.gray;
            shape = Item.ROUND;
        } 
    }
    
    /**Change its actual state
     */
    public final void change(){
        turn();
        if (isAlive()) {
            if (getAge() % 2 == 0) {
                nextShape = Item.ROUND;
            }else {
                nextShape = Item.SQUARE;
            }        
        }
        shape=nextShape;
        state=nextState;
    }
    
    /**
     * Forma que tomara el bombillo en el automata
     * @return Entero con el identificador de la forma
     */
    public final int shape() {
        return shape;
    }
    
    /**Returns the color
     * @return Color
     */
    public Color getColor() {
        return color;
    }
    

}
