
package Valikko;

import javax.swing.SwingUtilities;

public class Valikko {


    public static void main(String[] args) {
        Kayttoliittyma liittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(liittyma);
        
    }
}
