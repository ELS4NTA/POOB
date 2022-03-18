package domain;
import java.util.*;


/*No olviden adicionar la documentacion*/
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

    public int  getLength() {
        return LENGTH;
    }

    public Item getItem(int r,int c) {
        return automata[r][c];
    }

    public void setItem(int r, int c, Item e) {
        automata[r][c]=e;
    }

    public void someItems() {
        Cell indiana = new Cell(this, 1, 1);
        Cell cerocerosiete = new Cell(this, 2, 2);
        
        automata[1][1] = indiana;
        automata[2][2] = cerocerosiete;
    }
    
    public void ticTac() {
        for (int i=0;i<automata.length;i++) {
            for (int j=0;j<automata[0].length;j++) {
                if (automata[i][j] != null) {
                    automata[i][j].decide();
                    automata[i][j].change();
                }
            }
        }
    }

}
