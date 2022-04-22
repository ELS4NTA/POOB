package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Casa;
import domain.Jugador;
import domain.Kalah;
import domain.Tablero;

class KalahTest {
	
	Kalah juego;
	
	
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
    	juego = new Kalah(6, 4);
    }
	

	@Test
	public void deberiaSerElJugadorEnTurno() {
		Jugador esperado = juego.getJugador(1);
		Jugador resultado = juego.getJugadorEnTurno();
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void noDeberiaSerElJugadorEnTurno() {
		Jugador esperado = juego.getJugador(1);
		juego.cambiarTurno();
		Jugador resultado = juego.getJugadorEnTurno();
		assertFalse(esperado.equals(resultado));
	}
	
	@Test
	public void deberianHaberSemilasIndicadasEnLaCasa() {
		Tablero tablero = juego.getTablero();
		Jugador jugador1 = juego.getJugador(1);
		int esperado = 24;
		int resultado = tablero.getSemillasEnCampo(jugador1);
		assertTrue(esperado == resultado);
	}
	
	@Test
	public void deberianJugarEIndicarSemilasEnElCampo() {
		Tablero tablero = juego.getTablero();
		Casa casa = tablero.getCasa(2);
		Jugador jugador1 = juego.getJugador(1);
		juego.juego(jugador1, 2);
		int esperado1 = 23;
		int esperado2 = 0;
		int esperado3 = 1;
		int resultado1 = tablero.getSemillasEnCampo(jugador1);
		int resultado2 = casa.getNumSemillas();
		int resultado3 = jugador1.semillasEnElAlmacen();
		assertTrue(esperado1 == resultado1); // Semillas en el campo del jugador 1
		assertTrue(esperado2 == resultado2); // Semillas en la casa jugada
		assertTrue(esperado3 == resultado3); // Semillas en el almacen
		
	}
	
	@Test
	public void deberiaHacerUnaCapturaEnElTablero() {
		Tablero tablero = juego.getTablero();
		Jugador jugador1 = juego.getJugador(1);
		Casa casa = tablero.getCasa(2);
		casa.setNumSemillas(0);
		casa = tablero.getCasa(1);
		casa.setNumSemillas(1);
		juego.juego(jugador1, 1);
		int esperado1 = 5;
		int resultado1 = jugador1.semillasEnElAlmacen();
		int esperado2 = 0;
		casa = tablero.getCasa(10);
		int resultado2 = casa.getNumSemillas();
		assertTrue(esperado1 == resultado1); // Semillas en el alamcen con captura
		assertTrue(esperado2 == resultado2); // Casa que se robo debe estar vacia
	}
	
	@Test
	public void deberiaTenerUnTurnoExtra() {
		Jugador jugador1 = juego.getJugador(1);
		Jugador jugador2 = juego.getJugador(2);
		juego.juego(jugador1, 2);
		assertFalse(jugador2.getTurno()); 
		assertTrue(jugador1.getTurno()); // Repite turno dado que su ultima ficha cayo en el almacen
		
	}
	
	@Test
	public void deberiaSerUnEmpate() {
		Tablero tablero = juego.getTablero();
		tablero.desocuparCasas();
		boolean fin = juego.finDelJuego();
		assertTrue(fin);
		int resultado = juego.ganador();
		int esperado = 0; // El 0 significa que hay un empate
		assertTrue(esperado == resultado);
		
	}
	
	@Test
	public void deberiaGanarElJugador1() {
		Tablero tablero = juego.getTablero();
		Jugador jugador1 = juego.getJugador(1);
		jugador1.addSemillasEnAlmacen(12);
		tablero.desocuparCasas();
		boolean fin = juego.finDelJuego();
		assertTrue(fin);
		int resultado = juego.ganador();
		int esperado = 1; // El 1 significa que gana el jugador 1
		assertTrue(esperado == resultado);
	}
	
	@Test
	public void deberiaGanarElJugador2() {
		Tablero tablero = juego.getTablero();
		Jugador jugador2 = juego.getJugador(2);
		jugador2.addSemillasEnAlmacen(12);
		tablero.desocuparCasas();
		boolean fin = juego.finDelJuego();
		assertTrue(fin);
		int resultado = juego.ganador();
		int esperado = 2; // El 2 significa que gana el jugador 2
		assertTrue(esperado == resultado);
	}
	
    /**
     * Tears down the test fixture.

     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

}
