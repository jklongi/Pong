package pong.tulokset;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pong.domain.Pelaaja;

/**
 * Tallentaa pelitulokset
 * @author joonaslongi
 */
public class Tallentaja {
    /**
     * Tuloslistan maksimikoko on 15. Vain 15 viimeisintä tulosta pidetään tallessa
     */
    public static final int MAKSIMIKOKO = 15;
    private FileWriter fkirjoittaja;
    private BufferedWriter kirjoittaja;
    /**
     * Lista, joka pitää sisällään luetut tulokset, ja johon uusimmat tulokset lisätään.
     */
    private ArrayList<String> tulokset;
    
    /**
     * Konstruktori saa parametrinaan tulokset-listan
     * @param tulokset 
     */
    public Tallentaja(ArrayList<String> tulokset){
        this.tulokset = tulokset;
    }
    /**
     * Kirjoittaa score.txt tiedostoon tulokset
     * Lisää uuden tuloksen ArrayListiin
     */
    
    public void kirjoitaTulokset(Pelaaja p1, Pelaaja p2) {
        tulokset.add(0, "" + p1.getNimi() + " " + p1.getPisteet() + "                " 
                    + p2.getNimi() + " " + p2.getPisteet());
        siisti();
        String tulos = teeString();
        try {
            this.fkirjoittaja = new FileWriter("src/pong/tulokset/score.txt");
        } catch (IOException ex) {
            System.out.println("Kirjoittajan luominen ei onnistunut, tiedostoa ei löydy");
        }
        this.kirjoittaja = new BufferedWriter(fkirjoittaja);
        
        try {
            kirjoittaja.write(tulos);
            kirjoittaja.close();
        } catch (IOException ex) {
            System.out.println("kirjoitus ei onnistunut");;
        }
      
    }
    /**
     * Tekee Sringin luoken tulokset-listasta
     * @return tulos
     */
    
    private String teeString() {
        String tulos="";
        for (int i = 0; i < tulokset.size(); i++) {
            tulos += tulokset.get(i)+"\n";        
        }
        return tulos;
    }
    
     /**
     * Siistii listasta rekursiivisesti kaikki alkiot yli maksimikoon
     */
    public void siisti() {
        if (tulokset.size() <= MAKSIMIKOKO) {
            return;
        }
        if (this.tulokset.size() > MAKSIMIKOKO) {
            tulokset.remove(tulokset.size() - 1);
        }
        siisti();
    }

    public ArrayList<String> getTulokset() {
        return tulokset;
    }
}
