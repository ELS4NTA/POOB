package domain;

import java.util.ArrayList;

public class Jugador {
	
	private int identificador;
	private boolean esHumano;
	private boolean enTurno;
	private String color;
	private String nombre;
	private int fichasCoronadas;
	private ArrayList<Ficha> fichas = new ArrayList<Ficha>();
	private Carcel nido;
	
	public Jugador(String nombre, String color, boolean humano, int identi, boolean turno) {
		this.esHumano = humano;
		this.enTurno = turno;
		this.identificador = identi;
		this.color = color;
		this.fichasCoronadas = 0;
		this.nombre = nombre;
		for (int i = 0; i < 4; i++) {
			fichas.add(new Ficha(color));
		}
		this.nido = new Carcel(fichas);
		
	}
	
	public boolean esHumano() {
		return this.esHumano;
	}
	
	public void fichaCoronada() {
		this.fichasCoronadas = this.fichasCoronadas + 1;
	}
	
	public int  getFichasCoronadas() {
		return this.fichasCoronadas;
	}
	
	public boolean estaEnTurno() {
		return this.enTurno;
	}
	
	public void setTurno(boolean turno) {
		this.enTurno = turno;
	}
	
	public int getIdentificador() {
		return this.identificador;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public Carcel getNido() {
		return this.nido;
	}
	
	public ArrayList<Ficha> getFichas() {
		return this.fichas;
	}
	
	public int[] lanzarDados() {
		int[] valorEnDados = new int[2];
		int valorDado1 = (int)(Math.random()*6+1);
		int valorDado2 = (int)(Math.random()*6+1);
		valorEnDados[0] = valorDado1;
		valorEnDados[1] = valorDado2;
		return valorEnDados;
	}
	
}
