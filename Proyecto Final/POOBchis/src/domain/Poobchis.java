package domain;

import java.util.ArrayList;

public class Poobchis {
	
	private Tablero tablero;
	private Jugador[] jugadores;
	int contadorPares = 0;
	
	public Poobchis(String nombre1, String color1, int modo, String nombre2, String color2) {
		jugadores = new Jugador[2];
		Jugador jugador1;
		Jugador jugador2;
		if (modo == 1) {
			jugador1 = new Jugador(nombre1,color1,true,1,true);
			jugador2 = new Jugador(nombre2,color2,true,2,false);
		} else {
			jugador1 = new Jugador(nombre1,color1,true,1,true);
			jugador2 = new Jugador("Maquina",color2,false,2,false);
		}
		jugadores[0] = jugador1;
		jugadores[1] = jugador2;
		tablero = new Tablero(jugador1,jugador2);
	}
	
	public int[] lanzarDados(Jugador jugador) {
		int[] valorDados = jugador.lanzarDados();
		return valorDados;
	}
	

	
	public void jugar(Ficha ficha,int valorDado) throws PoobchisException {
		Jugador jugador = getJugadorEnTurno();
		ArrayList<Ficha> fichas = jugador.getFichas();
		ArrayList<Ficha> enCarcel = jugador.getNido().getFichas();
		if (!fichas.contains(ficha)) {
			throw new PoobchisException(PoobchisException.NO_ES_TU_FICHA);
		}
		if (valorDado == 5) {
			if (!jugador.getNido().estaVacia()) {
				sacarFicha(jugador);
			} else {
				Casilla ultima = ficha.mover(jugador, ficha, valorDado, tablero);
				if (tablero.comer(ultima, jugador)) {
					movimientosExtra(true, false);
				}
				if (ultima.equals(tablero.getCasilla(ficha.getLlegada()))) {
					jugador.fichaCoronada();
					ultima.quitarFicha(ficha);
					ganador();
					movimientosExtra(false, true);
				}
			}
		} else {
			if(enCarcel.contains(ficha)) {
				throw new PoobchisException(PoobchisException.FICHA_EN_CARCEL);
			}
			Casilla ultima = ficha.mover(jugador, ficha, valorDado, tablero);
			if (tablero.comer(ultima, jugador)) {
				movimientosExtra(true, false);
			}
			if (ultima.equals(tablero.getCasilla(ficha.getLlegada()))) {
				jugador.fichaCoronada();
				ultima.quitarFicha(ficha);
				ganador();
				movimientosExtra(false, true);
			}
		}
	}
	
	public boolean esPar(int[] valorDados) {
		return ( valorDados[0] == valorDados[1] ? true: false);
	}
	
	public void castigoTriplePar(Jugador jugador, Ficha ficha) {
		jugador.getNido().addFicha(ficha);
	}
	
	public void sacarFicha(Jugador jugador) throws PoobchisException {
		Casilla salida = tablero.casillaSalida(jugador);
		Jugador oponente = tablero.jugadorOpuesto(jugador);
		Ficha sacada;
		int cantFichas = salida.contarMisFichas(jugador);
		if (salida.catidadFichas() <= 1) {
			sacada = jugador.getNido().sacarFicha();
			sacada.setPosicion(salida.getPosicion());
			salida.addFicha(sacada);
		} else if (salida.catidadFichas() == 2) {
			if (cantFichas == 2) {
				movimientosExtra(false,false);
			} else {
				Ficha aMatar = salida.obtenerFicha(oponente);
				salida.quitarFicha(aMatar);
				oponente.getNido().addFicha(aMatar);
				sacada = jugador.getNido().sacarFicha();
				sacada.setPosicion(salida.getPosicion());
				salida.addFicha(sacada);
				movimientosExtra(true,false);
			}
		} 
	}
	
	public void movimientosExtra(boolean seCome, boolean seCorona) throws  PoobchisException{
		if (seCome) {
			throw new PoobchisException(PoobchisException.PREMIO_MATAR);
		} else if (seCorona) {
			throw new PoobchisException(PoobchisException.PREMIO_CORONAR);
		} else {
			throw new PoobchisException(PoobchisException.MOVIMIENTO_DADO);
		}
	}
	
	public void cambiarTurno() {
		Jugador jugador1 = jugadores[0]; 
		Jugador jugador2 = jugadores[1];
		if (jugador1.estaEnTurno()) {
			jugador1.setTurno(false);
			jugador2.setTurno(true);
		} else {
			jugador2.setTurno(false);
			jugador1.setTurno(true);
		}
	}
	
	public Jugador getJugadorEnTurno() {
		Jugador enTurno;
		if (jugadores[0].estaEnTurno()) {
			enTurno = jugadores[0];
		} else {
			enTurno = jugadores[1];
		}
		return enTurno;
	}
	
	public boolean algunaSeMueve(Jugador jugador, int[] valoresDados) {
		ArrayList<Ficha> fichas = jugador.getFichas();
		for (Ficha ficha : fichas) {
			for (int j = 0; j < valoresDados.length; j++) {
				if (ficha.sePuedeMover(ficha, valoresDados[j], tablero)) {
					return true;
				} 
			}
		}
		return false;	
	}
	
	public void ganador() throws PoobchisException {
		if (getJugadorEnTurno().getFichasCoronadas() == 4) {
			throw new PoobchisException(PoobchisException.GANADOR);
		}
	}
	
	public Tablero getTableroJuego() {
		return this.tablero;
	}
	
}