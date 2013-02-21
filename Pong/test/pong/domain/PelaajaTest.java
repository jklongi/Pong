
package pong.domain;

import pong.domain.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {
    private Pelaaja pelaaja;
    
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja("pekka" , 10,5);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void pisteetLisaantyy(){
        pelaaja.setPiste();
        assertEquals(1, pelaaja.getPisteet());
        
    }
    @Test
    public void nimiToimii(){
        assertEquals("pekka", pelaaja.getNimi());
    }
    
    @Test
    public void pisteetToStringToimii(){
        pelaaja.setPiste();
        pelaaja.setPiste();
        assertEquals("10, 5, 2", pelaaja.toString());
    }
}
