package domain;

/**
 * Jugador para el modelo kalah
 * @Autor Angie Mojica - Daniel Santanilla
 * @Version 16-04-22
 * */
public class Jugador {
	
	private int idJugador;
	private boolean enTurno;
	private Casa almacen;
	
	/**
	 * Constructor de un jugador.
	 * @param numeroJugador Numero que se le asigna a un jugador para identificarlo.
	 * @param turno Indica True si el jugador esta en turno, de lo contrario False.
	 * @param almacen Almacen del jugador donde se almacenaran las semillas obtenidas durante el juego.
	 * */
	public Jugador(int numeroJugador, boolean turno, Casa almacen) {
		this.idJugador = numeroJugador;
		this.enTurno = turno;
		this.almacen = almacen;
	}
	
	/**
	 * Obtiene el id del jugador.
	 * @return Entero con el numero del jugador.
	 * */
	public int getIdJugador() {
		return this.idJugador;
	}
	
	/**
	 * Obtiene si el jugador actualmente esta en su turno para jugar,
	 * @return True si el jugador esta en turno, de lo contrario False.
	 * */
	public boolean getTurno() {
		return this.enTurno;
	}
	
	/**
	 * Hace que el jugar este en turno o por el contrario hace que ya no lo este.
	 * @param turno Indica True si el jugador esta en turno, de lo contrario False.
	 * */
	public void setTurno(boolean turno) {
		this.enTurno = turno;
	}
	
	/**
	 * Obtiene el numero de semillas en el almacen del jugador.
	 * @return Entero con la cantidad de semillas en el almacen.
	 * */
	public int semillasEnElAlmacen() {
		return almacen.getNumSemillas();
	}
	
	/**
	 * Annade semillas en el almacen del jugador.
	 * @param nuevasSemillas Semillas que se quieren agregar al almacen.
	 * */
	public void addSemillasEnAlmacen(int nuevasSemillas) {
		almacen.setNumSemillas(almacen.getNumSemillas()+nuevasSemillas);
	}
}
