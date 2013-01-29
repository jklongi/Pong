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

    

public class PongLiikkujaTest {
    private Lauta lautaVasen;
    private Lauta lautaOikea;
    private Pallo pallo;
    private Pisteet p1;
    private Pisteet p2;
    private PongPiirto piirto;
    
    private PongLiikkuja liikkuja;
    
    public PongLiikkujaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.lautaVasen = new Lauta(10, 185);
        this.lautaOikea = new Lauta(575, 185);
        this.pallo = new Pallo();
        this.p1 = new Pisteet(50, 30);
        this.p2 = new Pisteet(550, 30);
        this.piirto = new PongPiirto(pallo, lautaVasen, lautaOikea, p1, p1);
        this.liikkuja = new PongLiikkuja(pallo, lautaOikea, lautaVasen,piirto, p1, p2);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void liikutaPalloaToimii(){
        liikkuja.setxSuunta(1);
        liikkuja.setySuunta(1);
        liikkuja.liikutaPalloa();
        assertEquals(281, pallo.getX());
        assertEquals(211, pallo.getY());
    }
    @Test
    public void liikutaLautaaToimiiYlos(){
        lautaVasen.setYlos(true);
        liikkuja.liikutaLautaa();
        assertEquals(184, lautaVasen.getY());
    }
    @Test
    public void liikutaLautaaToimiiAlas(){
        lautaVasen.setAlas(true);
        liikkuja.liikutaLautaa();
        assertEquals(186, lautaVasen.getY());
    }
    @Test
    public void lautaEiLiikuJosFalse(){
        lautaVasen.setAlas(true);
        liikkuja.liikutaLautaa();
        liikkuja.liikutaLautaa();
        lautaVasen.setAlas(false);
        liikkuja.liikutaLautaa();
        liikkuja.liikutaLautaa();
        assertEquals(187, lautaVasen.getY());
    }
    @Test
    public void lautaEiMeneYliRajojen(){
        lautaVasen.setYlos(true);
        for(int i = 0; i < 700; i++){
            liikkuja.liikutaLautaa();
        }
        assertEquals(5, lautaVasen.getY());
    }
    @Test
    public void lautaEiMeneAliRajojen(){
        lautaVasen.setAlas(true);
        for(int i = 0; i < 700; i++){
            liikkuja.liikutaLautaa();
        }
        assertEquals(375, lautaVasen.getY());
    }
    
    
}
