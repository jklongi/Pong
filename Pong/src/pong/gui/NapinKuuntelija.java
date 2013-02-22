package pong.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import pong.peli.Peli;

/**
 * Kuuntelee nappien klikkaukset ja asettaa niille toiminnot.
 */
public class NapinKuuntelija implements ActionListener {

    private JButton aloita;
    private JButton lopeta;
    private JButton ohjeet;
    private JTextField pelaaja1;
    private JTextField pelaaja2;
    private Peli peli;

    /**
     * Konstruktori saa parametrinaan napit, tekstikentät, sekä pelin
     *
     * @param aloita uusi peli nappi
     * @param lopeta lopeta peli nappi
     * @param ohjeet ohjeet nappi
     * @param pelaaja1 tekstikenttä joka sisältää pelaajan 1 nimen
     * @param pelaaja2 tekstikenttä joka sisältää pelaajan 2 nimen
     * @param peli
     */
    public NapinKuuntelija(JButton aloita, JButton lopeta, JButton ohjeet,
            JTextField pelaaja1, JTextField pelaaja2, Peli peli) {
        this.aloita = aloita;
        this.lopeta = lopeta;
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
        this.ohjeet = ohjeet;
        this.peli = peli;
    }

    /**
     * Lopeta napista koko frame sulkeutuu, tai jos peli on päällä palaa se
     * valikkoon.
     *
     * Aloita napista itse pong-peli alkaa, jos peli on päällä ei tapahdu
     * mitään.
     *
     * Ohjeet nappi aukaisee uuden ohjeet ikkunan
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == aloita) {
            if (!peli.kaynnissa()) {
                peli.uusiPeli(haeNimi(pelaaja1), haeNimi(pelaaja2));
            }
        }
        if (ae.getSource() == lopeta) {
            if (!peli.kaynnissa()) {
                System.exit(0);
            } else {
                peli.lopeta();
            }
        }

        if (ae.getSource() == ohjeet) {
            Ohjeet ohj = new Ohjeet();
            ohj.run();
        }

    }

    /**
     * Poimii pelaajien nimet nimikentistä. Mikäli pelaajat eivät kirjoita
     * mitään tekstikenttään nimeksi valitaan "Nimetön", tai jos nimi on yli 10
     * merkkiä pitkä siitä leikataan kaikki yli 10 menevät merkit.
     *
     * @param pelaaja
     * @return pelaajan nimi
     */
    private String haeNimi(JTextField pelaaja) {
        if (pelaaja.getText().isEmpty()) {
            return "Nimetön";
        } else if (pelaaja.getText().length() >= 10) {
            String nimi = pelaaja.getText();
            nimi = nimi.substring(0, 10);
            return nimi;
        } else {
            return pelaaja.getText();
        }
    }
}
