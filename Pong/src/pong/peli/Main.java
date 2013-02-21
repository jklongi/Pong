
package pong.peli;

import javax.swing.SwingUtilities;
import pong.gui.Kayttoliittyma;

/**
 * Pelkkä main luokka joka luo käyttöliittymän
 * 
 */

public class Main {


    public static void main(String[] args) {
        Peli peli = new Peli();
        Kayttoliittyma liittyma = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(liittyma);
        
        while (liittyma.getPiirtoalusta() == null) {
            try {
            } catch (Exception e) {
                System.out.println("Piirtoalustaa ei ole vielä luotu");
            }
        }
        peli.setPiirtoalusta(liittyma.getPiirtoalusta());
        peli.setKayttoliittyma(liittyma);
        
    }
}