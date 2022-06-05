package presentation;
import domain.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Presentacion del automata celular
 * @author Angie Mojica - Daniel Santanilla
 * @version 18-03-22
 */
public class AutomataGUI extends JFrame{  
	
    public static final int SIDE=21;
    public static final int SIZE=31;
    private JButton buttonTicTac;
    private JPanel panelControl;
    private PhotoAutomata photo;
    private CellularAutomata automata;
    private JMenuBar barraMenu;
    private JMenu opciones;
    private JMenuItem nuevo, abrir, guardar, importar, exportar, salir;
    private JFileChooser selectorArchivos; 
    
    /**
     * Constructor de la interfaz para el automata Celular
     */
    private AutomataGUI() {
        automata=new CellularAutomata();
        prepareElements();
        prepareActions();
    }
    
    /**
     * Prepara los componente que tiene la ventana de presentacion
     */
    private void prepareElements() {
        setTitle("Automata celular");
        photo=new PhotoAutomata(this);
        buttonTicTac=new JButton("Tic-tac");
        setLayout(new BorderLayout());
        add(photo,BorderLayout.NORTH);
        add(buttonTicTac,BorderLayout.SOUTH);
        setSize(new Dimension(SIDE*SIZE,SIDE*SIZE+50)); 
        setResizable(false);
        photo.repaint();
        prepareElementosMenu();
    }
    
    /**
     * Indica las acciones que debe cumplicar cada boton en la ventana
     */
    private void prepareActions(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
        buttonTicTac.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    buttonTicTacAction();
                }
            });
        prepareAccionesMenu();
    }
    
    /**
     * Accion que realiza el boton Tic-tac y actualiza el automata
     */
    private void buttonTicTacAction() {
        automata.ticTac();
        photo.repaint();
    }
    /**
     * Obtiene el automata celular
     * @return automata
     */
    public CellularAutomata getAutomata(){
        return automata;
    }
    
    /**
     * Prepara los elementos del menu
     */
    public void prepareElementosMenu() {
		barraMenu = new JMenuBar();
		opciones = new JMenu("Opciones");
		nuevo = new JMenuItem("Nuevo");
		abrir = new JMenuItem("Abrir");
		guardar = new JMenuItem("Guardar Como");
		importar  = new JMenuItem("Importar");
		exportar  = new JMenuItem("Exportar Como");
		salir = new JMenuItem("Salir");
		opciones.add(nuevo);
		opciones.addSeparator();
		opciones.add(abrir);
		opciones.add(guardar);
		opciones.addSeparator();
		opciones.add(importar);
		opciones.add(exportar);
		opciones.addSeparator();
		opciones.add(salir);
		barraMenu.add(opciones);
		selectorArchivos = new JFileChooser();
		setJMenuBar(barraMenu);
    }
    
    /**
     * Prepara las acciones de cada opcion del menu
     */
    public void prepareAccionesMenu(){
    	nuevo.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
            	opcionNuevo();
            }
        });
    	abrir.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
            	opcionAbrir();
            }
        });
    	guardar.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
            	opcionGuardar();
            }
        });
    	importar.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
            	opcionImportar();
            }
        });
    	exportar.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
            	opcionExportar();
            }
        });
    	salir.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent event ){
            	opcionSalir();
            }
        });
    }
    
    /**
     * Crea un nuevo automata celular
     */
    public void opcionNuevo() {
    	automata = new CellularAutomata();
    	photo.repaint();
    }
    
    /**
     * Abre un automata ya guardado
     */
    public void opcionAbrir() {
    	File archivo = null;
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo DAT (*.dat)", "dat");
    	selectorArchivos.setFileFilter(filter);
    	selectorArchivos.setVisible(true);
    	int confirmation = selectorArchivos.showOpenDialog(guardar);
    	if (confirmation == selectorArchivos.APPROVE_OPTION) {
    		archivo = selectorArchivos.getSelectedFile();
    	}
    	selectorArchivos.setVisible(false);
    	if (archivo == null) {JOptionPane.showMessageDialog(this, "Se cancelo la operacion de abrir.","Informacion",1);}
    	else {
    		try {
        		automata = automata.abra(archivo);
        		photo.repaint();
        	} catch (AutomataException ae) {
        		JOptionPane.showMessageDialog(this, ae.getMessage(),"Informacion",1);
        	}
    	}
    	
    }
    
    /**
     * Guarda el estado de un automata
     */
    public void opcionGuardar(){
    	File archivo = null;
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo DAT (*.dat)", "dat");
    	selectorArchivos.setFileFilter(filter);
    	selectorArchivos.setVisible(true);
    	int confirmation = selectorArchivos.showSaveDialog(guardar);
    	if (confirmation == selectorArchivos.APPROVE_OPTION) {
    		archivo = new File(selectorArchivos.getSelectedFile()+".dat");
    	}
    	selectorArchivos.setVisible(false);
    	// En caso de que no se confirme un archivo
    	if (archivo == null) {JOptionPane.showMessageDialog(this, "Se cancelo la operacion de guardar.","Informacion",1);}
    	else {
    		try {
        		automata.guarde(archivo);
        	} catch (AutomataException ae) {
        		System.out.println(ae.getMessage());
        	}
    	}
    }
    
    /**
     * Importa un archivo
     */
    public void opcionImportar() {
    	File archivo = null;
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Texto (*.txt)", "txt");
    	selectorArchivos.setFileFilter(filter);
    	selectorArchivos.setVisible(true);
    	int confirmation = selectorArchivos.showOpenDialog(importar);
    	if (confirmation == selectorArchivos.APPROVE_OPTION) {
    		archivo = selectorArchivos.getSelectedFile();
    	}
    	selectorArchivos.setVisible(false);
    	if (archivo == null) {JOptionPane.showMessageDialog(this, "Se cancelo la operacion de importar.","Informacion",1);}
    	else {
	    	try {
	    		automata = automata.importe(archivo);
	    		photo.repaint();
	    	} catch (AutomataException ae) {
	    		JOptionPane.showMessageDialog(this, ae.getMessage(),"Informacion",1);
	    	}
    	}
    	
    }
    
    /**
     * Exporta un archivo
     */
    public void opcionExportar() {
    	File archivo = null;
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Texto (*.txt)", "txt");
    	selectorArchivos.setFileFilter(filter);
    	selectorArchivos.setVisible(true);
    	int confirmation = selectorArchivos.showSaveDialog(exportar);
    	if (confirmation == selectorArchivos.APPROVE_OPTION) {
    		archivo = new File(selectorArchivos.getSelectedFile()+".txt");
    	}
    	selectorArchivos.setVisible(false);
    	if (archivo == null) {JOptionPane.showMessageDialog(this, "Se cancelo la operacion de exportar.","Informacion",1);}
    	else {
	    	try {
	    		automata.exporte(archivo);
	    	} catch (AutomataException ae) {
	    		System.out.println(ae.getMessage());
	    	}
    	}
    }
    
    /**
     * Permite cerrar un automata
     */
    public void opcionSalir() {
    	System.exit(0);
    }
    
    /**
     * Metodo principal
     * @param args
     */
    public static void main(String[] args) {
        AutomataGUI ca=new AutomataGUI();
        ca.setVisible(true);
    } 
    
}

