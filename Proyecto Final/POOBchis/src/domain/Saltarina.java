package domain;

public class Saltarina extends Ficha{

	public Saltarina(String color) {
		super(color);
	}
	
	@Override
	public boolean sePuedeMover(Ficha ficha, int valorAMover, Tablero tablero) {
		Casilla actual = tablero.getCasilla(ficha.getPosicion());
		int llegada = ficha.getLlegada();
		while (valorAMover > 0) {
			if (actual.getPosicion() != llegada) {
				Casilla siguiente = tablero.siguienteCasilla(actual, ficha.getColor());
				actual = siguiente;
			} else {
				return false;
			}
			valorAMover -= 1;
		}
		return true;
	}

}
