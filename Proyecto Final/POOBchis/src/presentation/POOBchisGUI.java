package presentation;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.*;

import domain.Poobchis;


/**
 * Presentacion del juego
 * @Autor Angie Mojica - Daniel Santanilla
 * @Version 1-05-22
 * */
/**
 * @author DANI-PC-V2
 *
 */
public class POOBchisGUI extends JFrame{
	
	private CardLayout card;
	private String colorJ1, colorJ2;
	private String nombreJ1, nombreJ2;
	private JMenuBar barraMenu;
	private JMenu opciones;
	private JPanel principal;
	private JMenuItem nuevo, abrir, salvar, salir, regresar;
	private JFileChooser selectorArchivos;
	private JButton jugar, reglas, humano, maquina, lanzar, dado1, dado2, iniciar,
	colorA1, colorA2, colorZ1, colorZ2, colorR1, colorR2, colorV1, colorV2;
	private JLabel fondoPW, fondoCMW, fondoRW, fondoGHW, ldado1, ldado2, fondoCW, nombre, color;
	private JTextField nombre1, nombre2;
	private Poobchis juego = new Poobchis("Mojica", "Azul", 1, "Santanilla", "Verde");

	private POOBchisGUI() {
		prepareElements();
		prepareActions();
	}

	public void prepareElements() {
		card = new CardLayout();
		principal = new JPanel(card);
		setTitle("POOBCHIS");
		setSize(1080, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		add(principal);
		preparePrincipalWindow();
		//prepareChooseModeWindow();
		//prepareRulesWindow();
		//prepareConfigurationWindow();
		ChooseModeWindow CMW = new ChooseModeWindow(this, juego);
		ConfigurationWindow CW = new ConfigurationWindow(this, juego);
		RulesWindow RW = new RulesWindow(this);
		
		prepareElementsMenu();
		//prepareElementsBoard();
		
		card.show(principal, "FondoPW");
	    
	}
	
	public void preparePrincipalWindow() {
		fondoPW = new JLabel();
		JLabel titulo = new JLabel();
		jugar = new JButton("JUGAR");
	    reglas = new JButton("REGLAS");
	    
		fondoPW.setBounds(0, 0, 1080, 720);
		jugar.setBounds(230, 350, 150, 80);
	    reglas.setBounds(600,350,150, 80);
	    titulo.setBounds(190, 60, 453, 202);
	    
	    pintarImagen(fondoPW, "./img/fondoPrincipal.jpg", 1080, 720);
	    pintarImagen(titulo, "./img/titulo.gif", 453, 202);
	    
	    fondoPW.add(titulo);
	    fondoPW.add(jugar);
	    fondoPW.add(reglas);
	    principal.add(fondoPW, "FondoPW");
	}
	
	/*
	 * public void prepareChooseModeWindow() { fondoCMW = new JLabel();
	 * fondoCMW.setVisible(true); JLabel titulo = new JLabel(); JLabel imagenHumano
	 * = new JLabel(); JLabel imagenMaquina = new JLabel(); humano = new
	 * JButton("JUGADOR VS JUGADOR"); maquina = new JButton("JUGADOR VS MAQUINA");
	 * 
	 * fondoCMW.setBounds(0, 0, 1080, 720); titulo.setBounds(200, 40, 701, 199);
	 * imagenHumano.setBounds(230, 350, 197, 100); imagenMaquina.setBounds(660, 350,
	 * 197, 100); humano.setBounds(250, 500, 150, 80);
	 * maquina.setBounds(680,500,150, 80);
	 * 
	 * pintarImagen(fondoCMW, "./img/fondoPrincipal.jpg", 1080, 720);
	 * pintarImagen(titulo, "./img/modotitulo.png", 701, 199);
	 * pintarImagen(imagenHumano, "./img/humanos.png", 197, 100);
	 * pintarImagen(imagenMaquina, "./img/maquina.png", 197, 100);
	 * 
	 * fondoCMW.add(titulo); fondoCMW.add(imagenHumano);
	 * fondoCMW.add(imagenMaquina); fondoCMW.add(humano); fondoCMW.add(maquina);
	 * principal.add(fondoCMW, "FondoCMW"); }
	 */
	
//	private void prepareRulesWindow() {
//		fondoRW = new JLabel();
//		fondoRW.setVisible(true);
//		fondoRW.setBounds(0, 0, 1080, 720);
//		
//		pintarImagen(fondoRW, "./img/fondoPrincipal.jpg", 1080, 720);
//		
//		principal.add(fondoRW, "FondoRW");
//	}
	
	private void preprareGameBoardWindow() {
		
	}
	
//	private void prepareConfigurationWindow() {
//		fondoCW = new JLabel();
//		JLabel titulo = new JLabel();
//		JLabel jugador1 = new JLabel();
//		JLabel jugador2 = new JLabel();
//		JLabel lnombre1 = new JLabel("Nombre:");
//		JLabel lnombre2 = new JLabel("Nombre:");
//		JLabel lcolor1 = new JLabel("Color:");
//		JLabel lcolor2 = new JLabel("Color:");
//		nombre1 = new JTextField();
//		nombre2 = new JTextField();
//		colorA1 = new JButton();
//		colorZ1 = new JButton();
//		colorR1 = new JButton();
//		colorV1 = new JButton();
//		colorA2 = new JButton();
//		colorZ2 = new JButton();
//		colorR2 = new JButton();
//		colorV2 = new JButton();
//		iniciar = new JButton("INICIAR");
//		
//		titulo.setBounds(200, 0, 667, 200);
//		jugador1.setBounds(100, 200, 239, 89);
//		jugador2.setBounds(700, 200, 256, 91);
//		nombre1.setBounds(100, 300, 239, 30);
//		nombre2.setBounds(700, 300, 256, 30);
//		lnombre1.setBounds(15, 300, 100, 30);
//		lnombre2.setBounds(615, 300, 100, 30);
//		lnombre1.setFont(new Font("arial",1,20));
//		lnombre2.setFont(new Font("arial",1,20));
//		lnombre1.setForeground(Color.WHITE);
//		lnombre2.setForeground(Color.WHITE);
//		lcolor1.setBounds(15, 350, 100, 30);
//		lcolor2.setBounds(615, 350, 100, 30);
//		lcolor1.setFont(new Font("arial",1,20));
//		lcolor2.setFont(new Font("arial",1,20));
//		lcolor1.setForeground(Color.WHITE);
//		lcolor2.setForeground(Color.WHITE);
//		colorA1.setBounds(100, 350, 30, 30);
//		colorZ1.setBounds(140, 350, 30, 30);
//		colorR1.setBounds(180, 350, 30, 30);
//		colorV1.setBounds(220, 350, 30, 30);
//		colorA1.setBackground(Color.YELLOW);
//		colorZ1.setBackground(Color.BLUE);
//		colorR1.setBackground(Color.RED);
//		colorV1.setBackground(Color.GREEN);
//		colorA2.setBounds(700, 350, 30, 30);
//		colorZ2.setBounds(740, 350, 30, 30);
//		colorR2.setBounds(780, 350, 30, 30);
//		colorV2.setBounds(820, 350, 30, 30);
//		colorA2.setBackground(Color.YELLOW);
//		colorZ2.setBackground(Color.BLUE);
//		colorR2.setBackground(Color.RED);
//		colorV2.setBackground(Color.GREEN);
//		iniciar.setBounds(350, 500, 300, 60);
//		
//		pintarImagen(fondoCW, "./img/fondoPrincipal.jpg", 1080, 720);
//		pintarImagen(titulo, "./img/configuracion.png", 677, 200);
//		pintarImagen(jugador1, "./img/jugador1.png", 239, 89);
//		pintarImagen(jugador2, "./img/jugador2.png", 256, 91);
//		
//		fondoCW.add(titulo);
//		fondoCW.add(jugador1);
//		fondoCW.add(jugador2);
//		fondoCW.add(nombre1);
//		fondoCW.add(nombre2);
//		fondoCW.add(lnombre1);
//		fondoCW.add(lnombre2);
//		fondoCW.add(lcolor1);
//		fondoCW.add(lcolor2);
//		fondoCW.add(colorA1);
//		fondoCW.add(colorZ1);
//		fondoCW.add(colorR1);
//		fondoCW.add(colorV1);
//		fondoCW.add(colorA2);
//		fondoCW.add(colorZ2);
//		fondoCW.add(colorR2);
//		fondoCW.add(colorV2);
//		fondoCW.add(iniciar);
//		principal.add(fondoCW, "FondoCW");
//	}
	
	private void prepareGameHumansWindow() {
		fondoGHW = new JLabel();
		fondoGHW.setVisible(true);
		ldado1 = new JLabel();
		ldado2 = new JLabel();
		lanzar = new JButton("LANZAR");
		JLabel jugadorEnTruno = new JLabel("JUGADOR EN TURNO");
		JLabel lblnombre = new JLabel();
		JLabel lblcolor = new JLabel();
		JLabel lblcoronadas = new JLabel();
		JLabel lblcarcel = new JLabel();
		JLabel tablero = new JLabel();
		JTextField coronadas = new JTextField("Coronadas");
		JTextField enCarcel = new JTextField("Fichas en Carcel");
		dado1 = new JButton();
		dado2 = new JButton();
		nombre = new JLabel(nombreJ1);
		color = new JLabel(colorJ1);
		
		
		dado1.setContentAreaFilled(false);
		dado2.setContentAreaFilled(false);
		fondoGHW.setBounds(0, 0, 1080, 720);
		lanzar.setBounds(740, 400, 240, 50);
		tablero.setBounds(0, 0, 660, 660);
		ldado1.setBounds(730, 500, 112, 112);
		ldado2.setBounds(870, 500, 112, 112);
		dado1.setBounds(730, 500, 112, 112);
		dado2.setBounds(870, 500, 112, 112);
		jugadorEnTruno.setBounds(760, 0, 251, 151);
		lblnombre.setBounds(690, 150, 146, 62);
		lblcolor.setBounds(690, 200, 121, 59);
		lblcoronadas.setBounds(690, 250, 196, 66);
		lblcarcel.setBounds(690, 300, 144, 67);
		nombre.setBounds(830, 165, 130, 30);
		color.setBounds(810, 215, 130, 30);
		coronadas.setBounds(880, 265, 130, 30);
		enCarcel.setBounds(840, 320, 130, 30);
		nombre.setFont(new Font("arial",1,20));
		color.setFont(new Font("arial",1,20));
		nombre.setForeground(Color.WHITE);
		color.setForeground(Color.WHITE);

		pintarImagen(fondoGHW, "./img/fondoPrincipal.jpg", 1080, 720);
		pintarImagen(tablero, "./img/tablero.png", 660, 660);
		pintarImagen(jugadorEnTruno, "./img/enturno.png", 251, 151);
		pintarImagen(lblnombre, "./img/nombre.png", 146, 62);
		pintarImagen(lblcolor, "./img/color.png", 121, 59);
		pintarImagen(lblcoronadas, "./img/coronadas.png", 196, 66);
		pintarImagen(lblcarcel, "./img/carcel.png", 144, 67);
		pintarImagen(ldado1, "./img/dado/dado6.png", 112, 112);
		pintarImagen(ldado2, "./img/dado/dado6.png", 112, 112);
		
		fondoGHW.add(lanzar);
		fondoGHW.add(jugadorEnTruno);
		fondoGHW.add(lblnombre);
		fondoGHW.add(lblcolor);
		fondoGHW.add(lblcoronadas);
		fondoGHW.add(lblcarcel);
		fondoGHW.add(nombre);
		fondoGHW.add(color);
		fondoGHW.add(coronadas);
		fondoGHW.add(enCarcel);
		fondoGHW.add(dado1);
		fondoGHW.add(dado2);
		fondoGHW.add(ldado1);
		fondoGHW.add(ldado2);
		fondoGHW.add(tablero);
		principal.add(fondoGHW, "FondoGHW");
	}
	
	private void pintarImagen(JLabel label, String ruta, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(ruta);
		ImageIcon icon = new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		label.setIcon(icon);
		repaint();
	}
	
	public void prepareElementsMenu() {
		barraMenu = new JMenuBar();
		opciones = new JMenu("Opciones");
		nuevo = new JMenuItem("Nuevo");
		abrir = new JMenuItem("Abrir");
		salvar = new JMenuItem("Guardar");
		salir = new JMenuItem("Salir");
		regresar = new JMenuItem("Regresar");
		opciones.add(nuevo);
		opciones.addSeparator();
		opciones.add(abrir);
		opciones.add(salvar);
		opciones.addSeparator();
		opciones.add(salir);
		barraMenu.add(opciones);
		barraMenu.add(regresar);
		selectorArchivos = new JFileChooser();
		setJMenuBar(barraMenu);
	}
	

	public void prepareActions() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	actionClose();
            }
        });
		prepareActionsMenu();
		prepareActionsPrincipalWindow();
		//prepareActionsChooseModeWindow();
		//repareActionsConfigurationWindow();
	}
	
