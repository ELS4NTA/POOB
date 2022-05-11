package presentation;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Poobchis;

public class TableroGUI extends JFrame {
	
	private ArrayList<JPanel> tableroCasillas = new ArrayList<JPanel>();
	private final int distancex = 73;
	private final int distancey = 27;
	
	public TableroGUI() {
		iniciarComponentes();
		pintarComponentes();
	}
	
	public static void main(String[] arg) {
		TableroGUI tablero = new TableroGUI();
		tablero.setVisible(true); 
	}
	
	private void iniciarComponentes() {
		setSize(1080, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("POOBchis");
		setResizable(false);
		JLabel ventana = new JLabel();
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 660, 660);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		ventana.add(panel);
		this.getContentPane().add(ventana);
		JPanel panel0 = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		panel1.setLayout(null);
		panel3.setLayout(null);
		panel5.setLayout(null);
		panel7.setLayout(null);
		panel0.setBorder(BorderFactory.createEtchedBorder());
		panel1.setBorder(BorderFactory.createEtchedBorder());
		panel2.setBorder(BorderFactory.createEtchedBorder());
		panel3.setBorder(BorderFactory.createEtchedBorder());
		panel5.setBorder(BorderFactory.createEtchedBorder());
		panel6.setBorder(BorderFactory.createEtchedBorder());
		panel7.setBorder(BorderFactory.createEtchedBorder());
		panel8.setBorder(BorderFactory.createEtchedBorder());
		panel0.setBackground(Color.RED);
		panel2.setBackground(Color.BLUE);
		panel6.setBackground(Color.GREEN);
		panel8.setBackground(Color.YELLOW);
		panel.add(panel0);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(new TriangleTablero());
		panel.add(panel5);
		panel.add(panel6);
		panel.add(panel7);
		panel.add(panel8);
		JPanel casilla0 = new JPanel();
		tableroCasillas.add(casilla0);
		
		//Casillas 1-8
		
		int cont = 192;
		for (int i=1; i<9; i++) {
			JPanel casilla1 = new JPanel();
			casilla1.setBounds(146, cont, distancex, distancey);
			panel7.add(casilla1);
			tableroCasillas.add(casilla1);
			cont -= distancey;
		}
	
		//Casillas 9-16
		
		int cont2 = 2;
		for (int i=1; i<9; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(cont2, 148, distancey, distancex);
			panel5.add(casilla);
			tableroCasillas.add(casilla);
			cont2 += distancey;
		}

		//Casilla 17; 18-25
		
		JPanel casilla17 = new JPanel();
		casilla17.setBounds(191, 75, distancey, distancex);
		panel5.add(casilla17);
		tableroCasillas.add(casilla17); 
		int cont3 = 191;
		for (int i=1; i<9; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(cont3, 2, distancey, distancex);
			panel5.add(casilla);
			tableroCasillas.add(casilla);
			cont3 -= distancey;
		}
		
		//Casillas 26-33
		
		int cont4 = 193;
		for (int i=1; i<9; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(146, cont4, distancex, distancey);
			panel1.add(casilla);
			tableroCasillas.add(casilla);
			cont4 -= distancey;
		}

		//Casillas 34; 35-42
		
		JPanel casilla34 = new JPanel();
		casilla34.setBounds(73, 4,  distancex, distancey);
		panel1.add(casilla34);
		tableroCasillas.add(casilla34); 
		int cont5 = 4;
		for (int i=1; i<9; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(1, cont5, distancex, distancey);
			panel1.add(casilla);
			tableroCasillas.add(casilla);
			cont5 += distancey;
		}
		
		//Casillas 43-50
		
		int cont6 = 192;
		for (int i=1; i<9; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(cont6, 2, distancey, distancex);
			panel3.add(casilla);
			tableroCasillas.add(casilla);
			cont6 -= distancey;
		}

		//Casillas 51; 52-59
		
		JPanel casilla51 = new JPanel();
		casilla51.setBounds(2, 75, distancey, distancex);
		panel3.add(casilla51);
		tableroCasillas.add(casilla51);
		
		int cont7 = 3;
		for (int i=1; i<9; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(cont7, 148, distancey, distancex);
			panel3.add(casilla);
			tableroCasillas.add(casilla);
			cont7 += distancey;
		}
		
		//Casillas 60-67
		
		int cont8 = 3;
		for (int i=1; i<9; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(1, cont8, distancex, distancey);
			panel7.add(casilla);
			tableroCasillas.add(casilla);
			cont8 += distancey;
		}

		//Casilla 68
		
		JPanel casilla68 = new JPanel();
		casilla68.setBounds(73, 192, distancex, distancey);
		panel7.add(casilla68);
		tableroCasillas.add(casilla68);
		
		//Casillas CasaAzul
		
		int cont9 = 1;
		for (int i=1; i<8; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(cont9, 75, distancey, distancex);
			panel5.add(casilla);
			tableroCasillas.add(casilla);
			cont9 += distancey;
		}

		JPanel casilla76 = new JPanel();
		tableroCasillas.add(casilla76); //No tiene nada
		
		//Casillas CasaRoja
		
		int cont10 = 31;
		for (int i=1; i<8; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(73, cont10, distancex, distancey);
			panel1.add(casilla);
			tableroCasillas.add(casilla);
			cont10 += distancey;
		}

		JPanel casilla84 = new JPanel();
		tableroCasillas.add(casilla84); //No tiene nada
		
		//Casillas casaVerde
		
		int cont11 = 30;
		for (int i=1; i<8; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(cont11, 75, distancey, distancex);
			panel3.add(casilla);
			tableroCasillas.add(casilla);
			cont11 += distancey;
		}
		JPanel casilla92 = new JPanel();
		tableroCasillas.add(casilla92); //No tiene nada
		
		//Casillas casaAmarilla
		
		int cont12 = 165;
		for (int i=1; i<8; i++) {
			JPanel casilla = new JPanel();
			casilla.setBounds(73, cont12, distancex, distancey);
			panel7.add(casilla);
			tableroCasillas.add(casilla);
			cont12 -= distancey;
		}
		JPanel casilla100 = new JPanel();
		tableroCasillas.add(casilla100); //No tiene nada
	} 
	
