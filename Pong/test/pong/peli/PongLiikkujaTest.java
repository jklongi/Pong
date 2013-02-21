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
import pong.domain.Pallo;


    

public class PongLiikkujaTest {
    private Peli peli;
    private PongLiikkuja liikkuja;
    private Lauta lautaVasen;
    private Pallo pallo;
    private Lauta lautaOikea;
    
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
        peli = new Peli();
        peli.luoPelaajat("Pekka", "Ville");
        liikkuja = new PongLiikkuja(peli);  
        pallo = peli.getPallo();
        lautaVasen = peli.getLauta(1);
        lautaOikea = peli.getLauta(2);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void arvoSuuntaToimii(){
        liikkuja.arvoSuunta();
        assertTrue(liikkuja.getxSuunta() == 1 || liikkuja.getxSuunta() == -1);
        assertTrue(liikkuja.getySuunta() == 1 || liikkuja.getySuunta() == -1);
    }
    
    @Test
    public void osuukoSeinaanToimiiVasenSeina(){
        liikkuja.setSuunnat(-1, -1);
        pallo.setX(0);
        pallo.setY(10);
        liikkuja.osuukoSeinaan();
        assertEquals(1, liikkuja.getxSuunta());
    }
    @Test
    public void osuukoSeinaanToimiiOikeaSeina(){
        liikkuja.setSuunnat(1, 1);
        pallo.setX(585);
        pallo.setY(10);
        liikkuja.osuukoSeinaan();
        assertEquals(-1, liikkuja.getxSuunta());
    }
    @Test
    public void osuukoSeinaanToimiiYlareuna(){
        liikkuja.setSuunnat(-1, -1);
        pallo.setX(300);
        pallo.setY(0);
        liikkuja.osuukoSeinaan();
        assertEquals(1, liikkuja.getySuunta());
    }
    @Test
    public void osuukoSeinaanToimiiAlareuna(){
        liikkuja.setSuunnat(1, 1);
        pallo.setX(300);
        pallo.setY(385);
        liikkuja.osuukoSeinaan();
        assertEquals(-1, liikkuja.getySuunta());
    }
    @Test
    public void osuukoSeinaanToimiiVasenYlakulma(){
        liikkuja.setSuunnat(-1, -1);
        pallo.setX(0);
        pallo.setY(0);
        liikkuja.osuukoSeinaan();
        assertEquals(1, liikkuja.getxSuunta());
        assertEquals(1, liikkuja.getySuunta());
    }
    @Test
    public void osuukoSeinaanToimiiVasenAlakulma(){
        liikkuja.setSuunnat(-1, 1);
        pallo.setX(0);
        pallo.setY(385);
        liikkuja.osuukoSeinaan();
        assertEquals(1, liikkuja.getxSuunta());
        assertEquals(-1, liikkuja.getySuunta());
    }
    @Test
    public void osuukoSeinaanToimiiOikeaYlakulma(){
        liikkuja.setSuunnat(1, -1);
        pallo.setX(585);
        pallo.setY(0);
        liikkuja.osuukoSeinaan();
        assertEquals(-1, liikkuja.getxSuunta());
        assertEquals(1, liikkuja.getySuunta());
    }
    @Test
    public void osuukoSeinaanToimiiOikeaAlakulma(){
        liikkuja.setSuunnat(1, 1);
        pallo.setX(585);
        pallo.setY(385);
        liikkuja.osuukoSeinaan();
        assertEquals(-1, liikkuja.getxSuunta());
        assertEquals(-1, liikkuja.getySuunta());
    }
    @Test
    public void osuukoSeinaanAsettaaPisteenPelaajalle1(){
        pallo.setX(585);
        pallo.setY(0);
        liikkuja.osuukoSeinaan();
        assertEquals(1, peli.getPelaaja(1).getPisteet());
    }
    @Test
    public void osuukoSeinaanAsettaaPisteenPelaajalle2(){
        pallo.setX(0);
        pallo.setY(0);
        liikkuja.osuukoSeinaan();
        assertEquals(1, peli.getPelaaja(2).getPisteet());
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
        lautaVasen.setAlas(false);
        lautaVasen.setYlos(false);
        liikkuja.liikutaLautaa();
        liikkuja.liikutaLautaa();
        assertEquals(185, lautaVasen.getY());
    }
    @Test
    public void lautaEiMeneYliRajojen(){
        lautaVasen.setYlos(true);
        for(int i = 0; i < 700; i++){
            liikkuja.liikutaLautaa();
        }
        assertEquals(1, lautaVasen.getY());
    }
    @Test
    public void lautaEiMeneAliRajojen(){
        lautaVasen.setAlas(true);
        for(int i = 0; i < 700; i++){
            liikkuja.liikutaLautaa();
        }
        assertEquals(342, lautaVasen.getY());
    }
    @Test
    public void osuukoVasempaanLautaanToimii(){
        liikkuja.setSuunnat(-1, -1);
        pallo.setX(20);
        pallo.setY(185);
        liikkuja.osuukoLautaan();
        assertEquals(1, liikkuja.getxSuunta());
    }
    @Test
    public void osuukoVasemmanLaudanYlakulmaan(){
        liikkuja.setSuunnat(-1, -1);
        pallo.setX(20);
        pallo.setY(170);
        liikkuja.osuukoLautaan();
        assertEquals(1, liikkuja.getxSuunta());
    }
    @Test
    public void osuukoVasemmanLaudanAlakulmaan(){
        liikkuja.setSuunnat(-1, -1);
        pallo.setX(20);
        pallo.setY(240);
        liikkuja.osuukoLautaan();
        assertEquals(1, liikkuja.getxSuunta());
    }
    @Test
    public void osuukoOikeaanLautaanToimii(){
        liikkuja.setSuunnat(1, 1);
        pallo.setX(560);
        pallo.setY(185);
        liikkuja.osuukoLautaan();
        assertEquals(-1, liikkuja.getxSuunta());
    }
        @Test
    public void osuukoOikeanLaudanYlakulmaan(){
        liikkuja.setSuunnat(1, 1);
        pallo.setX(560);
        pallo.setY(170);
        liikkuja.osuukoLautaan();
        assertEquals(-1, liikkuja.getxSuunta());
    }
    @Test
    public void osuukoOikeanLaudanAlakulmaan(){
        liikkuja.setSuunnat(1, 1);
        pallo.setX(560);
        pallo.setY(240);
        liikkuja.osuukoLautaan();
        assertEquals(-1, liikkuja.getxSuunta());
    }
    @Test 
    public void osuukoVasemmanLaudanYlareunaanToimii(){
        liikkuja.setSuunnat(1, 1);
        pallo.setX(20);
        pallo.setY(170);
        liikkuja.osuukoLaudanReunaan();
        assertEquals(-1, liikkuja.getySuunta());
    }
    @Test 
    public void osuukoVasemmanLaudanYlareunaanJaSeinaanToimii(){
        liikkuja.setSuunnat(1, 1);
        pallo.setX(0);
        pallo.setY(170);
        liikkuja.osuukoLaudanReunaan();
        assertEquals(-1, liikkuja.getySuunta());
    }
        @Test 
    public void osuukoVasemmanLaudanAlareunaanToimii(){
        liikkuja.setSuunnat(-1, -1);
        pallo.setX(20);
        pallo.setY(240);
        liikkuja.osuukoLaudanReunaan();
        assertEquals(1, liikkuja.getySuunta());
    }
    @Test 
    public void osuukoVasemmanLaudanAlareunaanJaSeinaanToimii(){
        liikkuja.setSuunnat(-1, -1);
        pallo.setX(0);
        pallo.setY(240);
        liikkuja.osuukoLaudanReunaan();
        assertEquals(1, liikkuja.getySuunta());
    }
    @Test 
    public void osuukoOikeanLaudanYlareunaanToimii(){
        liikkuja.setSuunnat(1, 1);
        pallo.setX(560);
        pallo.setY(170);
        liikkuja.osuukoLaudanReunaan();
        assertEquals(-1, liikkuja.getySuunta());
    }
    @Test 
    public void osuukoOikeanLaudanYlareunaanJaSeinaanToimii(){
        liikkuja.setSuunnat(1, 1);
        pallo.setX(575);
        pallo.setY(170);
        liikkuja.osuukoLaudanReunaan();
        assertEquals(-1, liikkuja.getySuunta());
    }
    @Test 
    public void osuukoOikeanLaudanAlareunaanToimii(){
        liikkuja.setSuunnat(-1, -1);
        pallo.setX(560);
        pallo.setY(240);
        liikkuja.osuukoLaudanReunaan();
        assertEquals(1, liikkuja.getySuunta());
    }
    @Test 
    public void osuukoOikeanLaudanAlareunaanJaSeinaanToimii(){
        liikkuja.setSuunnat(-1, -1);
        pallo.setX(575);
        pallo.setY(240);
        liikkuja.osuukoLaudanReunaan();
        assertEquals(1, liikkuja.getySuunta());
    }

    
}
