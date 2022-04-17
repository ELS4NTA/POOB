package domain;

/**
 * Casa para el modelo kalah
 * @Autor Angie Mojica - Daniel Santanilla
 * @Version 16-04-22
 * */
public class Casa {
	
	private int numSemillas;
	private boolean vacio;
	private boolean esAlmacen;
	
	/**
	 * Constructor de una casa.
	 * @param semillas Numero de semillas que tiene inicialmente la casa.
	 * @param almacen Indica si la casa es un almacen.
	 * */
	public Casa(int semillas, boolean almacen) {
		this.numSemillas = semillas;
		this.vacio = false;
		this.esAlmacen = almacen;
	}
	
	/**
	 * Indica si la casa es un almacen.
	 * @return True si la casa es un almacen, de lo contrario false.
	 * */
	public boolean esAlmacen() {
		return this.esAlmacen;
	}
	
	/**
	 * Se indica si la casa es vacia.
	 * @param vacio True si la casa esta vacia, de lo contrario False.
	 * */
	public void estaVacia(boolean vacio) {
		this.vacio = vacio;
	}
	
	/**
	 * Determina si la casa esta vacia o no.
	 * @return True si la casa esta vacia, de lo contrario False.
	 * */
	public boolean esVacia() {
		return this.vacio;
	}
	
	/**
	 * Obtiene el numero de semillas en la casa.
	 * @return Entero con la cantidad se semillas en la casa.
	 * */
	public int getNumSemillas() {
		return this.numSemillas;
	}
	
	/**
	 * Actualiza el numero de semillas en la casa.
	 * @param nuevasSemillas Nuevo numero de semillas en la casa.
	 * */
	public void setNumSemillas(int nuevasSemillas) {
		this.numSemillas = nuevasSemillas;
	}
}
