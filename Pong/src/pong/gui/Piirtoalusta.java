package pong.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import pong.peli.Peli;
import pong.tulokset.Lukija;

/**
 * Luokka kutsuu pelin piirrä metodia, joka taas
 * kutsuu jokaisen olion omaa piirrä metodia
 * @author Joonas
 */
public class Piirtoalusta extends JPanel {

    private Peli peli;

    public Piirtoalusta(Peli peli) {
        this.peli = peli;

    }

    /**
     * Metodi maalaa oikea komponentit
     * riippuen onko peli käynnissä
     * @param graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        if (peli.kaynnissa()) {
            maalaaPeli(graphics);
        } else {
            maalaaTulokset(graphics);
        }
    }
    /**
     * Kutsuu pelin maalaa metodia, joka kutsuu
     * olioiden maalaa metodia
     * @param graphics 
     */
    private void maalaaPeli(Graphics graphics) {
        graphics.setColor(Color.darkGray);
        graphics.fillRect(0, 0, 600, 450);
        peli.maalaa(graphics);
        repaint();
        revalidate();
    }
    /**
     * Lukee tulokset lukijan avulla listaan, ja tämän jälkeen
     * piirtää ne 
     * @param graphics 
     */
    private void maalaaTulokset(Graphics graphics) {
        graphics.setColor(Color.darkGray);
        graphics.fillRect(0, 0, 600, 450);

        graphics.setColor(new Color(56, 199, 229));
        graphics.drawString("Viimeisimmät pelitulokset:", 20, 20);
        Lukija lukija = new Lukija();
        ArrayList<String> tulokset = lukija.lue();
        for (int i = 0; i < tulokset.size(); i++) {
            graphics.drawString(tulokset.get(i), 20, 30 + (i + 1) * 20);
        }
    }
}
