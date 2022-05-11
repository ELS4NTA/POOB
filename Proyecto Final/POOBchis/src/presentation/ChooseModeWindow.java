package presentation;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import domain.Poobchis;

public class ChooseModeWindow extends JPanel{
	
	private CardLayout card;
	private POOBchisGUI gui;
	private Poobchis currentGame;
	private JPanel principal;
	private JLabel fondoCMW, titulo, imagenHumano, imagenMaquina;
	private JButton humano, maquina;
	private PaintPicture impresora; 
	
	
	public ChooseModeWindow(POOBchisGUI gui, Poobchis game) {
		this.gui = gui;
		currentGame = game;
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
		fondoCMW = new JLabel();
		fondoCMW.setVisible(true);
		titulo = new JLabel();
		imagenHumano = new JLabel();
		imagenMaquina = new JLabel();
		humano = new JButton("JUGADOR VS JUGADOR");
		maquina = new JButton("JUGADOR VS MAQUINA");
		
	}
	
	private void prepareSizes() {
		fondoCMW.setBounds(0, 0, 1080, 720);
		titulo.setBounds(200, 40, 701, 199);
		imagenHumano.setBounds(230, 350, 197, 100);
		imagenMaquina.setBounds(660, 350, 197, 100);
		humano.setBounds(250, 500, 150, 80);
		maquina.setBounds(680,500,150, 80);
	}
	
	private void prapareImages() {
		impresora.pintarImagen(fondoCMW, "./img/fondoPrincipal.jpg", 1080, 720);
		impresora.pintarImagen(titulo, "./img/modotitulo.png", 701, 199);
		impresora.pintarImagen(imagenHumano, "./img/humanos.png", 197, 100);
		impresora.pintarImagen(imagenMaquina, "./img/maquina.png", 197, 100);
		repaint();
	}
	
	private void addComponents() {
		fondoCMW.add(titulo);
		fondoCMW.add(imagenHumano);
		fondoCMW.add(imagenMaquina);
		fondoCMW.add(humano);
		fondoCMW.add(maquina);
		principal.add(fondoCMW,"FondoCMW");
	}
	
	private void prepareActions() {
		humano.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionGameHumans();
				} 
		});
		maquina.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionGameBot();
				} 
		});
	}

	public void actionGameHumans() {
		card.show(principal, "FondoCW");
	}
	
	public void actionGameBot() {
		card.show(principal, "HumanoVSBot");
	}

	
	
	
	
}
