package domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;


import java.awt.event.*;



public class Tablero extends JFrame {
    private ArrayList<JPanel> tableroCasillas = new ArrayList<JPanel>();

    public Tablero() {
        iniciarComponentes();

    }
    public static void main(String[] arg) {
        Tablero tablero = new Tablero();
        tablero.setVisible(true); 
    }
    private void iniciarComponentes() {
        setSize(660, 660);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("POOBchis");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 1, 1));
        add(panel);
        for (int i = 0; i < 9; i++) {
        	JPanel casilla = new JPanel();
        	casilla.setBackground(Color.gray);
        	casilla.setBorder(BorderFactory.createEtchedBorder());
        	if ( i == 0) {
        		casilla.setBackground(Color.red);
        	} else if (i == 2) {
        		casilla.setBackground(Color.blue);
        	} else if (i == 6) {
        		casilla.setBackground(Color.green);
        	} else if (i == 8) {
        		casilla.setBackground(Color.yellow);
        	}
        	
        	
        	tableroCasillas.add(casilla);
        	
        	if (i != 4) {
        		panel.add(casilla);
        	} else {
        		panel.add(new PanelTriangular());
        	}
        	
		}
        for (int i = 0; i < tableroCasillas.size(); i++) {
        	JPanel casilla = tableroCasillas.get(i);
			if (i != 0 && i != 2 && i != 6 && i != 8 && i != 4) {
				for (int j = 0; j < 24; j++) {
					if (i!= 3 && i!= 5) {
						casilla.setLayout(new GridLayout(8, 3, 2, 2));
						JPanel huequito = new JPanel();
						JLabel a = new JLabel();
						huequito.add(a);
						huequito.setBackground(Color.white);
						huequito.addMouseListener(new MouseAdapter() {
						
							public void mousePressed(MouseEvent e) {
								System.out.println("Hola");
								System.out.println(e.getX());
							} 
						});
						Dimension hola = huequito.getSize();
			        	System.out.println(hola.getWidth());
						casilla.add(huequito);
					} else {
						casilla.setLayout(new GridLayout(3, 8, 2, 2));
						JPanel huequito = new JPanel();
						huequito.setBackground(Color.white);
						casilla.add(huequito);
					}
				}
			}
		}
    }
    
class PanelTriangular extends JPanel{
	
	public PanelTriangular () {
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new GridLayout(1,1,2,2));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int[] xR = {4,107,209};
		int[] yR = {0,103,0};
		g.setColor(Color.red);
		g.fillPolygon(xR, yR, 3);
		int[] xG = {4,107,4};
		int[] yG = {0,103,205};
		g.setColor(Color.green);
		g.fillPolygon(xG, yG, 3);
		int[] xY = {4,107,209};
		int[] yY = {205,103,205};
		g.setColor(Color.yellow);
		g.fillPolygon(xY, yY, 3);
		int[] xB = {209,107,209};
		int[] yB = {0,103,206};
		g.setColor(Color.blue);
		g.fillPolygon(xB, yB, 3);
	}
}

}