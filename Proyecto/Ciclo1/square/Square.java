import java.util.ArrayList;
/**
 * Crear una plaza para MTB.
 * 
 * @author Angie Mojica y Daniel Santanilla
 * @version 0.0.1
 */

public class Square {
    private Rectangle place;
    private int dimensionX;
    private int dimensionY;
    private int safetyDistance; 
    private ArrayList<Dome> domesArr = new ArrayList();
    private ArrayList<Tourist> touristArr = new ArrayList();
    private ArrayList<String> colorsDome = new ArrayList();
    private ArrayList<String> colorsTourist = new ArrayList();
    private boolean isVisible;

    /**
     * Constructor para objetos de la clase Square con
     * parametros de construccion
     * @param dimensiones en x, dimensiones en y, distancia segura
     */
    public Square(int dimensionX, int dimensionY, int safetyDistance) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.safetyDistance = safetyDistance;
        isVisible = false;
        place = new Rectangle();
        place.changeSize(dimensionX,dimensionY);
    }

    /**
     * Agregar un Domo a la plaza
     * @param color
     */
    public void addDome(String color, int positionX, int positionY) {
        Dome dome = new Dome(color,positionX,positionY);
        domesArr.add(dome);
        colorsDome.add(color);
        if (this.isVisible){
                dome.makeVisible();
            }
    }
    
    /**
     * Eliminar un Domo de la plaza
     * @param Colores validos: "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void delDome(String Dome) {
        int position = colorsDome.indexOf(Dome);
        domesArr.get(position).makeInvisible();
        domesArr.remove(position);
        colorsDome.remove(position);
    }
    
    /**
     * Llegada de un turista a la plaza
     * @param color
     */
    public void touristArrive(String color, int xPos, int yPos, int angle){
        if (this.isSafety(xPos,yPos)){
            Tourist turista = new Tourist(color,xPos,yPos,angle);
            if (this.isVisible){
                turista.makeVisible();
            }
            touristArr.add(turista);
            colorsTourist.add(color);
        }
        else{
            System.out.println("No es distancia segura, cuidado con el covid.");
        }
        
    }
    
    /**
     * Retorna los domos en la plaza 
     */
    public String[] domes(){
        int size = this.domesArr.size();
        String[] strDomes = new String[size];
        for (int i=0; i < size;i++){
            strDomes[i] = domesArr.get(i).getColor();
        }
        return strDomes;
    }
    
    /**
     * Retorna los turistas en la plaza 
     */
    public String[] tourist(){
        int size = this.touristArr.size();
        String[] strTourist = new String[size];
        for (int i=0; i < size;i++){
            strTourist[i] = touristArr.get(i).getColor();
        }
        return strTourist;
    }
    
    /**
     * Mueve un turista a una posicion especificada
     * @param color turista, posicionx, posiciony
     */
    public void touristMove(String tourist, int xPos, int yPos, int angle){
        int position = colorsTourist.indexOf(tourist);
        touristArr.get(position).moveHorizontal(xPos);
        touristArr.get(position).moveVertical(yPos);
    }
    
    /**
     * Retora la informacion del domo especificado
     * @param color del domo deseado
     * @return dome_info
     */
    public int[] dome(String dome){        
        int position_dome = colorsDome.indexOf(dome);
        int[] dome_info = {domesArr.get(position_dome).getPosx(), domesArr.get(position_dome).getPosy()};
        return dome_info;
    }
    
    /**
     * Retora la informacion del turista especificado
     * @param color del turista deseado
     * @return tourist_info
     */
    public int[] tourist(String tourist){
        int position_tourist = colorsTourist.indexOf(tourist);
        int[] tourist_info = {touristArr.get(position_tourist).getPosx(), touristArr.get(position_tourist).getPosy()};
        return tourist_info;
    }
    
    /**
     * Hace visible la plaza con sus objetos
     */
    public void makeVisible(){
        this.isVisible = true;
        place.makeVisible();
        // Verifica si hay objetos en la plaza
        if (domesArr.size() > 0 || touristArr.size() > 0){
            // Hace visible los domos añadidos previamente
            for (int i=0;i<domesArr.size();i++){
                domesArr.get(i).makeVisible();
            }
            // Hace visible los turistas añadidos previamente
            for (int i=0;i<touristArr.size();i++){
                touristArr.get(i).makeVisible();
            }
        }
    }
    
    /**
     * Hace invisible la plaza con sus objetos
     */
    public void makeInvisible(){
        this.isVisible = false;
        place.makeInvisible();
        // Verifica si hay objetos en la plaza
        if (domesArr.size() > 0 || touristArr.size() > 0){
            // Hace visible los domos añadidos previamente
            for (int i=0;i<domesArr.size();i++){
                domesArr.get(i).makeInvisible();
            }
            // Hace visible los turistas añadidos previamente
            for (int i=0;i<touristArr.size();i++){
                touristArr.get(i).makeInvisible();
            }
        }
    }
    
    private boolean isSafety(int xPosNewTourist,int yPosNewTourist){
        // Si existen turistas en la plaza
        if (touristArr.size() > 0){
            for (int i=0;i<touristArr.size();i++){
                int xPosOldTourist = touristArr.get(i).getPosx();
                int yPosOldTourist = touristArr.get(i).getPosy();
                // Distancia entre turistas
                double distance = Math.sqrt(Math.pow(xPosOldTourist-xPosNewTourist,2)+Math.pow(yPosOldTourist-yPosNewTourist,2));
                if (distance < this.safetyDistance){
                    return false;
                }
            }
            return true;
        }
        else{
            return true;
        }
    }
}
