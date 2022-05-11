package domain;

public class PoobchisException  extends Exception {
	public static final String NO_ES_TU_FICHA = "No es tu Ficha"; 
	public static final String NO_SE_PUEDE_MOVER = "No se Puede Mover";
	public static final String FICHA_EN_CARCEL = "Ficha en la carcel";
	public static final String PREMIO_MATAR = "Obtiene +20 Movimientos";
	public static final String PREMIO_CORONAR = "Obtiene +10 Movimientos";
	public static final String MOVIMIENTO_DADO = "Debe Jugar Con el Valor de los Dados";
	public static final String GANADOR = "Hay Ganador";
	
	public PoobchisException(String message) {
		super(message);
	}
	
}
