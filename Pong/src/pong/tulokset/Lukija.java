package pong.tulokset;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lukee tekstitedostoja
 *
 * @author Joonas
 */
public class Lukija {

    private ArrayList<String> tulos;
    /**
     * Konstruktori luo ArrayListin
     */
    public Lukija() {
        this.tulos = new ArrayList<String>();
    }

    /**
     * Lukee tiedodsosta tulokset ja lisää ne ArrayListiin
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> lue() {

        try {
            File tiedosto = new File("src/pong/tulokset/score.txt");
            Scanner lukija = new Scanner(tiedosto);
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                tulos.add(rivi);

            }

        } catch (Exception e) {
            System.out.println("Tuloksia ei luettu");
        }

        return tulos;

    }

   
}
