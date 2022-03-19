package domain;
import java.awt.Color;
/**
 * Una celula inquieta {@link Cell}
 * 
 * @author Angie Mojica - Daniel Santanilla
 * @version 18-03-22
 */
public class Inquieta extends Cell {
    private CellularAutomata automata;
    
    /**
     * Constructor for objects of class Inquieta
     */
    public Inquieta(CellularAutomata ac,int row, int column) {
        super(ac,row, column);
        automata = ac;
        color = Color.orange;
    }
    
    @Override
    public void decide() {
        int limiteFila = automata.getLength()-1;
        int limiteColumna = automata.getLength()-1;
        int row = getRow();
        int column = getColumn();
        int countNeighbors = 0;
        // Encontrando los vecinos de la celula inquieta
        Item vecina = null;
        for (int x=Math.max(0, row-1); x<=Math.min(row+1,limiteFila); x++) {
            for (int y=Math.max(0,column-1); y<=Math.min(column+1,limiteColumna); y++) {
                vecina = automata.getItem(x, y); // Encontrando las vecinas
                if (vecina != this) {
                    if (vecina != null && !vecina.isAlive()) {
                        nextState = 'd'; // Si alguna de las vecinas esta muerta la inquieta muere
                    } else if (vecina == null) {
                        countNeighbors += 1; // Se cuentan los vecinos nulos
                    }
                }
            }
        }
        // Si no existen vecinos se crean celulas al norte y al sur
        if (countNeighbors == 8) {
            if (row != limiteFila || row != 0) {
                new Inquieta(automata,row-1,column); // Inquieta al norte
                new Cell(automata,row+1,column); // Celula al sur
            }
        }
    }
}
