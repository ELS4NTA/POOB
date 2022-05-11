package domain;

public class Ficha {
	
	protected String color;
	protected int posicion;
	protected final int meta;
	protected final int llegada;
	
	public Ficha(String color) {
		if (color.equals("Azul")) {
			this.meta = 17;
			this.llegada = 76;
		} else if (color.equals("Rojo")) {
			this.meta = 34;
			this.llegada = 84;
		} else if (color.equals("Verde")) {
			this.meta = 51;
			this.llegada = 92;
		} else {
			this.meta = 68;
			this.llegada = 100;
		}
		this.color = color;
		this.posicion = 0;
	}
	
	public Casilla mover(Jugador jugador, Ficha ficha, int valorAMover, Tablero tablero) throws PoobchisException {
		Casilla actual = tablero.getCasilla(ficha.getPosicion());
		if (!jugador.getNido().contieneFicha(ficha)) {
			if (!jugador.getColor().equals(ficha.getColor())) {
				throw new PoobchisException(PoobchisException.NO_ES_TU_FICHA);
			}
			if (sePuedeMover(ficha, valorAMover, tablero)) {
				while (valorAMover > 0) {
					Casilla siguiente = tablero.siguienteCasilla(actual, ficha.getColor());
					actual.quitarFicha(ficha);
					ficha.setPosicion(siguiente.getPosicion());
					siguiente.addFicha(ficha);
					actual = siguiente;
					valorAMover -= 1;
				}
			} else {
				throw new PoobchisException(PoobchisException.NO_SE_PUEDE_MOVER);
			}
		}
		return actual;
	}
	
	public boolean sePuedeMover(Ficha ficha, int valorAMover, Tablero tablero) {
		Casilla actual = tablero.getCasilla(ficha.getPosicion());
		int llegada = ficha.getLlegada();
		while (valorAMover > 0) {
			if (actual.getPosicion() != llegada) {
				Casilla siguiente = tablero.siguienteCasilla(actual, ficha.getColor());
				if (!siguiente.estaBloqueada()) {
					actual = siguiente;
				} else {
					return false;
				}
			} else {
				return false;
			}
			valorAMover -= 1;
		}
		return true;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	public int getPosicion() {
		return this.posicion;
	}
	
	public int getMeta() {
		return this.meta;
	}
	
	public int getLlegada()  {
		return this.llegada;
	}
}
