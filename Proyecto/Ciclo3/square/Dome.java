
/**
 * Clase que representa una cupula de la plaza para el problema de la MTB.
 * 
 * @author Angie Mojica - Daniel Santanilla
 * @version 0.0.3
 */
public class Dome {
    private int xPosition;
    private int yPosition;
    private int numIdentifier;
    private String color;
    private boolean isVisible;
    Circle dome = new Circle();

    /**
     * Costructor para objetos de la domo.
     * @param newColor Color del domo definido en la plaza.
     * @param xPos Posicion en x definida en la plaza.
     * @param yPos Posicion en y definida en la plaza.
     * @param identifier Identificador definido por defecto en la plaza.
     */
    public Dome(String newColor, int xPos, int yPos, int identifier) {
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.color = newColor;
        this.numIdentifier = identifier;
        dome.changeColor(color);
        dome.moveHorizontal(xPosition);
        dome.moveVertical(yPosition);
    }
    
    /**
     * Obtiene el identificador del domo
     * @return Numero de identificacion del domo.
     */
    public int getIdentifier(){
        return this.numIdentifier;
    }
    
    /**
     * Obtiene la posicion en x del domo en la plaza.
     * @return Numero de la posicion en x del domo.
     */
    public int getPosx(){
        return this.xPosition;
    }
    
    /**
     * Obtiene la posicion en y del domo en la plaza.
     * @return Numero de la posicion en y del domo.
     */
    public int getPosy(){
        return this.yPosition;
    }
    
    /**
     * Obtiene el color del Domo.
     * @return Cadena con el color del Domo
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     * Hace visible el domo.
     */
    public void makeVisible(){
        isVisible = true;
        dome.makeVisible();
    }
    
    /**
     * Hace invisible el domo.
     */
    public void makeInvisible(){
        dome.makeInvisible();
        isVisible = false;
    }
}