//	public void prepareActionsConfigurationWindow() {
//		iniciar.addActionListener( new ActionListener(){
//			public void actionPerformed( ActionEvent event) {
//				actionIniciar();
//				} 
//		});
//		colorA1.addActionListener( new ActionListener(){
//			public void actionPerformed( ActionEvent event) {
//				actionColor("A1");
//				} 
//		});
//		colorA2.addActionListener( new ActionListener(){
//			public void actionPerformed( ActionEvent event) {
//				actionColor("A2");
//				} 
//		});
//		colorZ1.addActionListener( new ActionListener(){
//			public void actionPerformed( ActionEvent event) {
//				actionColor("Z1");
//				} 
//		});
//		colorZ2.addActionListener( new ActionListener(){
//			public void actionPerformed( ActionEvent event) {
//				actionColor("Z2");
//				} 
//		});
//		colorR1.addActionListener( new ActionListener(){
//			public void actionPerformed( ActionEvent event) {
//				actionColor("R1");
//				} 
//		});
//		colorR2.addActionListener( new ActionListener(){
//			public void actionPerformed( ActionEvent event) {
//				actionColor("R2");
//				} 
//		});
//		colorV1.addActionListener( new ActionListener(){
//			public void actionPerformed( ActionEvent event) {
//				actionColor("V1");
//				} 
//		});
//		colorV2.addActionListener( new ActionListener(){
//			public void actionPerformed( ActionEvent event) {
//				actionColor("V2");
//				} 
//		});
//	} 
	
	public void prepareActionsGameHumansWindow() {
		lanzar.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionDiceThrow();
				} 
		});
	}
	
	/*
	 * public void prepareActionsChooseModeWindow() { humano.addActionListener( new
	 * ActionListener(){ public void actionPerformed( ActionEvent event) {
	 * actionGameHumans(); } }); maquina.addActionListener( new ActionListener(){
	 * public void actionPerformed( ActionEvent event) { actionGameBot(); } }); }
	 */
	
	public void prepareActionsPrincipalWindow() {
		jugar.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionPlay();
				} 
		});
		reglas.addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent event) {
				actionRules();
				} 
		});
	}
	
    public void prepareActionsMenu(){
    	abrir.addActionListener( new ActionListener(){ 
    		public void actionPerformed( ActionEvent event ){
            	actionOpen();
            } 
    	});
    	salvar.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
            	actionSave();
            }
        });
        salir.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
            	actionClose();
            }
        });
        regresar.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
            	actionReturn();
            }
        });
    }
	
    public void actionOpen() {
    	File archivo = null;
    	selectorArchivos.setVisible(true);
    	int confirmation = selectorArchivos.showOpenDialog(abrir);
    	if (confirmation == selectorArchivos.APPROVE_OPTION) {
    		archivo = selectorArchivos.getSelectedFile();
    	}
    	JOptionPane.showMessageDialog(abrir, "La accion para abrir el archivo " + archivo.getName() + " esta en construccion.","Informacion",1);
    	selectorArchivos.setVisible(false);
    }
    
    
    public void actionSave() {
    	File archivo = null;
    	selectorArchivos.setVisible(true);
    	int confirmation = selectorArchivos.showSaveDialog(salvar);
    	if (confirmation == selectorArchivos.APPROVE_OPTION) {
    		archivo = selectorArchivos.getSelectedFile();
    	}
    	JOptionPane.showMessageDialog(salvar, "La accion para guardar el archivo " + archivo.getName() + " esta en construccion.","Informacion",1);
    	selectorArchivos.setVisible(false);
    }
    
	public void actionClose(){
        int confirmation = JOptionPane.showConfirmDialog(null,"¿Seguro que desea salir?","Cerrar",0);
        if(confirmation == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
	
	public void actionPlay() {
		card.show(principal, "FondoCMW");
	}
	
	public void actionRules() {
		card.show(principal, "FondoRW");
	}
	
	public void actionReturn() {
		card.show(principal, "FondoPW");
	}
	
	/*
	 * public void actionGameHumans() { card.show(principal, "FondoCW"); }
	 * 
	 * public void actionGameBot() { card.show(principal, "HumanoVSBot"); }
	 */
//	public void actionIniciar() {
//		nombreJ1 = nombre1.getText();
//		nombreJ2 = nombre2.getText();
//		if (colorJ1 == null || colorJ2 == null) {
//			JOptionPane.showMessageDialog(null, "Falta Escojer El Color","¡Alerta!",1);
//		} else if (nombreJ1.equals("") || nombreJ2.equals("")) {
//			JOptionPane.showMessageDialog(null, "Falta Nombre Del Jugador","¡Alerta!",1);
//		} else {
//			juego = new Poobchis(nombreJ1, colorJ1, 1, nombreJ2, colorJ2);
//			prepareGameHumansWindow();
//			prepareActionsGameHumansWindow();
//			card.show(principal, "FondoGHW");
//		}
//	}
//	
//	public void actionColor(String color) {
//		if (color == "A1") {
//			colorJ1 = "Amarillo";
//			colorA2.setEnabled(false);
//		} else if (color == "A2") {
//			colorJ2 = "Amarillo";
//			colorA1.setEnabled(false);
//		} else if (color == "Z1") {
//			colorJ1 = "Azul";
//			colorZ2.setEnabled(false);
//		} else if (color == "Z2") {
//			colorJ2 = "Azul";
//			colorZ1.setEnabled(false);
//		} else if (color == "R1") {
//			colorJ1 = "Rojo";
//			colorR2.setEnabled(false);
//		} else if (color == "R2") {
//			colorJ2 = "Rojo";
//			colorR1.setEnabled(false);
//		} else if (color == "V1") {
//			colorJ1 = "Verde";
//			colorV2.setEnabled(false);
//		} else if (color == "V2") {
//			colorJ2 = "Verde";
//			colorV1.setEnabled(false);
//		}
//	}
	
	public void actionDiceThrow() {
		int[] valorDados = juego.lanzarDados(juego.getJugadorEnTurno());
		int valor1 = valorDados[0];
		int valor2 = valorDados[1];
		pintarImagen(ldado1, "./img/dado/dado"+valor1+".png", 112, 112);
		pintarImagen(ldado2, "./img/dado/dado"+valor2+".png", 112, 112);
		
	}
	
	public JPanel getPrincipal() {
		return principal;
	}
	
	public CardLayout getCard() {
		return card;
	}

	public static void main(String[] args) {
		POOBchisGUI gui = new POOBchisGUI();
		gui.setVisible(true);
	}
}
