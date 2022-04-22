package domain;

/**
 * Tablero para el modelo kalah
 * @Autor Angie Mojica - Daniel Santanilla
 * @Version 16-04-22
 * */
public class Tablero {
	
	private Casa[] tablero;
	private int numCasas;
	
	/**
	 * Constructor de un tablero teniendo en cuenta el numero de casas 
	 * ademas de las semillas para cada casa.
	 * @param numCasas Numero de casas para el tablero.
	 * @param numSemillas Numero de semillas para cada casa.
	 * */
	public Tablero(int numCasas, int numSemillas) {
		this.tablero = new Casa[(numCasas*2)+2];
		for (int i = 0; i < tablero.length; i++) {
			if (i != numCasas && i != tablero.length-1) {
				tablero[i] = new Casa(numSemillas, false);
			} else {
				tablero[i] = new Casa(0, true);
			}
		}
		this.numCasas = numCasas;
	}
	
	/**
	 * Obtiene del tablero la casa especificada segun el indice dado
	 * @return Casa del indice especificado.
	 * */
	public Casa getCasa(int i) {
		return tablero[i];
	}
	
	/**
	 * Obtiene el siguiente indice del especificado por parametro.
	 * @param i Indice del tablero.
	 * @return Entero con el siguiente indice en el tablero, 
	 * de ser el ultimo indice se tomara el siguiente como cero.
	 * */
	public int getSiguiente(int i) {
		int siguiente;
		if (i == tablero.length-1) {
			siguiente = 0;
		} else {
			siguiente = i + 1;
		}
		return siguiente;
	}
	
	/**
	 * Obtiene las semillas que tiene un jugador en su campo.
	 * @param jugador Jugador al que se le quiere obter la cantidad de semillas en su campo.
	 * @return Entero con la cantidad de semillas en el campo del jugador especificado.
	 * */
	public int getSemillasEnCampo(Jugador jugador) {
		int semillasTotales = 0;
		if (jugador.getIdJugador() == 1) {
			for (int i = 0; i < numCasas; i++) {
				Casa casa = this.tablero[i];
				semillasTotales += casa.getNumSemillas();
			}
		} else {
			for (int i = numCasas; i < tablero.length; i++) {
				Casa casa = this.tablero[i];
				if (!casa.esAlmacen()) {
					semillasTotales += casa.getNumSemillas();
				}
			}
		}
		return semillasTotales;
	}
	
	/**
	 * Hace una captura de las semillas de una casa solo si la ultima semilla jugada
	 * esta en el campo del jugador en turno y esta no es el almacen del jugador
	 * @param jugador Jugador que va a hacer la captura de las semillas.
	 * @return Entero con la cantidad de semillas capturadas por el jugador.
	 * */
	public int captura(int i, Jugador jugador) {
		int semillasGanadas = 0;
		Casa casa = tablero[i];
		if (!casa.esAlmacen()) {
			if (casa.getNumSemillas() == 1 && misCasas(i, jugador)) {
				Casa opuesto = tablero[i+numCasas+2];
				semillasGanadas = opuesto.getNumSemillas()+casa.getNumSemillas();
				opuesto.setNumSemillas(0);
				casa.setNumSemillas(0);
			}
		}
		
		return semillasGanadas;
	}
	
	/**
	 * Afirma si una casa esta en el campo del jugador.
	 * @param i Indice de la casa que se quiere verificar.
	 * @param jugador Jugador para verificar el campo.
	 * @return True si la casa del con el indice indicado pertenece al campo del jugador,
	 * si esta no pertenece entonces False.
	 * */
	public boolean misCasas(int i, Jugador jugador) {
		boolean esMiVecindario = false;
		if (jugador.getIdJugador()==1) {
			if (i <= numCasas) {
				esMiVecindario = true;
			}
		} else {
			if (i > numCasas) {
				esMiVecindario = true;
			}
		}
		return esMiVecindario;
		
	}
	
	/**
	 * Desocupa todas las casas del tablero excepto el almacen, es decir,
	 * hace todas las semillas de las casas cero. 
	 * */
	public void desocuparCasas() {
		for (Casa casa : tablero) {
			if (!casa.esAlmacen()) {
				casa.setNumSemillas(0);
			}
		}
	}
}
