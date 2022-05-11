package domain;

import java.util.ArrayList;

public class Carcel {
	
	private ArrayList<Ficha> fichas = new ArrayList<Ficha>();
	
	public Carcel(ArrayList<Ficha> fichasJugador) {
		for (Ficha ficha : fichasJugador)  {
			fichas.add(ficha);
		}
		
	}
	
	public ArrayList<Ficha> getFichas() {
		return this.fichas;
	}
	
	public void addFicha(Ficha nuevaFicha) {
		fichas.add(nuevaFicha);
	}
	
	public boolean contieneFicha(Ficha ficha) {
		return fichas.contains(ficha);
	}
	
	public Ficha sacarFicha() {
		Ficha ficha = fichas.get(0);
		fichas.remove(0);
		return ficha;
	}
	
	public boolean estaVacia() {
		return fichas.isEmpty();
	}
	
	public int getTamanno() {
		return fichas.size();
	}
}
