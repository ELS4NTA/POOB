package domain;
import java.io.*;
import java.util.*;


/**
 * Representa los sistemas que puedan ser
 * descritos como una coleccion masiva de items 
 * simples que interactuan localmente unos con otros y
 * que evolucionan a pasos discretos.
 * @author Angie Mojica - Daniel Santanilla
 * @version 18-03-22
 */
public class CellularAutomata implements Serializable {
	
	private static int LENGTH=30;
    private Item[][] automata;
    
    public CellularAutomata() {
        automata=new Item[LENGTH][LENGTH];
        for (int r=0;r<LENGTH;r++){
            for (int c=0;c<LENGTH;c++){
                automata[r][c]=null;
            }
        }
        someItems();
    }
    
    /**
     * Longitud del automata
     * @return Entero con la longitud del automata
     */
    public int  getLength() {
        return LENGTH;
    }

    /**
     * Obtiene un item contenido en el automata
     * @return Item obenido dada las posiciones indicadas
     */
    public Item getItem(int r,int c) {
        return automata[r][c];
    }
    
    /**
     * Coloca un item en el automata
     */
    public void setItem(int r, int c, Item e) {
        automata[r][c]=e;
    }
    
    /**
     * Inicializa items en el automata.
     */
    public void someItems() {
        Cell indiana = new Cell(this, 1, 1);
        Cell cerocerosiete = new Cell(this, 2, 2);
        Cell agamenon = new Inquieta(this, 5, 5);
        Cell venus = new Inquieta(this, 10, 10);
        Bulb noreste = new Bulb(this, 0, 29);
        Bulb suroeste = new Bulb(this, 29, 0);
        Banderin angie = new Banderin(this,15,15);
        Banderin daniel = new Banderin(this,10,5);
        Conway john = new Conway(this, 5, 14);
        Conway horton = new Conway(this, 5,15);
        Muro berlin = new Muro(this, 15,6);
    }
    
    /**
     * Marca el paso del tiempo para todos los Items de Automata.
     */
    public void ticTac() {
        for (int i=0;i<automata.length;i++) {
            for (int j=0;j<automata[0].length;j++) {
                if (automata[i][j] != null) {
                    automata[i][j].decide();
                }
            }
        }
        for (int i=0;i<automata.length;i++) {
            for (int j=0;j<automata[0].length;j++) {
                if (automata[i][j] != null) {
                    automata[i][j].change();
                }
            }
        }
    }
    
