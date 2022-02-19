import java.util.*;
/**
 * Conjuntos con operaciones.
 * 
 * @author Angie Mojica - Daniel Santanilla
 * @version 0.0.1
 */
public class Set {
    private ArrayList<String> data;
    // realizar pruebas de las operaciones
    // realizar pruebas de las operaciones
    // realizar pruebas de las operaciones
    // realizar pruebas de las operaciones
    // realizar pruebas de las operaciones
    // realizar pruebas de las operaciones
    // realizar pruebas de las operaciones
    // realizar pruebas de las operaciones
    // realizar pruebas de las operaciones
    // realizar pruebas de las operaciones
    /**
     * Constructor de la clase Set sin parametros
     */
    public Set(){
        this.data = new ArrayList<String>();
    }
    
    /**
     * Constructor de la clase Set con parametros
     * @param elements Array de cadenas
     */
    public Set(String[] elements){
        if (elements.length != 0){
            this.data = new ArrayList<String>();
            for (int i=0;i<elements.length;i++){
                String element = elements[i].toUpperCase();
                if(!this.contains(element)){
                    this.data.add(element);
                }
            }
        }
        else{
            this.data = new ArrayList<String>();
        }
    }
    
    // Return Set elements
    /**
     * Devuelve los datos existentes en Set
     * @return ArrayList: data
     */
    public ArrayList<String> getData(){
        return this.data;
    }
    
    //Return (this union a)
    /**
     * Operacion de union entre conjuntos
     * @param a Conjunto a operar
     * @return unionSet Conjunto de la union
     */
    public Set union(Set a){
        Set unionSet = new Set();
        for (int i=0;i<this.size();i++) {
            String element = this.getData().get(i);
            unionSet.getData().add(element);
        }
        
        for (int i=0;i<a.size();i++) {
            String element = a.getData().get(i);
            if (!this.contains(element)) {
                unionSet.getData().add(element);
            }
        }
        return unionSet;
    }
    
    /**
     * Operacion de interseccion entre conjuntos
     * @param a Cojunto a operar
     * @return intersectionSet Conjunto de la interseccion
     */
    public Set intersection(Set a){
        Set intersectionSet = new Set();
        for (int i=0;i<a.size();i++) {
            String element = a.getData().get(i);
            if (this.contains(element)) {
                intersectionSet.getData().add(element);
            }
        }
        return intersectionSet;
    }
    
    /**
     * Operacion de diferencia entre conjuntos
     * @param a Conjunto a operar
     * @return differenceSet Conjunto de la diferencia
     */
    public Set difference(Set a){
        Set differenceSet = new Set();
        for (int i=0;i<this.size();i++) {
            String element = this.getData().get(i);
            if (!a.getData().contains(element)) {
                differenceSet.getData().add(element);
            }
        }
        return differenceSet;
    }
    
    
    /**
     * Operacion de diferencia simetrica entre conjuntos
     * @param b Conjunto a operar
     * @return symmetricdifSet Conjunto de la diferencia simetrica
     */
    public Set symmetricDifference(Set b){
        Set symmetricdifSet = new Set();
        Set setAdifsetB = this.difference(b);
        Set setBdifsetA = b.difference(this);
        symmetricdifSet = setAdifsetB.union(setBdifsetA);
        return symmetricdifSet;
    }
    
    /**
     * Operacion de producto cartesiano entre conjuntos
     * @param b Conjunto a operar
     * @return cartesianProdfSet Conjunto del producto cartesiano
     */
    public Set cartesianProduct(Set b){
        Set cartesianProdfSet = new Set();
        for (int i=0;i<this.size();i++){
            for (int j=0;j<b.size();j++){
                cartesianProdfSet.getData().add( "("+ this.getData().get(i) +","+ b.getData().get(j) +")");
            }
        }
        return cartesianProdfSet;
    }
    
    // Return Set size
    /**
     * Tamaño de los datos existentes en Set
     * @return int: size
     */
    public int size(){
        return this.data.size();
    }
    
    // Element is contain in Set?
    /**
     * Define si un elemento esta contenido en los datos de Set
     * @param element Cadena de caracteres
     * @return True si el elemento esta en el Set, de lo contrario False
     */
    public boolean contains(String element){
        for (int i=0;i<this.size();i++){
            if (this.data.get(i).equals(element)){
                return true;
            }
        }
        return false;
    }
    
    // Equals Sets
    /**
     * Compara si dos Sets son iguales
     * @param a Conjunto a comparar
     * @return True si los Sets son iguales, de lo contrario False
     */
    public boolean equals(Set a){
        if (a.size() != 0 ){
            for (int i=0;i<a.size();i++){
                if (this.contains(a.getData().get(i))==false){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean equals(Object a){
        return equals((Set) a);
    }
    
    // Convert to String data Set
    /**
     * Convierte a String los datos de Set
     * @return cadena Cadena de caracteres con los datos de Set
     */
    public String toString() {
        String cadena = "{";
        if (this.size() != 0){
            for (int i=0;i<this.size()-1;i++){
                cadena += this.data.get(i).toUpperCase()+",";
            }
            cadena += this.data.get(this.size()-1).toUpperCase();
        }
        cadena += "}";
        return cadena;
    }
}
