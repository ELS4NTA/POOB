
/**
 * DiceTaken es una aplicacion para jugar con shapes.
 *
 * @author Angie Mojica - Daniel Santanilla
 * @version 0.0.1
 */
public class DiceTaken
{
    private int size;
    private Dice[][] tablero;
    private int xVacio;
    private int yVacio;

    /**
     * Constructor para objetos de la clase DiceTaken
     */
    public DiceTaken(int size)
    {
        this.tablero = new Dice[size][size];
        this.size = size;
        
        for (int i = 0; i<this.tablero.length; i++){
            for (int j = 0; j<this.tablero[i].length;j++){
                byte digit_dice = (byte)(Math.random()*6+1);
                this.tablero[i][j] = new Dice(digit_dice);
                this.tablero[i][j].changeColor("red");
                this.tablero[i][j].moveTo( 110 * j,110 * i);
            }
        }
        
    }
    
    /**
     * Obtiene el tablero de juego
     */
    public void get(){
        for (int i = 0; i<this.tablero.length; i++){
            for (int j = 0; j<this.tablero[i].length;j++){
                this.tablero[i][j].makeVisible();
            }
        }
        
        int i = (int)(Math.random()*this.size);
        int j = (int)(Math.random()*this.size);
        this.xVacio = i;
        this.yVacio = j;
        this.tablero[i][j].makeInvisible();
    }
    
    /**
     * Borra el tablero de juego
     */
    public void delete(){
        for (int i = 0; i<this.tablero.length; i++){
            for (int j = 0; j<this.tablero[i].length;j++){
                this.tablero[i][j].makeInvisible();
            }
        }
    }
    
    /**
     * Lanzar un dado con posicion especifica 
     */
    public void lanzar(int x,int y){
        this.tablero[x-1][y-1].change();
    }
    
    /**
     * Desliza un dado que pueda moverse
     *
     * @param  x,y enteros y en el rango del tablero 
     * 
     */
    public void deslizar(int x,int y){
        this.tablero[this.xVacio][this.yVacio].change(this.tablero[x-1][y-1].get());
        this.tablero[x-1][y-1].makeInvisible();
        this.tablero[this.xVacio][this.yVacio].makeVisible();
        this.xVacio = x-1;
        this.yVacio = y-1;
        
    }
}
