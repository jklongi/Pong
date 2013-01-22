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
public class LautaTest {
    private Lauta vasen;
    private Lauta oikea;
    
    public LautaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.vasen = new Lauta(10, 185);
        this.oikea = new Lauta(575, 185);
    }
    
    @After
    public void tearDown() {
    }
        @Test
    public void lautaOikeaAloittaaOikeastaPaikasta(){
         assertEquals( 575, oikea.getX());
         assertEquals( 185, oikea.getY());  
    }
        @Test
    public void lautaVasenAloittaaOikeastaPaikasta(){
         assertEquals( 10, vasen.getX());
         assertEquals( 185, vasen.getY());  
    }

    @Test
    public void LautaOikeaLiikkuu(){
        oikea.liiku(1);
        assertEquals( 575, oikea.getX());
        assertEquals( 186, oikea.getY());
    }
    @Test
    public void LautaVasenLiikkuu(){
        vasen.liiku(1);
        assertEquals( 10, vasen.getX());
        assertEquals( 186, vasen.getY());
    }
    @Test
    public void LautaOikeaEiMeneYliRajan(){
        oikea.liiku(-210);
        assertEquals(3, oikea.getY());
    }
    
    @Test
    public void LautaOikeaEiMeneAliRajan(){
        oikea.liiku(195);
        assertEquals(377, oikea.getY());
    }
    @Test
    public void LautaVasenEiMeneYliRajan(){
        vasen.liiku(-210);
        assertEquals(3, vasen.getY());
    }
    
    @Test
    public void LautavasenEiMeneAliRajan(){
        vasen.liiku(195);
        assertEquals(377, vasen.getY());
    }
}
