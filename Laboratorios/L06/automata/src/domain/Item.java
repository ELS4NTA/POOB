package domain;
import java.awt.Color;

/**
 * Representacion de un item para el automata celular
 */
public interface Item {
  int ROUND = 1;
  int SQUARE = 2;

  /**
   * Metodo a implementar que indica el estado de la celula
   */
  void decide();
   
  /**
   * Metodo a implementar que cambia el estado de la celula
   */
  
  default void change(){
  };
  
  /**
   * Metodo a implementar que forma que tomara el bombillo en el automata
   * @return  Entero con el identificador de la forma
   */
  default int shape(){
      return ROUND;
  }
  
  /**
   * Devuelve el color actual de la celula
   * @return color black
   */
  default Color getColor(){
      return Color.black;
  };
  
  /**
   * Indica que la celula esta muerta
   * @return false
   */
  default boolean isAlive(){
      return false;
  }
  
}
