package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Casilla;
import domain.Ficha;
import domain.Jugador;
import domain.Poobchis;
import domain.PoobchisException;
import domain.Tablero;

public class PoobchisTest {

	private Poobchis juego; 	
	
	@Before
	public void setUp() {
		juego = new Poobchis("Mojica", "Azul", 1, "Santanilla", "Verde");
	}
	
	
	@Test
	public void deberiaObtenerElNombreDelJugadorEnTurno() {
		Jugador enTurno = juego.getJugadorEnTurno();
		String nombre = enTurno.getNombre();
		assertTrue(nombre.equals("Mojica"));
		juego.cambiarTurno();
		enTurno = juego.getJugadorEnTurno();
		nombre = enTurno.getNombre();
		assertTrue(nombre.equals("Santanilla"));
	}
	
	@Test
	public void deberiaObtenerElColorDelJugadorEnTurno() {
		Jugador enTurno = juego.getJugadorEnTurno();
		String color = enTurno.getColor();
		assertTrue(color.equals("Azul"));
		juego.cambiarTurno();
		enTurno = juego.getJugadorEnTurno();
		color = enTurno.getColor();
		assertTrue(color.equals("Verde"));
	}
	
	@Test
	public void deberiaObtenerEldeJuegoConAmbosHumanos() {
		Jugador enTurno = juego.getJugadorEnTurno();
		boolean humano = enTurno.esHumano();
		assertTrue(humano == true);
		juego.cambiarTurno();
		enTurno = juego.getJugadorEnTurno();
		humano = enTurno.esHumano();
		assertTrue(humano == true);
	}
	
