package domain;
import java.util.*;


/**
 * Representa los sistemas que puedan ser
 * descritos como una colección masiva de items 
 * simples que interactúan localmente unos con otros y
 * que evolucionan a pasos discretos.
 */
public class CellularAutomata{
    static private int LENGTH=30;
    private Item[][] automata;
    
    public CellularAutomata() {
        automata=new Item[LENGTH][LENGTH];
        for (int r=0;r<LENGTH;r++){
            for (int c=0;c<LENGTH;c++){
                automata[r][c]=null;
            }
        }
        someItems();
    }
    
    /**
     * Longitud del automata
     * @return Entero con la longitud del automata
     */
    public int  getLength() {
        return LENGTH;
    }

    /**
     * Obtiene un item contenido en el automata
     * @return Item obenido dada las posiciones indicadas
     */
    public Item getItem(int r,int c) {
        return automata[r][c];
    }
    
    /**
     * Coloca un item en el automata
     */
    public void setItem(int r, int c, Item e) {
        automata[r][c]=e;
    }
    
    /**
     * Inicializa items en el automata.
     */
    public void someItems() {
        Cell indiana = new Cell(this, 1, 1);
        Cell cerocerosiete = new Cell(this, 2, 2);
        Cell agamenon = new Inquieta(this, 5, 5);
        Cell venus = new Inquieta(this, 10, 10);
        Bulb noreste = new Bulb(this, 0, 29);
        Bulb suroeste = new Bulb(this, 29, 0);
        Banderin angie = new Banderin(this,15,15);
        Banderin daniel = new Banderin(this,10,5);
        Conway john = new Conway(this, 5, 14);
        Conway horton = new Conway(this, 5,15);
        Muro berlin = new Muro(this, 15,6);
    }
    
    /**
     * Marca el paso del tiempo para todos los Items de Automata.
     */
    public void ticTac() {
        for (int i=0;i<automata.length;i++) {
            for (int j=0;j<automata[0].length;j++) {
                if (automata[i][j] != null) {
                    automata[i][j].decide();
                }
            }
        }
        for (int i=0;i<automata.length;i++) {
            for (int j=0;j<automata[0].length;j++) {
                if (automata[i][j] != null) {
                    automata[i][j].change();
                }
            }
        }
    }

}
