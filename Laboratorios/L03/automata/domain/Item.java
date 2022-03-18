package domain;
import java.awt.Color;

/*No olviden adicionar la documentacion*/
public interface Item{
  int ROUND = 1;
  int SQUARE = 2;


  void decide();
   
  default void change(){
  };
  
  default int shape(){
      return ROUND;
  }
  
  default Color getColor(){
      return Color.black;
  };
  
  default boolean isAlive(){
      return false;
  }
  
}
