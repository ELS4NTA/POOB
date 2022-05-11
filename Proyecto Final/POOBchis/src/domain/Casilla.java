package domain;

import java.util.ArrayList;

public class Casilla {
	
	private String tipo;
	private ArrayList<Ficha> fichas = new ArrayList<Ficha>();
	private final int posicion; 
	
	public Casilla(String tipo, int posicion) {
		this.tipo = tipo;
		this.posicion = posicion;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String nuevoTipo) {
		this.tipo = nuevoTipo;
	}
	
	public boolean estaBloqueada() {
		return (fichas.size() == 2 ? true : false);
	}
	
	
	public ArrayList<Ficha> getFichas() {
		return this.fichas;
	}
	
	public void addFicha(Ficha ficha) {
		this.fichas.add(ficha);
	}
	
	public Ficha quitarFicha() {
		return this.fichas.remove(0);
	}
	
	public void quitarFicha(Ficha ficha) {
		this.fichas.remove(ficha);
	}
	
	public int catidadFichas() {
		return fichas.size();
	}
	
	public int contarMisFichas(Jugador jugador) {
		String color = jugador.getColor();
		int cantidadFichas = 0;
		for (int i = 0; i < fichas.size(); i++) {
			if (fichas.get(i).getColor().equals(color)) {
				cantidadFichas += 1;
			}
		}
		return cantidadFichas;
	}
	
	public Ficha obtenerFicha(Jugador jugador) {
		String color = jugador.getColor();
		Ficha obtenida = null;
		for (int i = 0; i < fichas.size(); i++) {
			if (fichas.get(i).getColor().equals(color)) {
				obtenida = fichas.get(i);
			}
		}
		return obtenida;
		
	}
	
	public int getPosicion() {
		return this.posicion;
	}
}



















