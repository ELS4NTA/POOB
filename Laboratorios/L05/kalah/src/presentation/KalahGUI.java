package presentation;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import domain.Kalah;

/**
 * Presentacion del juego
 * @Autor Angie Mojica - Daniel Santanilla
 * @Version 12-04-22
 * */
public class KalahGUI extends JFrame{
	
	private JMenuBar barraMenu;
	private JMenu opciones;
	private JMenuItem nuevo, abrir, salvar, salir;
	private JFileChooser selectorArchivos;
	private JPanel tablero, cinta, casas, fondo, 
	movimientos;
	private JButton colores, reiniciar, almacen1, almacen2;
	private Kalah kalah;
	
	/**
	 * Construcctor
	 * */
	private KalahGUI() {
		setTitle("Kalah");
		prepareElements();
		prepareActions();
	}
	
	/**
	 * Preparando elementos
	 * */
	public void prepareElements() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int alto = dimension.height;
	    int ancho = dimension.width;
		setSize(ancho/2, alto/2);
		setLocationRelativeTo(null);
		prepareElementsMenu();
		prepareElementsBoard();
	}
	
	/**
	 * Preparando elementos del menu
	 * */
	public void prepareElementsMenu() {
		barraMenu = new JMenuBar();
		opciones = new JMenu("Opciones");
		nuevo = new JMenuItem("Nuevo");
		abrir = new JMenuItem("Abrir");
		salvar = new JMenuItem("Guardar");
		salir = new JMenuItem("Salir");
		opciones.add(nuevo);
		opciones.add(abrir);
		opciones.add(salvar);
		opciones.add(salir);
		barraMenu.add(opciones);
		selectorArchivos = new JFileChooser();
		setJMenuBar(barraMenu);
	}
	
	/**
	 * Preparando elementos del tablero
	 * */
	public void prepareElementsBoard() {
		int n_casas = 6;
		fondo = new JPanel();
		tablero = new JPanel();
		casas = new JPanel();
		cinta = new JPanel();
		movimientos = new JPanel();
		almacen1 = new JButton("0");
		almacen2 = new JButton("0");
		reiniciar = new JButton("Reiniciar");
		colores = new JButton("Colores");

		fondo.setLayout(new BorderLayout());
		tablero.setLayout(new BorderLayout());
		casas.setLayout(new GridLayout(2, n_casas, 10, 10));

		tablero.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10), new TitledBorder("Tablero")));
		cinta.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10), new TitledBorder("Seleccion")));
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j <n_casas; j++) {
				JButton casa = new JButton("0");
				casa.setPreferredSize(new Dimension(10,10));
				casa.setBackground(Color.white);//en espera
				casas.add(casa);		
			} 
		}
		
		almacen1.setBackground(Color.white);
		almacen2.setBackground(Color.white);
		almacen1.setPreferredSize(new Dimension(50,50));
		almacen2.setPreferredSize(new Dimension(50,50));
		
		movimientos.add(new JLabel("Movimientos:"));
		movimientos.add(new JSpinner());
		
		cinta.add(reiniciar);
		cinta.add(colores);
		cinta.add(movimientos);
		
		
		tablero.add(casas, BorderLayout.CENTER);
		tablero.add(almacen1, BorderLayout.WEST);
		tablero.add(almacen2, BorderLayout.EAST);
		
		fondo.add(cinta, BorderLayout.SOUTH);
		fondo.add(tablero, BorderLayout.CENTER);
		
		add(fondo);
		
	}
	
	public void refresh() {
		
	}
	
	/**
	 * Preparando acciones
	 * */
	public void prepareActions() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	actionClose();
            }
        });
		prepareActionsMenu();
		colores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Seleccione un Color", Color.black);
                casas.setBackground(color);
                almacen1.setBackground(color);
                almacen2.setBackground(color);
            }
        });
	}
	
	/**
	 * Preparando acciones del menu
	 * */
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
    }
	
    /**
     * Accion para abrir un archivo
     * */
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
    
    /**
     * Accion para guardar la partida
     * */
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
    
    /**
     * Accion para cerrar la ventana
     * */
	public void actionClose(){
        int confirmation = JOptionPane.showConfirmDialog(null,"¿Seguro que desea salir?","Cerrar",0);
        if(confirmation == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
	
	/**
	 * Metodo principal
	 * */
	public static void main(String[] args) {
		KalahGUI gui = new KalahGUI();
		gui.setVisible(true);
	}
}
