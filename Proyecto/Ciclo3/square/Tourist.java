
/**
 * Un turista es una abstaccion de una persona que llega a la plaza de la simulacion del MTB.
 * 
 * @author Angie Mojica - Daniel Santanilla 
 * @version 0.0.2
 */
public class Tourist
{
    private int xPosition;
    private int yPosition;
    private int pov;
    private int povCam;
    private String color;
    private boolean isVisible;
    Triangle turista = new Triangle();
    
    /**
     * Constructor para objetos de la clase Tourist
     * @param newColor Color del turista definido en la plaza.
     * @param xPos Posicion x del turista definida en la plaza.
     * @param yPos Posicion y del turista definida en la plaza.
     * @param angle Angulo de vision del turista en sentido horario (pov) definida en la plaza.
     */
    public Tourist(String newColor, int xPos, int yPos, int angle) {
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.color = newColor;
        this.pov = angle;
        turista.changeColor(color);
        turista.moveHorizontal(xPosition);
        turista.moveVertical(yPosition);
    }
    
    /**
     * Obtiene la posicion en x del turista.
     * @return Entero con la posicion en x del turista
     */
    public int getPosx(){
        return this.xPosition;
    }
    
    /**
     * Obtiene la posicion en y del turista.
     * @return Entero con la posicion en y del turista.
     */
    public int getPosy(){
        return this.yPosition;
    }
    
    /**
     * Obtiene el angulo de vision del turista (pov).
     * @return Entero con el angulo de vision del turista.
     */
    public int getPov(){
        return this.pov;
    }
    
    /**
     * Obtiene el color del turista.
     * @return Cadena con el color del turista.
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     * Hace visible el turista.
     */
    public void makeVisible(){
        isVisible = true;
        turista.makeVisible();
    }
    
    /**
     * Hace invisible el turista.
     */
    public void makeInvisible(){
        turista.makeInvisible();
        isVisible = false;
    }
    
    /**
     * Posiciona al turista en una coordenada x dada.
     * @distance Cordenada x en el rango de la plaza.
     */
    public void moveHorizontal(int distance){
        turista.moveHorizontal(distance);
        this.xPosition = distance;
    }
    
    /**
     * Posiciona al turista en una coordenada y dada.
     * @distance Cordenada y en el rango de la plaza.
     */
    public void moveVertical(int distance){
        turista.moveVertical(distance);
        this.yPosition = distance;
    }
    
    /**
     * Asigna un angulo de vision al turista
     * @angle Angulo de vison del turista (pov) dado por un numero entre 0 y 360.
     */
    public void setPov(int angle){
        turista.setAngle(angle);
        this.pov = angle;
    }
}
