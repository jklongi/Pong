package pong.tulokset;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import pong.domain.Pelaaja;

/**
 *
 * @author joonaslongi
 */
public class Tallentaja {
    
    FileWriter fkirjoittaja;
    BufferedWriter kirjoittaja;
    
    public Tallentaja(){
        try {
            this.fkirjoittaja = new FileWriter("src/pong/tulokset/score.txt", true);
        } catch (IOException ex) {
            System.out.println("Kirjoittajan luominen ei onnistunut, tiedostoa ei löydy");
        }
        this.kirjoittaja = new BufferedWriter(fkirjoittaja);
    }
    /*
     * Kirjoittaa score.txt tiedostoon tulokset
     */
    
    public void kirjoitaTulokset(Pelaaja p1, Pelaaja p2) {
        try {
            kirjoittaja.write("" + p1.getNimi() + " " + p1.getPisteet() + "                " 
                    + p2.getNimi() + " " + p2.getPisteet() + "\n");
            kirjoittaja.close();
        } catch (IOException ex) {
            System.out.println("Kirjoittaminen ei onnistu");
        }
     
    }
}
