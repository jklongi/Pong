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
public class PalloTest {
    
    private Pallo pallo;
    
    public PalloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.pallo = new Pallo();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void palloAloittaaOikeastaPaikasta(){
         assertEquals( 280, pallo.getX() );
         assertEquals( 210, pallo.getY() );
    }
    @Test
    public void palloLiikkuu(){
        pallo.liiku(1, 1);
        assertEquals( 281, pallo.getX() );
        assertEquals( 211, pallo.getY() );    
    }
}
