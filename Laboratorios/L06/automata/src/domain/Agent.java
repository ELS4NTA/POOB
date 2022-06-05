package domain;
import java.awt.Color;
import java.io.Serializable;

/**
 * Representacion de un agente que interactua en el automata.
 * @Autor Angie Mojica - Daniel Santanilla
 * @Version 0.2
 */
public abstract class Agent implements Serializable {
    
    public final static char UNKNOWN='u', ALIVE='a', DEAD='d';
    protected char state;
    protected int shape;
    private int age;

    /**
     * Create a new agent
     */
    public Agent(){
        state=UNKNOWN;
        age=0;
    }

    /**
     * The agent turns one life span old
     */
    protected void turn(){
        age++;
    }    
    
     /**
      * Returns the age
      *  @return age edad del agente
     */   
    public final int getAge(){
        return age;
    }    

    /**
     * Estado del agente
     * @return true, if ALIVE; false, otherwise
     */
    public final boolean isAlive(){
        return (state == Agent.ALIVE) ;
    }
}
