import java.util.HashMap;

/** SetCalculator.java
 * 
 * @author ESCUELA 2022-01
 */
    
public class SetCalculator{
    
    private HashMap<String,Set> variables;
    private boolean operationComplete;
    
    /**
     * Constructor de la calculadora
     */
    public SetCalculator(){
        this.variables = new HashMap<String,Set>();
    }
    
    public HashMap<String,Set> getVariables(){
        return this.variables;
    }
    
    //Create a new variable
    /**
     * Crea una key en el HashMap
     * @param nombre Nombre de la variable
     */
    public void create(String nombre){
        this.variables.put(nombre,null);
    }
     
    //Create and assign a set to an existing variable
    //a := set
    /**
     * Crea y asigna un conjunto a una variable existente
     * @param set Una key del HashMap
     * @param elements Array de creacion del conjunto
     */
    public void assign(String set, String[] elements ){
        Set newSet = new Set(elements);
        this.variables.putIfAbsent(set,newSet);
    }    
    
    /**
     * Consulta de conjuntos asignados
     * @param set Una key del HashMap
     * @return mensaje Un mensaje al usuario referente a la consulta
     */
    public String query(String set){
        if (!this.variables.isEmpty()){
            if (this.variables.get(set) != null){
                return this.variables.get(set).toString();
            }
            else{
                return "No hay un conjunto asignado a esta variable.";
            }
        }
        else{
            return "Aun no hay variables asignadas.";
        }
    }
    
    /**
     * Pertenencia de un elemento al conjunto en una variable existente
     * @param a Key en el HashMap
     * @param element Elemento para evaluar su pertenencia en el conjunto
     * @retun True si element esta en el conjunto, de lo contrario False
     */
    public boolean pertenece(String a, String element){
        if (this.variables.get(a) != null){
            return this.variables.get(a).contains(element);
        }
        return false;
    }
    
    //Assign the result of an operation to an existing variable
    // a = b op c
    //The operator characters are:  'u' union, 'i' intersection, '-' difference, '_' symmetric difference, 'x' cartesian product
    /**
     * Asigna el resultado de la operacion a una variable existente
     * @param a Variable existente en el HashMap
     * @param b Variable existente en el HashMap
     * @param op Caracter para realizar la operacion entre conjuntos
     * @param c Variable existente en el HashMap
     */
    public void assign(String a, String b, char op, String c){
        Set setA = new Set();
        Set setB = new Set();
        Set operationSet = new Set();
        if (variables.get(b) != null && variables.get(c) != null){
            setA = variables.get(b);
            setB = variables.get(c);
        }
        else if (variables.get(b) != null){
            setA = variables.get(b); // La variable b no tiene conjunto asignado pero la c si
        }
        else if (variables.get(c) != null){
            setB = variables.get(c); // La variable c no tiene conjunto asignado pero la b si
        }
        
        
        if (op == 'u'){
            operationSet = setA.union(setB);
        }
        else if (op == 'i'){
            operationSet = setA.intersection(setB);
        }
        else if (op == '-'){
            operationSet = setA.difference(setB);
        }
        else if (op == '_'){
            operationSet = setA.symmetricDifference(setB);
        }
        else if (op == 'x'){
            operationSet = setA.cartesianProduct(setB);
        }
        this.create(a);
        this.variables.putIfAbsent(a,operationSet);
        this.operationComplete = true;
        this.ok();
    }
  
    
    //Returns the values of a set
    /**
     * Cadena del conjunto con una variable especificada
     * @param variable Key del HashMap
     * @return cadena Conjunto convertido a String
     */
    public String toString(String variable){
        String cadena = "";
        if (variables.get(variable) != null){
            cadena = variables.get(variable).toString();
        }
        return cadena;
    }
    
    
    //If the last operation was done
    /**
     * Dice si la calculadora pudo realizar la operacion indicada
     * @return boolean: operationComplete
     */
    public boolean ok(){
        return this.operationComplete;
    }
}
    



