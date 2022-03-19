import java.util.*;
import java.util.Arrays;

/**
 * Crea un simulador de una plaza para MTB.
 * 
 * @author Angie Mojica y Daniel Santanilla
 * @version 0.0.2
 */

public class Square {
    private Rectangle place;
    private int countIdentifier;
    private int dimensionX;
    private int dimensionY;
    private int safetyDistance; 
    private int[] desiredView;
    private HashMap<String,Dome> domeshash = new HashMap();
    private ArrayList<Dome> domes = new ArrayList();
    private ArrayList<Tourist> tourists = new ArrayList();
    private ArrayList<String> colorsDomes = new ArrayList();
    private ArrayList<String> colorsTourists = new ArrayList();
    private boolean isVisible;
    private boolean ok;

    /**
     * Constructor para objetos de la clase Square con
     * parametros de construccion.
     * @param dimensionX Dimensiones en el plano x recomendable que use dimensiones entre 100 y 600.
     * @param dimensionY Dimensiones en el plano y recomendable que use dimensiones entre 100 y 600.
     * @param safetyDistance Distancia segura, es recomendable que escoja 
     * su distancia entre 10 y 60 dependiendo del tamanno de su simulacion.
     */
    public Square(int dimensionX, int dimensionY, int safetyDistance) {
        if ((dimensionX>=100 && dimensionX<=600) && (dimensionY>=100 && dimensionY<=600)){
            this.dimensionX = dimensionX;
            this.dimensionY = dimensionY;
            this.safetyDistance = safetyDistance;
            this.countIdentifier = 1;
            this.ok = true;
            isVisible = false;
            place = new Rectangle();
            place.changeSize(dimensionX,dimensionY);
        }
        this.ok();
    }
    
    /**
     * Constructor para objetos de la clase Square con
     * parametros de construccion.
     * @param dimensions Dimensiones de la plaza en X y en Y se recomienda dimensiones entre 100 y 600.
     * @param domes Domos Con las posiciones en X y en Y los domos maximos aceptados son 6.
     * @param desiredView Orden de los domos.
     */
    public Square(int[] dimensions, int[][] domes, int[] desiredView){
        String[] COLORS = {"red","blue","yellow","black","magenta","green"};
        this.dimensionX = dimensions[0];
        this.dimensionY = dimensions[1];
        this.countIdentifier = 1;
        this.desiredView = desiredView;
        this.ok = true;
        isVisible = false;
        place = new Rectangle();
        place.changeSize(dimensionX,dimensionY);
        for (int i=0;i<domes.length;i++){
            String randomColor = COLORS[i];
            addDome(randomColor,domes[i][0],domes[i][1]);
        }
        
    }
    
    /**
     * Asigna la foto que se requiere tomar con el orden de los domos.
     * @param domes Orden de los domos en los que se requiere tomar la foto.
     */
    public void defineRequestedPhoto(String[] domes){
        this.desiredView = new int[domes.length];
        for (int i=0;i<domes.length;i++){
            Dome dome = domeshash.get(domes[i]);
            this.desiredView[i] = dome.getIdentifier();
        }
    }
    
    /**
     * Agregar un Domo a la plaza
     * @param color Colores validos: "red", "yellow", "blue", "green",
     * "magenta" and "black".
     * @param positionX Posicion en el eje x.
     * @param positionY Posicion en el eje y.
     */
    public void addDome(String color, int positionX, int positionY) {
        this.ok = false;
        // Verificando que las posiciones dadas estan dentro de la plaza
        if ((positionX>=0 && positionX<=this.dimensionX) && (positionY>=0 && positionY<=this.dimensionY)){
            Dome dome = new Dome(color,positionX,this.dimensionY-positionY,this.countIdentifier);
            domeshash.put(color, dome);
            this.countIdentifier += 1;
            
            domes.add(dome);
            colorsDomes.add(color);
            if (this.isVisible){
                dome.makeVisible();
            }
            this.ok = true;
        }
        this.ok();
    }
    
    /**
     * Eliminar un Domo de la plaza
     * @param dome Colores validos: "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void delDome(String dome) {
        domeshash.remove(dome);
        int position = colorsDomes.indexOf(dome); // Idice del domo en el ArrayList
        domes.get(position).makeInvisible(); // Haciendo invisible el domo
        // Eliminando referencias al domo
        domes.remove(position); 
        colorsDomes.remove(position); 
    }
    
    /**
     * Llegada de un turista a la plaza
     * @param color Colores validos: "red", "yellow", "blue", "green",
     * "magenta" and "black".
     * @param xPos Posicion en el eje x del turista.
     * @param yPos Posicion en el eje y del turista.
     * @param angle Angulo de vision del turista.
     */
    public void touristArrive(String color, int xPos, int yPos){
        this.ok = false;
        // Verificando que es seguro annadir un turista
        if (this.isSafety(xPos,yPos)){
            Tourist turista = new Tourist(color,xPos,this.dimensionY-yPos,0);
            if (this.isVisible){
                turista.makeVisible();
            }
            // Annadiendo referencias del nuevo turista
            tourists.add(turista);
            colorsTourists.add(color);
            this.ok = true;
        }
        else{
            System.out.println("No es distancia segura, cuidado con el covid.");
        }
        this.ok();
    }
    
