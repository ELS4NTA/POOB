import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SetTest{

    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    
    @Test
    public void shouldCreateEmptySets(){
        String [] ev ={};        
        assertEquals(0, new Set(ev).size());
    }    
   
    
    @Test
    public void shouldCreateSets(){
        String [] e ={"APPLE", "ORANGE"};        
        assertEquals(2, new Set(e).size());
    }    
    
    
    
    @Test
    public void shouldCompareSets(){
        String [] ev ={};  
        String [] e ={"APPLE", "ORANGE"}; 
        String [] s = {"APPLE", "ORANGE"};
        String [] t = {"ORANGE","APPLE"};
        assertTrue(new Set(ev).equals(new Set(ev)));
        assertTrue(new Set(e).equals(new Set(e)));
        assertFalse(new Set(ev).equals(new Set(e)));
        assertTrue(new Set(s).equals(new Set(t)));
    }  
    
    @Test
    public void shouldNotHaveDuplicateElements(){
        String [] eu ={"APPLE", "ORANGE"};        
        String [] er ={"ORANGE","ORANGE","APPLE"};
        assertEquals(2, new Set(er).size());
        assertEquals(new Set(eu), new Set(er));
    }    
    

    @Test
    public void shouldNotBeCaseSensitive(){     
        String [] eu ={"ORANGE","APPLE"};
        String [] em = {"oRange","apple", "APPLE"};
        assertEquals(2, new Set(em).size());
        assertEquals(new Set(eu), new Set(em));
    }
    
    @Test
    public void shouldConvertToString(){
        String [] ev ={};
        assertEquals("{}", new Set(ev).toString());
        String [] es = {"1","2","3"};
        assertEquals("{1,2,3}", new Set(es).toString());
        String [] ec = {"one","two","three"};
        assertEquals("{ONE,TWO,THREE}", new Set(ec).toString());
    }

    @Test
    public void deberiaUnirConjuntos(){
        String [] setA = {};
        String [] setB = {};
        assertEquals("{}",new Set(setA).union(new Set(setB)).toString());
        String [] setC = {"HOLA","COMO","ESTAS"};
        String [] setD = {};
        assertEquals("{HOLA,COMO,ESTAS}",new Set(setC).union(new Set(setD)).toString());
        String [] setE = {};
        String [] setF = {"MATEMATICAS","BIOLOGIA","QUIMICA"};
        assertEquals("{MATEMATICAS,BIOLOGIA,QUIMICA}",new Set(setE).union(new Set(setF)).toString());        
        String [] setG = {"MATEMATICAS","ECONOMIA","SISTEMAS"};
        String [] setH = {"MATEMATICAS","BIOLOGIA","QUIMICA"};
        assertEquals("{MATEMATICAS,ECONOMIA,SISTEMAS,BIOLOGIA,QUIMICA}",new Set(setG).union(new Set(setH)).toString());        
        // Probando SetCalculator union
        SetCalculator datos = new SetCalculator();
        datos.create("a");
        datos.create("b");
        datos.create("c");
        datos.create("d");
        datos.create("e");
        datos.create("f");
        datos.create("g");
        datos.create("h");
        datos.assign("c",setC);
        datos.assign("f",setF);
        datos.assign("g",setG);
        datos.assign("h",setH);
        datos.assign("union1","a",'u',"b");
        datos.assign("union2","c",'u',"d");
        datos.assign("union3","e",'u',"f");
        datos.assign("union4","g",'u',"h");
        assertEquals("{}",datos.query("union1"));
        assertEquals("{HOLA,COMO,ESTAS}",datos.query("union2"));
        assertEquals("{MATEMATICAS,BIOLOGIA,QUIMICA}",datos.query("union3"));
        assertEquals("{MATEMATICAS,ECONOMIA,SISTEMAS,BIOLOGIA,QUIMICA}",datos.query("union4"));
    }
    
    @Test
    public void deberiaIntersecarConjuntos(){
        String [] setA = {};
        String [] setB = {};
        assertEquals("{}",new Set(setA).intersection(new Set(setB)).toString());
        String [] setC = {"1","2","3","4","5","6","7"};
        String [] setD = {};
        assertEquals("{}",new Set(setC).intersection(new Set(setD)).toString());
        String [] setE = {};
        String [] setF = {"2","4","6","8"};
        assertEquals("{}",new Set(setE).intersection(new Set(setF)).toString());        
        String [] setG = {"1","2","3","4","5","6","7"};
        String [] setH = {"2","4","6","8"};
        assertEquals("{2,4,6}",new Set(setG).intersection(new Set(setH)).toString());        
        // Probando SetCalculator intersection
        SetCalculator datos = new SetCalculator();
        datos.create("a");
        datos.create("b");
        datos.create("c");
        datos.create("d");
        datos.create("e");
        datos.create("f");
        datos.create("g");
        datos.create("h");
        datos.assign("c",setC);
        datos.assign("f",setF);
        datos.assign("g",setG);
        datos.assign("h",setH);
        datos.assign("intersection1","a",'i',"b");
        datos.assign("intersection2","c",'i',"d");
        datos.assign("intersection3","e",'i',"f");
        datos.assign("intersection4","g",'i',"h");
        assertEquals("{}",datos.query("intersection1"));
        assertEquals("{}",datos.query("intersection2"));
        assertEquals("{}",datos.query("intersection3"));
        assertEquals("{2,4,6}",datos.query("intersection4"));
    }
    
        @Test
    public void deberiaOperarlaDiferenciadeConjuntos(){
        String [] setA = {};
        String [] setB = {};
        assertEquals("{}",new Set(setA).difference(new Set(setB)).toString());
        String [] setC = {"1","2","3","4","5","6","7"};
        String [] setD = {};
        assertEquals("{1,2,3,4,5,6,7}",new Set(setC).difference(new Set(setD)).toString());
        String [] setE = {};
        String [] setF = {"2","4","6","8"};
        assertEquals("{}",new Set(setE).difference(new Set(setF)).toString());        
        String [] setG = {"1","2","3","4","5","6","7"};
        String [] setH = {"2","4","6","8"};
        assertEquals("{1,3,5,7}",new Set(setG).difference(new Set(setH)).toString());        
        // Probando SetCalculator difference
        SetCalculator datos = new SetCalculator();
        datos.create("a");
        datos.create("b");
        datos.create("c");
        datos.create("d");
        datos.create("e");
        datos.create("f");
        datos.create("g");
        datos.create("h");
        datos.assign("c",setC);
        datos.assign("f",setF);
        datos.assign("g",setG);
        datos.assign("h",setH);
        datos.assign("difference1","a",'-',"b");
        datos.assign("difference2","c",'-',"d");
        datos.assign("difference3","e",'-',"f");
        datos.assign("difference4","g",'-',"h");
        assertEquals("{}",datos.query("difference1"));
        assertEquals("{1,2,3,4,5,6,7}",datos.query("difference2"));
        assertEquals("{}",datos.query("difference3"));
        assertEquals("{1,3,5,7}",datos.query("difference4"));
    }
    
        @Test
    public void deberiaOperarlaDiferenciaSimetricadeConjuntos(){
        String [] setA = {};
        String [] setB = {};
        assertEquals("{}",new Set(setA).symmetricDifference(new Set(setB)).toString());
        String [] setC = {"1","2","3","4","5","6","7"};
        String [] setD = {};
        assertEquals("{1,2,3,4,5,6,7}",new Set(setC).symmetricDifference(new Set(setD)).toString());
        String [] setE = {};
        String [] setF = {"2","4","6","8"};
        assertEquals("{2,4,6,8}",new Set(setE).symmetricDifference(new Set(setF)).toString());        
        String [] setG = {"1","2","3","4","5","6","7"};
        String [] setH = {"2","4","6","8"};
        assertEquals("{1,3,5,7,8}",new Set(setG).symmetricDifference(new Set(setH)).toString());        
        // Probando SetCalculator symmetricDiference
        SetCalculator datos = new SetCalculator();
        datos.create("a");
        datos.create("b");
        datos.create("c");
        datos.create("d");
        datos.create("e");
        datos.create("f");
        datos.create("g");
        datos.create("h");
        datos.assign("c",setC);
        datos.assign("f",setF);
        datos.assign("g",setG);
        datos.assign("h",setH);
        datos.assign("symmetricDifference1","a",'_',"b");
        datos.assign("symmetricDifference2","c",'_',"d");
        datos.assign("symmetricDifference3","e",'_',"f");
        datos.assign("symmetricDifference4","g",'_',"h");
        assertEquals("{}",datos.query("symmetricDifference1"));
        assertEquals("{1,2,3,4,5,6,7}",datos.query("symmetricDifference2"));
        assertEquals("{2,4,6,8}",datos.query("symmetricDifference3"));
        assertEquals("{1,3,5,7,8}",datos.query("symmetricDifference4"));
    }
    
    @Test
    public void deberiaOperarelProductoCartesianodeConjuntos(){
        String [] setA = {};
        String [] setB = {};
        assertEquals("{}",new Set(setA).cartesianProduct(new Set(setB)).toString());
        String [] setC = {"1","2","3","4","5","6","7"};
        String [] setD = {};
        assertEquals("{}",new Set(setC).cartesianProduct(new Set(setD)).toString());
        String [] setE = {};
        String [] setF = {"2","4","6","8"};
        assertEquals("{}",new Set(setE).cartesianProduct(new Set(setF)).toString());        
        String [] setG = {"1","3","5"};
        String [] setH = {"2","4","6"};
        assertEquals("{(1,2),(1,4),(1,6),(3,2),(3,4),(3,6),(5,2),(5,4),(5,6)}",new Set(setG).cartesianProduct(new Set(setH)).toString());        
        // Probando SetCalculator symmetricDiference
        SetCalculator datos = new SetCalculator();
        datos.create("a");
        datos.create("b");
        datos.create("c");
        datos.create("d");
        datos.create("e");
        datos.create("f");
        datos.create("g");
        datos.create("h");
        datos.assign("c",setC);
        datos.assign("f",setF);
        datos.assign("g",setG);
        datos.assign("h",setH);
        datos.assign("cartesianProduct1","a",'x',"b");
        datos.assign("cartesianProduct2","c",'x',"d");
        datos.assign("cartesianProduct3","e",'x',"f");
        datos.assign("cartesianProduct4","g",'x',"h");
        assertEquals("{}",datos.query("cartesianProduct1"));
        assertEquals("{}",datos.query("cartesianProduct2"));
        assertEquals("{}",datos.query("cartesianProduct3"));
        assertEquals("{(1,2),(1,4),(1,6),(3,2),(3,4),(3,6),(5,2),(5,4),(5,6)}",datos.query("cartesianProduct4"));
    }    
    
    @Test
    public void elementoQuePerteneceAlConjunto(){
        String [] setA = {"1","2","3","4","5","6","7"};
        String [] setB = {};
        assertTrue(new Set(setA).contains("5"));
        assertFalse(new Set(setB).contains("5"));
        SetCalculator datos = new SetCalculator();
        datos.create("a");
        datos.create("b");
        datos.assign("a",setA);
        assertTrue(datos.pertenece("a","5"));
        assertFalse(datos.pertenece("b","5"));
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
