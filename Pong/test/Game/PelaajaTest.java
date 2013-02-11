
package Game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {
    private Pelaaja pisteet;
    
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
        this.pisteet = new Pelaaja("pekka" , 10,5);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void pisteetLisaantyy(){
        pisteet.setPiste();
        assertEquals(1, pisteet.getPisteet());
        
    }
    
    @Test
    public void pisteetToStringToimii(){
        pisteet.setPiste();
        pisteet.setPiste();
        assertEquals("10, 5, 2", pisteet.toString());
    }
}