    /**
     * Mueve un turista a una posicion especificada
     * @param tourist Identificador (color) del turista.
     * @param xPos Posicion en el eje x a la que se quiere mover.
     * @param yPos Posicion en el eje y a la que se quiere mover.
     * @param angle Nuevo angulo de vision del turista en sentido horario
     * recomendable usar angulos entre 0 y 360.
     */
    public void touristMove(String tourist, int xPos, int yPos, int angle){
        this.ok = false;
        int position = colorsTourists.indexOf(tourist); // Obteniendo el indice del turista en el ArrayList
        // Realizando movimientos
        if ((xPos >= 0 && xPos <= this.dimensionX)&&(yPos >= 0 && yPos <= this.dimensionY)) {
            if (isSafety(xPos,yPos)){
                tourists.get(position).moveHorizontal(xPos);
                tourists.get(position).moveVertical(this.dimensionY-yPos);
                tourists.get(position).setPov(angle);
                this.ok = true;
            }
            else{
                if (this.isVisible){
                    System.out.println("No te puedes mover porque esa no es una distancia segura.");
                }
            }
        }
        this.ok();
    }
    
    /**
     * Toma una foto de el angulo de vision del turista
     * @param Turista que quiere tomar la foto en la plaza.
     * @return Array con los domos que fueron captados en camara.
     */
    public String[] touristTakePhoto(String tourist){
        String[] domesPhotos = new String[domeshash.size()];
        int contador = 0;
        int position = colorsTourists.indexOf(tourist);
        // Posicion del turista con los ejes del enunciado
        int xTurista = tourists.get(position).getPosx();
        int yTurista = this.dimensionY-tourists.get(position).getPosy();
        double angle = Math.toRadians(tourists.get(position).getPov()); // Angulo en radianes
        // Punto con los ejes de referencia trasladados y rotados con el angulo, origen el turista
        double xComparacionT = (xTurista-xTurista)*Math.cos(angle)+(yTurista-yTurista)*Math.sin(angle); 
        for (Dome dome: domeshash.values()) {
            // Posicion del domo con los ejes del enunciado
            int xDome = dome.getPosx();
            int yDome = this.dimensionY-dome.getPosy();
            // Punto con los ejes de referencia trasladados y rotados con el angulo, origen el turista
            double xComparacionD = (xDome-xTurista)*Math.cos(angle)+(yDome-yTurista)*Math.sin(angle);
            if (xComparacionD > xComparacionT){
                domesPhotos[contador] = dome.getColor();
                contador += 1;
            }
        }
        return domesPhotos;
    }
    
    /**
     * Toma una foto dependiendo del angulo de la camara del turista
     * @param tourist Turista que quiere tomar la foto en la plaza.
     * @param viewingAngle Angulo de la camara este numero debe estar contenido en 0 y 360.
     * @return Array con los domos que fueron captados en camara.
     */
    public String[] touristTakePhoto(String tourist, int viewingAngle){
        String[] domesPhotos = new String[domeshash.size()];
        int contador = 0;
        int position = colorsTourists.indexOf(tourist);
        // Posicion del turista con los ejes del enunciado
        int xTurista = tourists.get(position).getPosx();
        int yTurista = this.dimensionY-tourists.get(position).getPosy();
        double angle = Math.toRadians(viewingAngle); // Angulo en radianes
        // Punto con los ejes de referencia trasladados y rotados con el angulo, origen el turista
        double xComparacionT = (xTurista-xTurista)*Math.cos(angle)+(yTurista-yTurista)*Math.sin(angle); 
        for (Dome dome: domeshash.values()) {
            // Posicion del domo con los ejes del enunciado
            int xDome = dome.getPosx();
            int yDome = this.dimensionY-dome.getPosy();
            
            // Punto con los ejes de referencia trasladados y rotados con el angulo, origen el turista
            double xComparacionD = (xDome-xTurista)*Math.cos(angle)+(yDome-yTurista)*Math.sin(angle);
            if (xComparacionD > xComparacionT){
                domesPhotos[contador] = dome.getColor();
                contador += 1;
            }
        }
        return domesPhotos;
    }
    
