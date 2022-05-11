package presentation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Poobchis;

public class ConfigurationWindow extends JPanel{
	
	private CardLayout card;
	private POOBchisGUI gui;
	private Poobchis currentGame;
	private JPanel principal;
	private JTextField nombre1, nombre2;
	private JLabel fondoCW, titulo, jugador1, jugador2, lnombre1, lnombre2, lcolor1, lcolor2;
	private JButton colorA1, colorZ1, colorR1, colorV1, colorA2,  colorZ2, colorR2, colorV2, iniciar;
	private PaintPicture impresora;
	private String nombreJ1, nombreJ2, colorJ1, colorJ2;
	
	public ConfigurationWindow(POOBchisGUI gui, Poobchis game) {
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
		fondoCW = new JLabel();
		titulo = new JLabel();
		jugador1 = new JLabel();
		jugador2 = new JLabel();
		lnombre1 = new JLabel("Nombre:");
		lnombre2 = new JLabel("Nombre:");
		lcolor1 = new JLabel("Color:");
		lcolor2 = new JLabel("Color:");
		nombre1 = new JTextField();
		nombre2 = new JTextField();
		colorA1 = new JButton();
		colorZ1 = new JButton();
		colorR1 = new JButton();
		colorV1 = new JButton();
		colorA2 = new JButton();
		colorZ2 = new JButton();
		colorR2 = new JButton();
		colorV2 = new JButton();
		iniciar = new JButton("INICIAR");
	}

	private void prepareSizes() {
		titulo.setBounds(200, 0, 667, 200);
		jugador1.setBounds(100, 200, 239, 89);
		jugador2.setBounds(700, 200, 256, 91);
		nombre1.setBounds(100, 300, 239, 30);
		nombre2.setBounds(700, 300, 256, 30);
		lnombre1.setBounds(15, 300, 100, 30);
		lnombre2.setBounds(615, 300, 100, 30);
		lnombre1.setFont(new Font("arial",1,20));
		lnombre2.setFont(new Font("arial",1,20));
		lnombre1.setForeground(Color.WHITE);
		lnombre2.setForeground(Color.WHITE);
		lcolor1.setBounds(15, 350, 100, 30);
		lcolor2.setBounds(615, 350, 100, 30);
		lcolor1.setFont(new Font("arial",1,20));
		lcolor2.setFont(new Font("arial",1,20));
		lcolor1.setForeground(Color.WHITE);
		lcolor2.setForeground(Color.WHITE);
		colorA1.setBounds(100, 350, 30, 30);
		colorZ1.setBounds(140, 350, 30, 30);
		colorR1.setBounds(180, 350, 30, 30);
		colorV1.setBounds(220, 350, 30, 30);
		colorA1.setBackground(Color.YELLOW);
		colorZ1.setBackground(Color.BLUE);
		colorR1.setBackground(Color.RED);
		colorV1.setBackground(Color.GREEN);
		colorA2.setBounds(700, 350, 30, 30);
		colorZ2.setBounds(740, 350, 30, 30);
		colorR2.setBounds(780, 350, 30, 30);
		colorV2.setBounds(820, 350, 30, 30);
		colorA2.setBackground(Color.YELLOW);
		colorZ2.setBackground(Color.BLUE);
		colorR2.setBackground(Color.RED);
		colorV2.setBackground(Color.GREEN);
		iniciar.setBounds(350, 500, 300, 60);
	}

	private void prapareImages() {
		impresora.pintarImagen(fondoCW, "./img/fondoPrincipal.jpg", 1080, 720);
		impresora.pintarImagen(titulo, "./img/configuracion.png", 677, 200);
		impresora.pintarImagen(jugador1, "./img/jugador1.png", 239, 89);
		impresora.pintarImagen(jugador2, "./img/jugador2.png", 256, 91);
		
	}

	private void addComponents() {
		fondoCW.add(titulo);
		fondoCW.add(jugador1);
		fondoCW.add(jugador2);
		fondoCW.add(nombre1);
		fondoCW.add(nombre2);
		fondoCW.add(lnombre1);
		fondoCW.add(lnombre2);
		fondoCW.add(lcolor1);
		fondoCW.add(lcolor2);
		fondoCW.add(colorA1);
		fondoCW.add(colorZ1);
		fondoCW.add(colorR1);
		fondoCW.add(colorV1);
		fondoCW.add(colorA2);
		fondoCW.add(colorZ2);
		fondoCW.add(colorR2);
		fondoCW.add(colorV2);
		fondoCW.add(iniciar);
		principal.add(fondoCW, "FondoCW");
	}

	private void prepareActions() {
		iniciar.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionIniciar();
				} 
		});
		colorA1.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionColor("A1");
				} 
		});
		colorA2.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionColor("A2");
				} 
		});
		colorZ1.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionColor("Z1");
				} 
		});
		colorZ2.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionColor("Z2");
				} 
		});
		colorR1.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionColor("R1");
				} 
		});
		colorR2.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionColor("R2");
				} 
		});
		colorV1.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionColor("V1");
				} 
		});
		colorV2.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionColor("V2");
				} 
		});
	}

	public void actionIniciar() {
		nombreJ1 = nombre1.getText();
		nombreJ2 = nombre2.getText();
		if (colorJ1 == null || colorJ2 == null) {
			JOptionPane.showMessageDialog(null, "Falta Escojer El Color","¡Alerta!",1);
		} else if (nombreJ1.equals("") || nombreJ2.equals("")) {
			JOptionPane.showMessageDialog(null, "Falta Nombre Del Jugador","¡Alerta!",1);
		} else {
			currentGame = new Poobchis(nombreJ1, colorJ1, 1, nombreJ2, colorJ2);
			//prepareGameHumansWindow();
			//prepareActionsGameHumansWindow();
			card.show(principal, "FondoGHW");
		}
	}

	public void actionColor(String color) {
		if (color == "A1") {
			colorJ1 = "Amarillo";
			colorA2.setEnabled(false);
		} else if (color == "A2") {
			colorJ2 = "Amarillo";
			colorA1.setEnabled(false);
		} else if (color == "Z1") {
			colorJ1 = "Azul";
			colorZ2.setEnabled(false);
		} else if (color == "Z2") {
			colorJ2 = "Azul";
			colorZ1.setEnabled(false);
		} else if (color == "R1") {
			colorJ1 = "Rojo";
			colorR2.setEnabled(false);
		} else if (color == "R2") {
			colorJ2 = "Rojo";
			colorR1.setEnabled(false);
		} else if (color == "V1") {
			colorJ1 = "Verde";
			colorV2.setEnabled(false);
		} else if (color == "V2") {
			colorJ2 = "Verde";
			colorV1.setEnabled(false);
		}
	}
}
