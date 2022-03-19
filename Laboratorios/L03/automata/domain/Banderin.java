package domain;
import java.awt.Color;

/**
 * Una celula banderin es representacion de una celula que cambia de color {@link Cell}
 * 
 * @author Angie Mojica - Daniel Santanilla
 * @version 18-03-22
 */
public class Banderin extends Cell{
    Color BLUE = Color.blue;
    Color RED = Color.red;

    /**
     * Constructor for objects of class Banderin
     */
    public Banderin(CellularAutomata ac,int row, int column) {
        super(ac,row,column);
        color = BLUE;
    }
    
    @Override
    public void decide() {
        // Cambiando de color alternativamente entre azul y rojo
        if (isAlive()) {
            if (getAge() % 2 == 0) {
                color = BLUE;
            }else {
                color = RED;
            }
        }
        if (getAge() >= 30) {
            nextState = 'd';
        }
    }
    
    /**
     * Forma de la celula banderin
     * @return Entero con la forma del baderin, siempre sera cuadrada.
     */
    public final int shape() {
        return Item.SQUARE;
    }
}
