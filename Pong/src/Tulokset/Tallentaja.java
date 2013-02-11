package Tulokset;

import Game.Pelaaja;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author joonaslongi
 */
public class Tallentaja {
    
    FileWriter fkirjoittaja;
    BufferedWriter kirjoittaja;
    
    public Tallentaja() throws Exception{
        this.fkirjoittaja = new FileWriter("src/Tulokset/score.txt", true);
        this.kirjoittaja = new BufferedWriter(fkirjoittaja);
    }
    /*
     * Kirjoittaa score.txt tiedostoon tulokset
     */
    
    public void kirjoitaTulokset(Pelaaja p1, Pelaaja p2) throws Exception{
        kirjoittaja.append("" + p1.getNimi() + " " + p1.getPisteet() + "                " + p2.getNimi() + " " + p2.getPisteet() + "\n");
        kirjoittaja.close();
    }
}