    /**
     * Abre un archivo version final
     * @param archivo Archivo
     * @return automata
     * @throws AutomataException Si el archivo no se encuentra
     * */
    public static CellularAutomata abra(File archivo) throws AutomataException{
    	CellularAutomata automata = null;
    	try {
            if(!archivo.exists()){
            	throw new AutomataException(AutomataException.ARCHIVO_NO_ENCONTRADO);
            }
    		ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));
    		automata = (CellularAutomata) in.readObject();
    		in.close();
		} catch (Exception e) {
			throw new AutomataException(AutomataException.ARCHIVO_NO_ENCONTRADO);
		}
    	return automata;
    }
    
    /**
     * Abre un archivo version 0.1
     * @param archivo Archivo
     * @return automata
     * @throws AutomataException La opcion se encuentra en contruccion
     * */
    public static CellularAutomata abra01(File archivo) throws AutomataException{
    	CellularAutomata automata = null;
    	try {
    		ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo));
    		automata = (CellularAutomata) in.readObject();
    		in.close();
		} catch (Exception e) {
            e.printStackTrace();
		}
    	return automata;
    }
    /**
     * Abre un archivo version 0
     * @param archivo Archivo
     * @throws AutomataException Si la opcion se encuentra en construccion
     * */
    public static CellularAutomata abra00(File archivo) throws AutomataException{
    	throw new AutomataException(AutomataException.OPCION_CONSTRUCCION);
    }
    
    /**
     * Guarda un archivo
     * @param archivo Archivo
     * @throws AutomataException Si la opcion esta en construccion
     * */
    public void guarde(File archivo) throws AutomataException{
    	try {
    		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo));
    		out.writeObject(this);
    		out.close();
		} catch (Exception e) {
            e.printStackTrace();
		}
    }
    
    /**
     * Guarda un archivo
     * @param archivo Archivo
     * @throws AutomataException Si la opcion esta en construccion
     * */
    public void guarde01(File archivo) throws AutomataException{
    	try {
    		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo));
    		out.writeObject(this);
    		out.close();
		} catch (Exception e) {
            e.printStackTrace();
		}
    }
    
    /**
     * Version inical para el metodo de guarda
     * @param archivo Archivo
     * @throws AutomataException Si la opcion esta en construccion
     **/
    public void guarde00(File archivo) throws AutomataException{
    	throw new AutomataException(AutomataException.OPCION_CONSTRUCCION);
    }
    
    /**
     * Importa un archivo
     * @param archivo Archivo
     * @return automata
     * @throws AutomataException Si El archivo no se encuentra
     **/
    public static CellularAutomata importe(File archivo) throws AutomataException{
    	CellularAutomata automata = new CellularAutomata();
    	try {
    		if(!archivo.exists()){
            	throw new AutomataException(AutomataException.ARCHIVO_NO_ENCONTRADO);
            }
    		BufferedReader bIn = new BufferedReader(new FileReader(archivo));
        	String line = bIn.readLine();
        	while (line != null) {
        		line = line.trim();
        		String[] data = line.split(" ");
        		construccion(automata, data[0], data[1], data[2]);
        		line = bIn.readLine();
        	}
        	bIn.close();
		} catch (Exception e) {
			throw new AutomataException(AutomataException.ARCHIVO_NO_ENCONTRADO);
		}
    	return automata;
    }
    
    /**
     * Importa un archivo
     * @param archivo Archivo
     * @return automata
     * @throws AutomataException Si la opcion esta en construccion
     **/
    public static CellularAutomata importe01(File archivo) throws AutomataException{
    	CellularAutomata automata = new CellularAutomata();
    	try {
    		BufferedReader bIn = new BufferedReader(new FileReader(archivo));
        	String line = bIn.readLine();
        	while (line != null) {
        		line = line.trim();
        		String[] data = line.split(" ");
        		construccion(automata, data[0], data[1], data[2]);
        		line = bIn.readLine();
        	}
        	bIn.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
    	return automata;
    }
    
    /**
     * Version inical para el metodo de importar
     * @param archivo Archivo
     * @return automata
     * @throws AutomataException Si la opcion esta en construccion
     * */
    public static CellularAutomata importe00(File archivo) throws AutomataException{
    	throw new AutomataException(AutomataException.OPCION_CONSTRUCCION);
    }
    
    /**
     * Exporta un archivo
     * @param archivo Archivo
     * @throws AutomataException Si la opcion esta en construccion
     * */
    public void exporte(File archivo) throws AutomataException{
    	try{
            FileWriter out = new FileWriter(archivo);
            for(int i=0; i<automata.length;i++){
                for(int j=0;j<automata.length;j++){
                    if(getItem(i,j)!=null){
                        out.write(getItem(i,j).getClass().toString().replace("class","").replace(" domain.","")+
                                " "+String.valueOf(i)+" "+String.valueOf(j)+"\n");
                    }
                }
            }
            out.close();
        }
        catch(Exception e){
        	e.printStackTrace();
		}
    }
    
    /**
     * Version inical para el metodo de exportar
     * @param archivo Archivo
     * @throws AutomataException Si la opcion esta en construccion
     * */
    public void exporte00(File archivo) throws AutomataException{
    	throw new AutomataException(AutomataException.OPCION_CONSTRUCCION);
    }
    
    /**
     * Crea el tipo de celula segun la entrada
     * @param ca Automata celular
     * @param item tipo de celula
     * @param i fila en que se encuentra
     * @param j columna en que se encuentra
     */
    public static void construccion(CellularAutomata ca, String item,  String i, String j) {
    	int row = Integer.parseInt(i);
    	int column = Integer.parseInt(j);
    	if (item.equals("Cell")) {
    		new Cell(ca, row, column);
    	} else if (item.equals("Banderin")) {
    		new Banderin(ca, row, column);
    	} else if (item.equals("Bulb")) {
    		new Bulb(ca, row, column);
    	} else if (item.equals("Inquieta")) {
    		new Inquieta(ca, row, column);
    	} else if (item.equals("Conway")) {
    		new Conway(ca, row, column);
    	} else if (item.equals("Muro")) {
    		new Muro(ca, row, column);
    	}
    }

}
