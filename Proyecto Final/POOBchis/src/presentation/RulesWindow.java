package presentation;

import java.awt.CardLayout;

import javax.swing.*;

import domain.Poobchis;

public class RulesWindow extends JPanel{
	
	private CardLayout card;
	private POOBchisGUI gui;
	private JPanel principal;
	private JLabel fondoRW;
	private PaintPicture impresora;
	
	public RulesWindow(POOBchisGUI gui) {
		this.gui = gui;
		card = gui.getCard();
		principal = gui.getPrincipal();
		impresora = PaintPicture.getPrinter();
		prepareElements();
		prepareSizes();
		prapareImages();
		addComponents();
		prepareActions();
	}

	private void prepareElements() {
		fondoRW = new JLabel();
		fondoRW.setVisible(true);
		
		
	}

	private void prepareSizes() {
		fondoRW.setBounds(0, 0, 1080, 720);
		
	}

	private void prapareImages() {
		impresora.pintarImagen(fondoRW, "./img/fondoPrincipal.jpg", 1080, 720);
		
	}

	private void addComponents() {
		principal.add(fondoRW, "FondoRW");
		
	}

	private void prepareActions() {
		// TODO Auto-generated method stub
		
	}
}
