package pong.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pong.peli.Peli;
import pong.sound.Musiikki;

/**
 * Käyttöliittymä luo peli-ikkunan ja lisää siihen komponentit.
 *
 * @author Joonas
 */
public class Kayttoliittyma implements Runnable {

    private Peli peli;
    private JFrame frame;
    private Piirtoalusta piirtoalusta;
    private JTextField pelaaja1;
    private JTextField pelaaja2;

    /**
     * Konstruktori saa parametrinaan pelin.
     *
     * @param peli
     */
    public Kayttoliittyma(Peli peli) {
        this.peli = peli;
    }

    /**
     * Aloittaa musiikin, sekä käynnistää JFramen
     */
    @Override
    public void run() {
        aloitaMusiikki();
        frame = new JFrame("Pong");
        piirtoalusta = new Piirtoalusta(peli);
        frame.setPreferredSize(new Dimension(600, 450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.GRAY);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.paint(frame.getGraphics());
        frame.setFocusable(true);
    }

    /**
     * Luo musiikin.
     */
    private void aloitaMusiikki() {
        Musiikki musiikki = new Musiikki();
        musiikki.play();
    }

    /**
     * Päivittää container olion komponentit boolean arvo käynnissä mukaan.
     */
    public void paivita() {
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.paint(frame.getGraphics());
    }

    /**
     * Clearaa containerin kokonaan, ja piirtää uudelleen sopivat komponentit
     * riippuen onko peli.kaynnissa() true vai false
     *
     * @param container
     */
    private void luoKomponentit(Container container) {
        container.removeAll();
        if (peli.kaynnissa()) {
            luoPeliKomponentit(container);
        } else {
            luoValikkoKomponentit(container);
        }
    }

    /**
     * Luo piirtoalustan, lisää sen, nimikentät, sekä alavalikon containeriin
     *
     * @param container
     */
    private void luoValikkoKomponentit(Container container) {
        container.add(piirtoalusta, BorderLayout.CENTER);
        container.add(luoNimikentta(), BorderLayout.NORTH);
        container.add(luoValikko(), BorderLayout.SOUTH);
    }

    /**
     * Luo piirtoalustan, lisää näppäimistönkuuntelijan frameen, sekä
     * piirtoalustan ja alavalikon containeriin
     *
     * @param container
     */
    private void luoPeliKomponentit(Container container) {
        frame.addKeyListener(new NappaimistonKuuntelija(peli.getLauta(1), peli.getLauta(2)));
        container.add(piirtoalusta, BorderLayout.CENTER);
        container.add(luoValikko(), BorderLayout.SOUTH);
    }

    /**
     * Luo uuden JPanelin, johon lisätään aloita ja lopeta nappi, sekä
     * kuuntelija napeille
     *
     * @return JPanel
     */
    private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton aloita = new JButton("Aloita");
        aloita.setForeground(new Color(56, 199, 229));
        panel.add(aloita);

        JButton lopeta = new JButton("Lopeta");
        lopeta.setForeground(new Color(254, 49, 167));
        panel.add(lopeta);

        JButton ohjeet = new JButton("Ohjeet");
        ohjeet.setForeground(new Color(56, 199, 229));
        panel.add(ohjeet);

        NapinKuuntelija kuuntelija = new NapinKuuntelija(aloita, lopeta, ohjeet, pelaaja1, pelaaja2, peli);
        aloita.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);
        ohjeet.addActionListener(kuuntelija);

        return panel;
    }

    /**
     * Luo uuden JPanelin, jossa on kaksi nimikenttää pelaajien nimille
     *
     * @return JPanel
     */
    private JPanel luoNimikentta() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JLabel nimiKentta1 = new JLabel("Pelaaja 1: ");
        nimiKentta1.setForeground(Color.BLACK);
        this.pelaaja1 = new JTextField();
        JLabel nimiKentta2 = new JLabel("Pelaaja 2: ");
        nimiKentta2.setForeground(Color.BLACK);
        this.pelaaja2 = new JTextField();

        panel.add(nimiKentta1);
        panel.add(pelaaja1);
        panel.add(nimiKentta2);
        panel.add(pelaaja2);

        return panel;

    }

    public Piirtoalusta getPiirtoalusta() {
        return this.piirtoalusta;
    }

    public JFrame getFrame() {
        return frame;
    }
}
