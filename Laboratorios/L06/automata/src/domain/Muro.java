package domain;
import java.awt.Color;
import java.io.Serializable;


/**
 * Es una representacion de un muro en el automata celular
 * @author Angie Mojica - Daniel Santanilla
 * @version 19-03-22
 */
public class Muro implements Item, Serializable{
    private Color color;
    private int shape;
    private CellularAutomata automata;
    private int row,column;

    /**
     * Constructor for objects of class Muro
     * @param ac Automata celular al que va a ser ingresado
     * @param row Fila en el automata celular al que va a ser ingresado
     * @param column Columna en el automata celular al que va a ser ingresado
     */
    public Muro(CellularAutomata ac,int row, int column) {
        automata=ac;
        this.row=row;
        this.column=column;
        shape=Item.SQUARE;
        automata.setItem(row,column,(Item)this);    
        color=Color.green;
    }
    
    /**
     * Decide la siguiente accion en el automata
     */
    public void decide() {
        int limiteFila = automata.getLength()-1;
        if (row >0 || row < limiteFila) {
            int superior =  Math.max(0, row-1);
            int inferior = Math.min(row+1,limiteFila);
            Item arriba = automata.getItem(superior,column);
            Item abajo = automata.getItem(inferior,column);
            if (arriba == null && abajo == null) {
                new Muro(automata,row-1,column);
                new Muro(automata,row+1,column);
            }else if (arriba == null) {
                new Muro(automata,row-1,column);
            }else if (abajo == null) {
                new Muro(automata,row+1,column);
            }
        }
    }
    
    /**
     * Forma que tomara el muro en el automata
     * @return Entero con el identificador de la forma
     */
    public int shape() {
        return shape;
    }
    
    /**
     * Color que tiene el muro.
     * @return Color del muro, este es verde.
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Indica si un muro esta vivo en el automata
     * @return true siempre, dado que el muro siempre estará vivo.
     */
    public boolean isAlive(){
        return true;
    }
}
