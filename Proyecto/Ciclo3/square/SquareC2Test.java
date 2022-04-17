import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SquareC2Test.
 *
 * @author  Mojica-Santanilla
 * @version 0.0.1
 */
public class SquareC2Test {
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        Square plaza = new Square(600,600,4);
    }
    
    
    @Test
    public void deberiaAnnadirDomo() {
        Square plaza = new Square(600,600,4);
        String[] domos = {"red","blue","yellow","magenta","black"};
        plaza.addDome("red",100,100);
        plaza.addDome("blue",200,200);
        plaza.addDome("yellow",300,300);
        plaza.addDome("magenta",400,400);
        plaza.addDome("black",500,500);
        assertArrayEquals(plaza.domes(),domos);
    }
    
    @Test
    public void noDeberiaAnnadirDomo() {
        Square plaza = new Square(600,600,4);
        String[] domos = {"red","blue"};
        plaza.addDome("red",700,700); // Coordenadas excedidas
        plaza.addDome("blue",-200,-200); // Distancia no valida
        assertFalse((plaza.domes()).equals(domos));
    }
    
    @Test
    public void deberiaEliminarDomo() {
        Square plaza = new Square(600,600,4);
        String[] domos = {"red","yellow"};
        plaza.addDome("red",100,100);
        plaza.addDome("blue",200,200);
        plaza.addDome("yellow",300,300);
        plaza.delDome("blue");
        assertArrayEquals(plaza.domes(),domos);
        plaza.delDome("red");
        String[] domos2 = {"yellow"};
        assertArrayEquals(plaza.domes(),domos2);
    }
    
    @Test
    public void noDeberiaEliminarDomo() {
        Square plaza = new Square(600,600,4);
        String[] domos = {"red","blue"};
        plaza.addDome("red",100,100);
        plaza.addDome("blue",200,200);
        plaza.delDome("black"); // No existe ese domo
        plaza.delDome("magenta"); // No existe ese domo
        assertArrayEquals(plaza.domes(),domos);
    }
    
    @Test
    public void deberiaLlegarUnTurista() {
        Square plaza = new Square(600,600,4);
        String[] turistas = {"green","black"};
        plaza.touristArrive("green",100,100);
        plaza.touristArrive("black",200,200);
        assertArrayEquals(plaza.tourists(),turistas);
    }
    
    @Test
    public void noDeberiaLlegarUnTurista() {
        Square plaza = new Square(600,600,5);
        String[] turistas = {"green"};
        plaza.touristArrive("green",100,100);
        plaza.touristArrive("black",100,104); // Distancia social (covid)
        plaza.touristArrive("blue", 700, 700); // Coordenadas excedidas
        plaza.touristArrive("yellow", -200, -200); // Distancia no valida
        assertArrayEquals(plaza.tourists(),turistas);
    }
    
    @Test
    public void deberiaMoverseElTurista() {
        Square plaza = new Square(600,600,5);
        // Posicion x, y, angulo esperados
        int[] posicion = {200,400,90}; // El 400 es el cambio a las coordenadas de el Canvas
        plaza.touristArrive("green",100,100);
        plaza.touristMove("green", 200, 200, 90);
        assertArrayEquals(plaza.tourist("green"),posicion);
    }
    
    @Test
    public void noDeberiaMoverseElTurista() {
        Square plaza = new Square(600,600,5);
        // Posiciones x, y, angulo esperados
        int[] posicionBlack = {400, 200,0}; // El 200 es el cambio a las coordenadas de el Canvas
        int[] posicionGreen = {100,500,0}; // El 500 es el cambio a las coordenadas de el Canvas
        plaza.touristArrive("green",100,100);
        plaza.touristArrive("black",400,400);
        plaza.touristMove("black", 100, 104, 180); // No deberia moverse por la distancia social (covid)
        assertArrayEquals(plaza.tourist("black"),posicionBlack); // Deberia tener la misma posicion sin moverse
        plaza.touristMove("green", 700, 700, 0); // No se deja salir de la plaza los turistas dimension 600x600
        assertArrayEquals(plaza.tourist("green"),posicionGreen); // Deberia tener la misma posicion sin moverse
    }
    
    @Test
    public void deberiaTomarUnaFoto() {
        int[] dimensions = {600,600};
        int[][] domes = {{100,200},{400,300},{300,500}};
        int[] desiredView = {3,1,2};
        // El null es porque deberian salir 3 domos en la foto segun desiredView 
        String[] imagen = {"blue","yellow",null}; 
        Square plaza = new Square(dimensions,domes,desiredView);
        plaza.touristArrive("green",200,300);
        String[] foto = plaza.touristTakePhoto("green");
        assertArrayEquals(foto,imagen);
    }
    
    @Test
    public void noDeberiaTomarUnaFoto() {
        int[] dimensions = {600,600};
        int[][] domes = {{100,200},{400,300},{300,500}};
        int[] desiredView = {3,1,2};
        // El null es porque deberian salir 3 domos en la foto segun desiredView 
        String[] imagen = {"black","yellow",null}; // No hay un domo negro en la plaza
        Square plaza = new Square(dimensions,domes,desiredView);
        plaza.touristArrive("green",200,300);
        String[] foto = plaza.touristTakePhoto("green");
        assertFalse((foto).equals(imagen));
    }
    
    @Test
    public void deberiaTomarUnaFotoConAnguloEspecifico() {
        int[] dimensions = {600,600};
        int[][] domes = {{100,200},{400,300},{300,500}};
        int[] desiredView = {3,1,2};
        // Los null es porque deberian salir 3 domos en la foto segun desiredView 
        String[] imagen = {"red",null,null}; 
        Square plaza = new Square(dimensions,domes,desiredView);
        plaza.touristArrive("green",200,300);
        String[] foto = plaza.touristTakePhoto("green", 180);
        assertArrayEquals(foto,imagen);
    }
    
    @Test
    public void noDeberiaTomarUnaFotoConAnguloEspecifico() {
        int[] dimensions = {600,600};
        int[][] domes = {{100,200},{400,300},{300,500}};
        int[] desiredView = {3,1,2};
        // Los null es porque deberian salir 3 domos en la foto segun desiredView 
        String[] imagen = {"red","blue",null}; // No esta el domo azul en la foto
        Square plaza = new Square(dimensions,domes,desiredView);
        plaza.touristArrive("green",200,300);
        String[] foto = plaza.touristTakePhoto("green", 180);
        assertFalse((foto).equals(imagen));
    }
    
    @Test
    public void deberiaEntregarLosDomosEnLaPlaza() {
        Square plaza = new Square(600,600,4);
        String[] domos = {"red","blue","yellow","magenta","black"};
        plaza.addDome("red",100,100);
        plaza.addDome("blue",200,200);
        plaza.addDome("yellow",300,300);
        plaza.addDome("magenta",400,400);
        plaza.addDome("black",500,500);
        assertArrayEquals(plaza.domes(),domos);
    }
    
    @Test
    public void noDeberiaEntregarLosDomosEnLaPlaza() {
        Square plaza = new Square(600,600,4);
        String[] domos = {"red","blue","yellow","magenta","black"};
        assertFalse((plaza.domes()).equals(domos)); // No hay domos en la plaza
    }
    
    @Test
    public void deberiaEntregarLosTuristasEnLaPlaza() {
        Square plaza = new Square(600,600,4);
        String[] turistas = {"green","black"};
        plaza.touristArrive("green",100,100);
        plaza.touristArrive("black",200,200);
        assertArrayEquals(plaza.tourists(),turistas);
    }
    
    @Test
    public void noDeberiaEntregarLosTuristasEnLaPlaza() {
        Square plaza = new Square(600,600,4);
        String[] turistas = {"green","black"};
        assertFalse((plaza.tourists()).equals(turistas)); // No hay turistas en la plaza
    }
    
    @Test
    public void deberiaEntregarLaInformacionActualDelDomo() {
        int[] dimensions = {600,600};
        int[][] domes = {{100,200},{400,300},{300,500}};
        int[] desiredView = {3,1,2};
        Square plaza = new Square(dimensions,domes,desiredView);
        int[] informacionEsperada = {100,400}; // El 400 es el cambio a las coordenadas de el Canvas
        assertArrayEquals(plaza.dome("red"),informacionEsperada);
    }
    
    @Test
    public void noDeberiaEntregarLaInformacionActualDelDomo() {
        int[] dimensions = {600,600};
        int[][] domes = {{100,200},{400,300},{300,500}};
        int[] desiredView = {3,1,2};
        Square plaza = new Square(dimensions,domes,desiredView);
        int[] informacionEsperada = {100,400}; // El 400 es el cambio a las coordenadas de el Canvas
        assertFalse((plaza.dome("black")).equals(informacionEsperada)); // El domo negro no esta en la plaza
    }
    
    @Test
    public void deberiaEntregarLaInformacionActualDelTurista() {
        Square plaza = new Square(600,600,4);
        int[] informacionEsperada = {100,500,0}; // El 500 es el cambio a las coordenadas de el Canvas
        plaza.touristArrive("green",100,100);
        assertArrayEquals(plaza.tourist("green"),informacionEsperada);
    }
    
    @Test
    public void noDeberiaEntregarLaInformacionActualDelTurista() {
        Square plaza = new Square(600,600,4);
        int[] informacionEsperada = {100,500,0}; // El 500 es el cambio a las coordenadas de el Canvas
        plaza.touristArrive("green",100,100);
        assertFalse((plaza.tourist("black")).equals(informacionEsperada));
    }
    
    @Test
    public void deberiaTerminarElSimulador() {
        int[] dimensions = {600,600};
        int[][] domes = {{100,200},{400,300},{300,500}};
        int[] desiredView = {3,1,2};
        Square plaza = new Square(dimensions,domes,desiredView);
        plaza.touristArrive("green",100,100);
        plaza.touristArrive("black",200,200);
        plaza.finish();
        String[] domosEsperados = new String[0];
        String[] turistasEsperados = new String[0];
        assertArrayEquals(plaza.domes(),domosEsperados);
        assertArrayEquals(plaza.tourists(),turistasEsperados);
    }
    
    /**
     * Tears down the test fixture.

     * Called after every test case method.
     */
    @After
    public void tearDown() 
    {
    }
}
