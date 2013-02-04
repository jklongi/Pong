
package Valikko;

import javax.swing.SwingUtilities;

/**
 * Pelkkä main luokka joka luo käyttöliittymän
 * 
 */

public class Valikko {


    public static void main(String[] args) {
        Kayttoliittyma liittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(liittyma);
        
    }
}