	@Test
	public void deberiaMoverUnaFicha() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Ficha sacada = enTurno.getNido().sacarFicha();
		Tablero tablero = juego.getTableroJuego();
		Casilla salidaA = tablero.getCasilla(22);
		sacada.setPosicion(22);
		salidaA.addFicha(sacada);
		try {
			juego.jugar(sacada, 4);	
			assertEquals(26,sacada.getPosicion());
		} catch (PoobchisException pe){
			System.out.println(pe.getMessage());
		}
	}
	
	@Test
	public void deberiaDarElJugadorOpuesto() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Jugador opuesto = tablero.jugadorOpuesto(enTurno);
		assertTrue(opuesto.getNombre().equals("Santanilla"));
	}
	
	@Test
	public void deberiaSerUnBloqueo() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Casilla casilla = tablero.getCasilla(29);
		Ficha sacada1 = enTurno.getNido().sacarFicha();
		Ficha sacada2 = enTurno.getNido().sacarFicha();
		casilla.addFicha(sacada1);
		casilla.addFicha(sacada2);
		assertTrue(casilla.estaBloqueada());
	}
	
	@Test
	public void noDeberiaMoverUnaFicha() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Casilla casillaB = tablero.getCasilla(29);
		Casilla casillaM = tablero.getCasilla(26);
		Ficha sacada1 = enTurno.getNido().sacarFicha();
		Ficha sacada2 = enTurno.getNido().sacarFicha();
		Ficha sacada3 = enTurno.getNido().sacarFicha();
		sacada3.setPosicion(26);
		casillaB.addFicha(sacada1);
		casillaB.addFicha(sacada2);
		casillaM.addFicha(sacada3);
		try {
			juego.jugar(sacada3, 3);
		} catch (PoobchisException pe) {
			assertEquals(PoobchisException.NO_SE_PUEDE_MOVER,pe.getMessage());
		}
	}
	
	@Test
	public void deberiaCapturarFicha() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Jugador opuesto = tablero.jugadorOpuesto(enTurno);
		Casilla casillaC = tablero.getCasilla(26);
		Ficha sacada1 = enTurno.getNido().sacarFicha();
		Ficha sacada2 = opuesto.getNido().sacarFicha();
		sacada1.setPosicion(26);
		sacada2.setPosicion(26);
		casillaC.addFicha(sacada1);
		casillaC.addFicha(sacada2);
		boolean seCome = tablero.comer(casillaC, opuesto);
		assertTrue(seCome);
		assertEquals(4,enTurno.getNido().getFichas().size());
	}
	
	@Test
	public void noDeberiaCapturarFicha() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Jugador opuesto = tablero.jugadorOpuesto(enTurno);
		Casilla casillaC = tablero.getCasilla(46);
		Ficha sacada1 = enTurno.getNido().sacarFicha();
		Ficha sacada2 = opuesto.getNido().sacarFicha();
		sacada1.setPosicion(46);
		sacada2.setPosicion(46);
		casillaC.addFicha(sacada1);
		casillaC.addFicha(sacada2);
		boolean seCome = tablero.comer(casillaC, opuesto);
		assertFalse(seCome);
		assertEquals(3,enTurno.getNido().getFichas().size());
	}
	
	@Test
	public void deberiaObtenerPremioCapturaDeFicha() {
		Jugador enTurno = juego.getJugadorEnTurno();
		juego.cambiarTurno();
		Tablero tablero = juego.getTableroJuego();
		Jugador opuesto = tablero.jugadorOpuesto(enTurno);
		Casilla casillaC = tablero.getCasilla(26);
		Casilla casillaM = tablero.getCasilla(25);
		Ficha sacada1 = enTurno.getNido().sacarFicha();
		Ficha sacada2 = opuesto.getNido().sacarFicha();
		sacada1.setPosicion(26);
		sacada2.setPosicion(25);
		casillaC.addFicha(sacada1);
		casillaM.addFicha(sacada2);
		try {
			juego.jugar(sacada2, 1);
		} catch (PoobchisException pe) {
			assertEquals(PoobchisException.PREMIO_MATAR,pe.getMessage());
			assertEquals(4,enTurno.getNido().getFichas().size());
			
		}
	}
	
	@Test
	public void deberiaObtenerPremioCoronacionDeFicha() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Casilla casillaM = tablero.getCasilla(74);
		Casilla casillaL = tablero.getCasilla(76);
		Ficha sacada1 = enTurno.getNido().sacarFicha();
		sacada1.setPosicion(74);
		casillaM.addFicha(sacada1);
		try {
			juego.jugar(sacada1, 2);
		} catch (PoobchisException pe) {
			assertEquals(PoobchisException.PREMIO_CORONAR,pe.getMessage());
			assertEquals(1,enTurno.getFichasCoronadas());
			assertEquals(0,casillaL.getFichas().size());
		}
	}
	
	@Test
	public void noDeberiaSobrepasarLaCasillaDeCoronacion() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Casilla casillaM = tablero.getCasilla(74);
		Ficha sacada1 = enTurno.getNido().sacarFicha();
		sacada1.setPosicion(74);
		casillaM.addFicha(sacada1);
		try {
			juego.jugar(sacada1, 6);
		} catch (PoobchisException pe) {
			assertEquals(PoobchisException.NO_SE_PUEDE_MOVER,pe.getMessage());
		}
	}
	
	@Test
	public void noDeberiaSobrepasarElLimiteDelTablero() {
		Poobchis juego = new Poobchis("Mojica", "Amarillo", 1, "Santanilla", "Verde");
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Casilla casillaM = tablero.getCasilla(99);
		Ficha sacada1 = enTurno.getNido().sacarFicha();
		sacada1.setPosicion(99);
		casillaM.addFicha(sacada1);
		try {
			juego.jugar(sacada1, 6);
		} catch (PoobchisException pe) {
			assertEquals(PoobchisException.NO_SE_PUEDE_MOVER,pe.getMessage());
		}
	}
	
	@Test
	public void deberiaExistirUnGanador() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Casilla casillaM = tablero.getCasilla(74);
		Ficha sacada1 = enTurno.getNido().sacarFicha();
		sacada1.setPosicion(74);
		casillaM.addFicha(sacada1);
		try {
			enTurno.fichaCoronada();
			enTurno.fichaCoronada();
			enTurno.fichaCoronada();
			juego.jugar(sacada1, 2);
		} catch (PoobchisException pe) {
			assertEquals(PoobchisException.GANADOR,pe.getMessage());
		}
	}
	
	@Test
	public void deberiaSalirConUnaFicha() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Casilla casillaS = tablero.getCasilla(22);
		Ficha aSacar = enTurno.getNido().getFichas().get(0);
		try {
			juego.jugar(aSacar, 5);
			assertEquals(1, casillaS.getFichas().size());
		} catch (PoobchisException pe) {
			System.out.println(pe.getMessage());
		}
	}
	
	@Test
	public void deberiaSalirConUnaFichaDondeHay1EnSalidaMismoColor() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Casilla casillaS = tablero.getCasilla(22);
		Ficha afuera = enTurno.getNido().sacarFicha();
		Ficha aSacar = enTurno.getNido().getFichas().get(0);
		afuera.setPosicion(22);
		casillaS.addFicha(afuera);
		try {
			juego.jugar(aSacar, 5);
			assertEquals(2, casillaS.getFichas().size());
			assertTrue(casillaS.estaBloqueada());
		} catch (PoobchisException pe) {
			System.out.println(pe.getMessage());
		}
	}
	
	@Test
	public void deberiaSalirConUnaFichaDondeHay1EnSalidaDiferenteColor() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Jugador opuesto = tablero.jugadorOpuesto(enTurno);
		Ficha afuera = opuesto.getNido().sacarFicha();
		Casilla casillaS = tablero.getCasilla(22);
		Ficha aSacar = enTurno.getNido().getFichas().get(0);
		afuera.setPosicion(22);
		casillaS.addFicha(afuera);
		try {
			juego.jugar(aSacar, 5);
			assertEquals(2, casillaS.getFichas().size());
			assertTrue(casillaS.estaBloqueada());
		} catch (PoobchisException pe) {
			System.out.println(pe.getMessage());
		}
	}
	
	@Test
	public void deberiaSalirConUnaFichaDondeHay2EnSalidaMismoColor() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Ficha afuera1 = enTurno.getNido().sacarFicha();
		Ficha afuera2 = enTurno.getNido().sacarFicha();
		Casilla casillaS = tablero.getCasilla(22);
		Ficha aSacar = enTurno.getNido().getFichas().get(0);
		afuera1.setPosicion(22);
		afuera2.setPosicion(22);
		casillaS.addFicha(afuera1);
		casillaS.addFicha(afuera2);
		try {
			juego.jugar(aSacar, 5);
		} catch (PoobchisException pe) {
			assertEquals(PoobchisException.MOVIMIENTO_DADO,pe.getMessage());
		}
	}
	
	@Test
	public void deberiaSalirConUnaFichaDondeHay2EnSalidaIntercaladoColor() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Jugador opuesto = tablero.jugadorOpuesto(enTurno);
		Ficha afuera1 = enTurno.getNido().sacarFicha();
		Ficha afuera2 = opuesto.getNido().sacarFicha();
		Casilla casillaS = tablero.getCasilla(22);
		Ficha aSacar = enTurno.getNido().getFichas().get(0);
		afuera1.setPosicion(22);
		afuera2.setPosicion(22);
		casillaS.addFicha(afuera1);
		casillaS.addFicha(afuera2);
		try {
			juego.jugar(aSacar, 5);
		} catch (PoobchisException pe) {
			assertEquals(PoobchisException.PREMIO_MATAR,pe.getMessage());
		}
	}
	
	@Test
	public void deberiaSalirConUnaFichaDondeHay2EnSalidadiferenteColor() {
		Jugador enTurno = juego.getJugadorEnTurno();
		Tablero tablero = juego.getTableroJuego();
		Jugador opuesto = tablero.jugadorOpuesto(enTurno);
		Ficha afuera1 = opuesto.getNido().sacarFicha();
		Ficha afuera2 = opuesto.getNido().sacarFicha();
		Casilla casillaS = tablero.getCasilla(22);
		Ficha aSacar = enTurno.getNido().getFichas().get(0);
		afuera1.setPosicion(22);
		afuera2.setPosicion(22);
		casillaS.addFicha(afuera1);
		casillaS.addFicha(afuera2);
		try {
			juego.jugar(aSacar, 5);
		} catch (PoobchisException pe) {
			assertEquals(PoobchisException.PREMIO_MATAR,pe.getMessage());
		}
	}

}
