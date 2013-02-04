/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joonaslongi
 */
public class NappaimistonKuuntelijaTest {
    
    public NappaimistonKuuntelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Lauta lauta1 = new Lauta(10, 10);
        Lauta lauta2 = new Lauta(50, 50);
        NappaimistonKuuntelija kuuntelija = new NappaimistonKuuntelija(lauta1, lauta2);
    }
    
    @After
    public void tearDown() {
    }
    
}
