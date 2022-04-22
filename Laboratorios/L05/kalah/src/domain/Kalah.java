package domain;

/**
 * Clase donde se implementa el juego kalah
 * @Autor Angie Mojica - Daniel Santanilla
 * @Version 16-04-22
 * */
public class Kalah {
	
	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	private int ganador;
	
	/**
	 * Contructor de un kalah, este contiene el tablero de juego y los jugadores del juego
	 * @param numCasas Numero de casas para el tablero.
	 * @param numSemillas Numero de semillas para cada casa.
	 * */
	public Kalah(int numCasas, int numSemillas) {
		this.tablero = new Tablero(numCasas, numSemillas);
		this.jugador1 = new Jugador(1,true,tablero.getCasa(numCasas));
		this.jugador2 = new Jugador(2,false,tablero.getCasa((numCasas*2)+1));
		this.ganador = 0;
	}
	
	/**
	 * Implementacion del juego kalah con las siguientes reglas:
	 * <ol>
	 * <li>Un jugador vacia de semillas de una de sus casas.</li>
	 * Moviendose en sentido contrario a las agujas del reloj, 
	 * poniendo una semilla en cada casa y en el almacen propio, 
	 * nunca en el almacen del oponente.
	 * <li>Si la ultima semilla cae en el almacen del 
	 * jugador, este obtiene un turno adicional.</li>
	 * <li>Si la ultima semilla cae en una casa vacia del
	 * jugador, se apropia de las semillas de la casa que esta al frente.</li>
	 * <li>Cuando un jugador no posee mas semillas en sus casas, el juego acaba</li>
	 * <li>El jugador que gana es el que queda con mas semillas en su almacen.</li>
	 * Tomado de: <A> https://es.wikipedia.org/wiki/Kalah </A>
	 * </ol>
	 * 
	 * @param jugador Jugador en turno que desea realizar la accion sobre una casa.
	 * @param i Casa seleccionada por el jugador para realizar la accion en el juego.
	 * */
	public void juego(Jugador jugador, int i) {
		Casa casa = tablero.getCasa(i);
        int semillas = casa.getNumSemillas();
        casa.setNumSemillas(0);
        while (semillas != 0) {
        	i = tablero.getSiguiente(i);
            casa = tablero.getCasa(i);
            casa.setNumSemillas(casa.getNumSemillas()+1);
            semillas -= 1;
        }
        int semillasCapturadas = tablero.captura(i, jugador);
        jugador.addSemillasEnAlmacen(semillasCapturadas);
        if (finDelJuego()) {
            if (jugador.getIdJugador() == 1) {
            	int total2 = tablero.getSemillasEnCampo(jugador2);
            	jugador2.addSemillasEnAlmacen(total2);
            	
            } else {
            	int total1 = tablero.getSemillasEnCampo(jugador1);
            	jugador1.addSemillasEnAlmacen(total1);
            }
            tablero.desocuparCasas();
            this.ganador = ganador();
		}	
        if (!casa.esAlmacen())
        	cambiarTurno();
	}
	
	/**
	 * Indica si es el final del juego, esto se sabe si
	 *  algun campo de los jugadores esta vacio.
	 *  @return True si el juego ha terminado, es decir, 
	 *  algun campo de los jugadores esta vacio, si no es asi entonces False.
	 * */
	public boolean finDelJuego() {
		int total1 = tablero.getSemillasEnCampo(jugador1);
		int total2 = tablero.getSemillasEnCampo(jugador2);
		return total1 == 0 || total2 == 0;
	}
	
	/**
	 * Obtiene el jugador que esta actualmente en turno
	 * @return Jugador que esta actualmente en turno.
	 * */
	public Jugador getJugadorEnTurno() {
		Jugador enTurno;
		if (jugador1.getTurno()) {
			enTurno = jugador1;
		} else {
			enTurno = jugador2;
		}
		return enTurno;
	}
	
	/**
	 * Cambia el turno al jugador contario
	 * */
	public void cambiarTurno() {
		if (jugador1.getTurno()) {
			jugador1.setTurno(false);
			jugador2.setTurno(true);
		} else {
			jugador2.setTurno(false);
			jugador1.setTurno(true);
		}
	}
	
	/**
	 * Indica el ganador del juego.
	 * <ul>
	 * <li>1: Gana el jugador 1.</li>
	 * <li>2: Gana el jugador 2.</li>
	 * <li>0: Hay un empate.</li>
	 * </ul>
	 * 
	 * @return Entero indicando el ganador del juego, 
	 * o por el contrario si hubo un empate.
	 * */
	public int ganador() {
		if (jugador1.semillasEnElAlmacen() > jugador2.semillasEnElAlmacen()) {
			this.ganador = 1;
		} else if (jugador1.semillasEnElAlmacen() < jugador2.semillasEnElAlmacen()){
			this.ganador = 2;
		} else {
			this.ganador = 0;
		}
		return this.ganador;
	}
	
	public Jugador getJugador(int idJugador) {
		return (idJugador == 1 ? this.jugador1 : this.jugador2);
	}
	
	public Tablero getTablero() {
		return this.tablero;
	}
}
