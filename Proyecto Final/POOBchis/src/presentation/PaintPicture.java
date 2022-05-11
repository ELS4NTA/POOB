package presentation;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PaintPicture {
	
	public static PaintPicture printer;
	
	public PaintPicture() {
		
	}
	
	public static PaintPicture getPrinter( ) {
		printer = new PaintPicture();
		return printer;
	}
	
	public void pintarImagen(JLabel label, String ruta, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(ruta);
		ImageIcon icon = new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		label.setIcon(icon);
		//repaint();
	}
}
