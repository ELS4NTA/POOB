package domain;

import java.util.ArrayList;

public class Tablero {
	
	private Casilla[] tablero;
	private Jugador[] jugadores;
	private ArrayList<Ficha> fichas = new ArrayList<Ficha>();
	
	public Tablero(Jugador jugador1, Jugador jugador2) {
		tablero = new Casilla[101];
		jugadores = new Jugador[2];
		jugadores[0] = jugador1;
		jugadores[1] = jugador2;
		fichas.addAll(jugador1.getFichas());
		fichas.addAll(jugador2.getFichas());
		for (int i = 0; i < tablero.length; i++) {
			if (i ==  5 || i == 22 || i == 39 || i == 56) {
				tablero[i] = new Casilla("Salida", i);
			} else if (i==12 || i==17 || i==29 || i==34 || i==46 || i==51 || i==63 || i==68) {
				tablero[i] = new Casilla("Seguro", i);
			} else if (i == 9 || i == 26 || i == 43 || i == 60) {
				tablero[i] = new Casilla("Comodin", i);
			} else {
				tablero[i] = new Casilla("Normal", i);
			}
		}
	}
	
	public boolean comer(Casilla casilla, Jugador jugador) {
		Jugador opuesto = jugadorOpuesto(jugador);
		boolean comio = false;
		Casilla jugada = casilla;
		if (!(jugada.getTipo().equals("Seguro") || jugada.getTipo().equals("Salida"))) {
			if (jugada.catidadFichas() == 2) {
				opuesto.getNido().addFicha(jugada.quitarFicha());
				comio = true;
			}
		}
		return comio;
	}
	
	public Jugador jugadorOpuesto(Jugador jugador) {
		Jugador jugadorOpuesto;
		if (jugador.getIdentificador() == 1) {
			jugadorOpuesto = jugadores[1];
		} else {
			jugadorOpuesto = jugadores[0];
		}
		return jugadorOpuesto;
	}
	
	public Casilla casillaSalida(Jugador jugador) {
		String color = jugador.getColor();
		Casilla salida;
		if (color.equals("Amarillo")) {
			salida = tablero[5];
		} else if (color.equals("Azul")) {
			salida = tablero[22];
		} else if (color.equals("Rojo")) {
			salida = tablero[39];
		} else {
			salida = tablero[56];
		}
		return salida;
	}
	
	public void poneFichaEnCasilla(Casilla casilla, Ficha ficha) {
		casilla.addFicha(ficha);
	}
	
	public Casilla getCasilla(int posicion) {
		return tablero[posicion];
	}
	
	public Casilla siguienteCasilla(Casilla casilla, String color) {
		int posicion = casilla.getPosicion();
		int siguiente;
		if (posicion != 68) {
			siguiente = posicion + 1;
		} else {
			siguiente = 1;
		}
		if (color.equals("Azul") && posicion == 17) {
			siguiente = 69;
		} else if (color.equals("Rojo") && posicion == 34) {
			siguiente = 77;
		} else if (color.equals("Verde") && posicion == 51) {
			siguiente = 85;
		} else if (color.equals("Amarillo") && posicion == 68) {
			siguiente = 91;
		}
		return tablero[siguiente];
	}

}
