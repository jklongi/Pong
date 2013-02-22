package pong.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextField;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Luokka luo uuden ikkunan jossa lukee ohjeet kummallekkin pelaajalle
 *
 * @author Joonas
 */
public class Ohjeet implements Runnable {

    private JFrame frame;

    public Ohjeet() {
    }

    @Override
    public void run() {
        frame = new JFrame("Ohjeet");
        frame.setPreferredSize(new Dimension(630, 100));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setBackground(Color.GRAY);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo kaksi laatikkoa, joissa lukee kummankin pelaajan ohjeet laudan
     * liikutteluun
     *
     * @param container
     */
    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        String ohjeet1 = "1. Pelaaja: Paina näppäintä W liikuttaaksesi lautaasi ylös ja näppäintä "
                + "S liikuttaaksesi lautaa alas.";
        String ohjeet2 = "2. Pelaaja: Paina näppäintä ↑ liikuttaaksesi lautaasi ylös ja näppäintä "
                + "↓ liikuttaaksesi lautaa alas.";

        TextField area1 = new TextField(ohjeet1);
        area1.setBackground(Color.DARK_GRAY);
        area1.setEditable(false);
        area1.setForeground(Color.WHITE);
        TextField area2 = new TextField(ohjeet2);
        area2.setBackground(Color.DARK_GRAY);
        area2.setEditable(false);
        area2.setForeground(Color.WHITE);

        container.add(area1);
        container.add(area2);
    }
    /**
     * Sulkee ohjeet
     */
    public void sulje(){
        frame.dispose();
    }

    public JFrame getFrame() {
        return frame;
    }
}