/**
 * Clase que permite realizar la representcion grafica de los items
 * @author Angie Mojica - Daniel Santanilla
 *
 */
class PhotoAutomata extends JPanel{
	
    private AutomataGUI gui;
    
    /**
     * Constructor 
     * @param gui
     */
    public PhotoAutomata(AutomataGUI gui) {
        this.gui=gui;
        setBackground(Color.white);
        setPreferredSize(new Dimension(gui.SIDE*gui.SIZE, gui.SIDE*gui.SIZE));         
    }


    public void paintComponent(Graphics g){
        CellularAutomata automata=gui.getAutomata();
        super.paintComponent(g);
         
        for (int f=0;f<=automata.getLength();f++){
            g.drawLine(f*gui.SIDE,0,f*gui.SIDE,automata.getLength()*gui.SIDE);
        }
        for (int c=0;c<=automata.getLength();c++){
            g.drawLine(0,c*gui.SIDE,automata.getLength()*gui.SIDE,c*gui.SIDE);
        }       
        for (int f=0;f<automata.getLength();f++){
            for(int c=0;c<automata.getLength();c++){
                if (automata.getItem(f,c)!=null){
                    g.setColor(automata.getItem(f,c).getColor());
                    if (automata.getItem(f,c).shape()==Item.SQUARE){                  
                        if (automata.getItem(f,c).isAlive()){
                            g.fillRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);
                        }else{
                            g.drawRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);    
                        }
                    }else {
                        if (automata.getItem(f,c).isAlive()){
                            g.fillOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                        } else {
                            g.drawOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                        }
                    }
                }
            }
        }
    }
}