    /**
     * Retorna los domos en la plaza
     * @return Array<String> con los identificadores (colores) de los domos.
     */
    public String[] domes(){
        int size = this.domes.size();
        String[] strDomes = new String[size]; // Creando un Array con el tamanno del ArrayList de domos
        // Annadiendo referencias de los domos al Array creado
        for (int i=0; i < size;i++){
            strDomes[i] = domes.get(i).getColor();
        }
        return strDomes;
    }
    
    /**
     * Retorna los turistas en la plaza
     * @return Array<String> con los identificadores (colores) de los turistas.
     */
    public String[] tourists(){
        int size = this.tourists.size();
        String[] strTourist = new String[size]; // Creando un Array con el tamanno del ArrayList de turistas
        // Annadiendo referencias de los turistas al Array creado
        for (int i=0; i < size;i++){
            strTourist[i] = tourists.get(i).getColor();
        }
        return strTourist;
    }
    
    /**
     * Retorna la informacion del domo especificado
     * @param dome Color del domo deseado; Colores validos: "red", "yellow", "blue", "green",
     * "magenta" and "black".
     * @return Array con las posiciones en X y en Y del domo.
     */
    public int[] dome(String dome){        
        int position_dome = colorsDomes.indexOf(dome); // Indice del domo especificado
        int[] dome_info = {domes.get(position_dome).getPosx(), domes.get(position_dome).getPosy()};
        return dome_info;
    }
    
    /**
     * Retorna la informacion del turista especificado
     * @param tourist Color del turista deseado; Colores validos: 
     * "red", "yellow", "blue", "green","magenta" and "black"
     * @return Array con las posiciones en X y en Y del turista.
     */
    public int[] tourist(String tourist){
        int position_tourist = colorsTourists.indexOf(tourist); // Indice del turista especificado
        int[] tourist_info = {tourists.get(position_tourist).getPosx(), tourists.get(position_tourist).getPosy()};
        return tourist_info;
    }
    
    /**
     * Hace visible la plaza con sus objetos
     */
    public void makeVisible(){
        this.isVisible = true;
        place.makeVisible();
        // Verifica si hay objetos en la plaza
        if (domes.size() > 0 || tourists.size() > 0){
            // Hace visible los domos annadidos previamente
            for (int i=0;i<domes.size();i++){
                domes.get(i).makeVisible();
            }
            // Hace visible los turistas annadidos previamente
            for (int i=0;i<tourists.size();i++){
                tourists.get(i).makeVisible();
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
        if (domes.size() > 0 || tourists.size() > 0){
            // Hace visible los domos annadidos previamente
            for (int i=0;i<domes.size();i++){
                domes.get(i).makeInvisible();
            }
            // Hace visible los turistas annadidos previamente
            for (int i=0;i<tourists.size();i++){
                tourists.get(i).makeInvisible();
            }
        }
    }
    
    /**
     * Finalizacion del simulador borrando toda la informacion
     */
    public void finish() {
        for (Tourist turista: tourists) {
            turista.makeInvisible();
        }
        for (Dome domo: domes) {
            domo.makeInvisible();
        }
        place.makeInvisible();
        place.changeSize(0,0);
        tourists = new ArrayList();
        domes = new ArrayList();
        domeshash = new HashMap();
        colorsDomes = new ArrayList();
        colorsTourists = new ArrayList();
        desiredView = new int[0];
        this.ok = true;
        ok();
    }
    
    /**
     * Verifica si una operacion se pudo ejecutar en el sumulador.
     * @return true si la operacion se realizó satisfactoriamente,
     * de lo contrario false.
     */
    private boolean ok(){
        return this.ok;
    }
    
    /* Si es seguro que ingrese un turista a la plaza con condiciones de bioseguridad
     * @return boolean se calcula la distancia entre los turistas y si es seguro el turista ingresa (true)
     * en caso de que no sea seguro este no ingresa (false)
     */
    private boolean isSafety(int xPosNewTourist,int yPosNewTourist) {
        // Si existen turistas en la plaza
        boolean flag = true;
        if (tourists.size() > 1){
            // Recorriendo los turistas
            for (int i=0;i<tourists.size();i++){
                int xPosOldTourist = tourists.get(i).getPosx();
                int yPosOldTourist = tourists.get(i).getPosy();
                // Distancia entre turistas
                double distance = Math.sqrt(Math.pow(xPosOldTourist-xPosNewTourist,2)
                +Math.pow(yPosOldTourist-yPosNewTourist,2));
                if (distance < this.safetyDistance){
                    flag = false;
                    return flag;
                }
            }
            return flag;
        }
        else{
            return flag;
        }
    }
    
    
}
