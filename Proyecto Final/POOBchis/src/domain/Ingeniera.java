package domain;

public class Ingeniera extends Ficha{

	public Ingeniera(String color) {
		super(color);
	}
	
	@Override
	public Casilla mover(Jugador jugador, Ficha ficha, int valorAMover, Tablero tablero) throws PoobchisException {
		Casilla ultima = super.mover(jugador, ficha, valorAMover, tablero);
		ultima.setTipo("Seguro");
		return ultima;
	}
}
