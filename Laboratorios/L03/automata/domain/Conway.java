package domain;
import java.awt.Color;

/**
 * Una celula conway {@link Cell}
 * 
 * @author Angie Mojica - Daniel Santanilla
 * @version 18-03-22
 */
public class Conway extends Cell {
    private CellularAutomata automata;

    /**
     * Constructor for objects of class Conway
     */
    public Conway(CellularAutomata ac,int row, int column) {
        super(ac,row,column);
        automata = ac;
        color = Color.blue;        
    }
    
    @Override
    public void decide() {
        int limiteFila = automata.getLength()-1;
        int limiteColumna = automata.getLength()-1;
        int row = getRow();
        int column = getColumn();
        int countNeighbors = 0;
        
        Item vecina = null;
        for (int x=Math.max(0, row-1); x<=Math.min(row+1,limiteFila); x++) {
            for (int y=Math.max(0,column-1); y<=Math.min(column+1,limiteColumna); y++) {
                vecina = automata.getItem(x, y); 
                if (vecina != this) {
                    if (vecina != null && vecina.isAlive()) {
                        countNeighbors += 1; // Contando las vecinas vivas
                    }
                }
            }
        }
        // ¿COMO HACER QUE INICEN VIVAS AL COMIENZO?
        if (countNeighbors == 3) {
            if (!isAlive()) {
                nextState = 'a'; // Celula revive
            }
        } else if (countNeighbors == 2 || countNeighbors == 3) {
            if (isAlive()) {
                nextState = 'a'; // Celula se mantiene viva si tiene 2 o 3 vecinos vivos
            }
        } else if (countNeighbors < 2 || countNeighbors > 3)  {
            if (isAlive()) {
                nextState = 'd'; // Celula muere si tiene menos de dos o mas de 3 vecinos vivos
            } else {
                nextState = 'd'; // Celula se mantiene viva si tiene menos de dos o mas de 3 vecinos vivos
            }
        }
    }

}
