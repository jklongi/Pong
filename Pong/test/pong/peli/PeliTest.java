/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.peli;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pong.domain.Lauta;
import pong.domain.Pelaaja;
import pong.gui.Kayttoliittyma;
import pong.gui.Piirtoalusta;

/**
 *
 * @author Joonas
 */
public class PeliTest {
    private Peli peli;
    public PeliTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.peli = new Peli();
        peli.luoPelaajat("Arno", "Pekka");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getPelaaja1Toimii(){
        Pelaaja pelaaja = peli.getPelaaja(1);
        assertEquals("Arno", pelaaja.getNimi());
    }
    @Test
    public void getPelaaja2Toimii(){
        Pelaaja pelaaja = peli.getPelaaja(2);
        assertEquals("Pekka", pelaaja.getNimi());
    }
    @Test
    public void asettaaPisteenPelaajalle1(){
        peli.asetaPistePelaajalle(1);
        assertEquals(1,peli.getPelaaja(1).getPisteet());
    }
    @Test
    public void asettaaPisteenPelaajalle2(){
        peli.asetaPistePelaajalle(2);
        assertEquals(1,peli.getPelaaja(2).getPisteet());
    }
    @Test 
    public void getLautaVasenToimii(){
        Lauta uusi = peli.getLauta(1);
        assertEquals(5, uusi.getX());
        assertEquals(185, uusi.getY());
    }
        @Test 
    public void getLautaOikeaToimii(){
        Lauta uusi = peli.getLauta(2);
        assertEquals(575, uusi.getX());
        assertEquals(185, uusi.getY());
    }
}