	public void pintarComponentes() {
		
		tableroCasillas.get(60).setBackground(Color.MAGENTA);
		tableroCasillas.get(9).setBackground(Color.MAGENTA);
		tableroCasillas.get(26).setBackground(Color.MAGENTA);
		tableroCasillas.get(43).setBackground(Color.MAGENTA);
		tableroCasillas.get(12).setBackground(Color.LIGHT_GRAY);
		tableroCasillas.get(17).setBackground(Color.LIGHT_GRAY);
		tableroCasillas.get(29).setBackground(Color.LIGHT_GRAY);
		tableroCasillas.get(34).setBackground(Color.LIGHT_GRAY);
		tableroCasillas.get(46).setBackground(Color.LIGHT_GRAY);
		tableroCasillas.get(51).setBackground(Color.LIGHT_GRAY);
		tableroCasillas.get(63).setBackground(Color.LIGHT_GRAY);
		tableroCasillas.get(68).setBackground(Color.LIGHT_GRAY);
		tableroCasillas.get(5).setBackground(Color.YELLOW);
		tableroCasillas.get(22).setBackground(Color.BLUE);
		tableroCasillas.get(39).setBackground(Color.RED);
		tableroCasillas.get(56).setBackground(Color.GREEN);
		
		for(int i=1; i<tableroCasillas.size();i++) {
			tableroCasillas.get(i).setLayout(null);
			tableroCasillas.get(i).setBorder(BorderFactory.createEtchedBorder());
			if(i>=1 && i<69) {
				String number = String.valueOf(i);
				JLabel etiqueta = new JLabel(number);
				etiqueta.setBounds(0,0, 15, 15);
				etiqueta.setFont(new Font("Bahnschrift SemiBold", Font.BOLD,10)); //Tipo letra
				tableroCasillas.get(i).add(etiqueta);
			}
			if(i>=69 && i<=76) {
				tableroCasillas.get(i).setBackground(Color.BLUE);
			}else if(i>=77 && i<= 84) {
				tableroCasillas.get(i).setBackground(Color.RED);
			}else if(i>=85 && i<= 92) {
				tableroCasillas.get(i).setBackground(Color.GREEN);
			}else if(i>=93 && i<= 100) {
				tableroCasillas.get(i).setBackground(Color.YELLOW);
			}
		}

	}
	
	public class TriangleTablero extends JPanel {
		
		public TriangleTablero() {		
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int[] xpositions = {0,110,220};
			int[] ypositions = {0,110,0};
			g.setColor(Color.RED);
			g.fillPolygon(xpositions, ypositions, 3);
			
			int[] xpositions2 = {220,110,220};
			int[] ypositions2 = {0,110,220};
			g.setColor(Color.BLUE);
			g.fillPolygon(xpositions2, ypositions2, 3);
			
			int[] xpositions3 = {0,110,220};
			int[] ypositions3 = {220,110,220};
			g.setColor(Color.YELLOW);
			g.fillPolygon(xpositions3, ypositions3, 3);
			
			int[] xpositions4 = {0,110,0};
			int[] ypositions4 = {0,110,220};
			g.setColor(Color.GREEN);
			g.fillPolygon(xpositions4, ypositions4, 3);

		}
	}
}
	