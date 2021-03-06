package pong.peli;

import java.awt.Graphics;
import javax.swing.Timer;
import pong.domain.Lauta;
import pong.domain.Pallo;
import pong.domain.Pelaaja;
import pong.gui.Kayttoliittyma;
import pong.gui.Piirtoalusta;
import pong.tulokset.Lukija;
import pong.tulokset.Tallentaja;

/**
 * Luokka luo kaikki vaadittavat oliot pelin käynnistykseen
 *
 * @author Joonas
 */
public class Peli {

    /**
     * Muuttujan arvo on true, mikäli peli on käynnissä, muuten false.
     */
    private boolean kaynnissa;
    private Piirtoalusta piirtoalusta;
    private Kayttoliittyma kayttoliittyma;
    private Pallo pallo;
    private Lauta lautaVasen;
    private Lauta lautaOikea;
    private PongLiikkuja liikkuja;
    private Tallentaja tallentaja;
    private Timer timer;
    private AjanKuuntelija ajanKuuntelija;
    private Pelaaja p1;
    private Pelaaja p2;

    /**
     * Konstruktori luo laudat, pallon, liikkujan ja ajastimen.
     */
    public Peli() {
        this.lautaVasen = new Lauta(5, 185);
        this.lautaOikea = new Lauta(575, 185);
        this.pallo = new Pallo();
        this.liikkuja = new PongLiikkuja(this);
        ajanKuuntelija = new AjanKuuntelija(liikkuja);
        timer = new Timer(4, ajanKuuntelija);
        Lukija lukija = new Lukija();
        tallentaja = new Tallentaja(lukija.lue());
    }

    /**
     * luo pelaajat annetuilla nimillä, resetoi pallon ja lautojen paikat, sekä
     * päivittää piirtoalustan ja käyttöliittymän containerin, asettaa käynnissa
     * trueksi, arpoo aloitussuunnan ja käynnistää ajastimen
     *
     * @param p1Nimi pelaajan 1 nimi
     * @param p2Nimi pelaajan 2 nimi
     */
    public void uusiPeli(String p1Nimi, String p2Nimi) {
        luoPelaajat(p1Nimi, p2Nimi);
        kaynnissa = true;
        pallo.reset();
        lautaVasen.reset(5, 185);
        lautaOikea.reset(575, 185);
        kayttoliittyma.paivita();
        piirtoalusta.repaint();
        liikkuja.arvoSuunta();
        timer.start();

    }

    /**
     * Luo uudet pelaajat parametrina annetuilla nimillä
     *
     * @param p1Nimi
     * @param p2Nimi
     */
    public void luoPelaajat(String p1Nimi, String p2Nimi) {
        this.p1 = new Pelaaja(p1Nimi, 50, 30);
        this.p2 = new Pelaaja(p2Nimi, 480, 30);
    }

    /**
     * Asettaa boolean käynnissä falseksi, tallentaa tulokset pelaajille 1 ja 2,
     * päivittää käyttöliittymän containerin, sekä piirtoalustan
     */
    public void lopeta() {
        kaynnissa = false;
        timer.stop();
        tallentaja.kirjoitaTulokset(p1, p2);
        kayttoliittyma.paivita();
        piirtoalusta.repaint();
    }

    public boolean kaynnissa() {
        return this.kaynnissa;
    }

    public void setPiirtoalusta(Piirtoalusta piirtoalusta) {
        this.piirtoalusta = piirtoalusta;
    }

    public Piirtoalusta getPiirtoalusta() {
        return this.piirtoalusta;
    }

    public void setKayttoliittyma(Kayttoliittyma kayttis) {
        this.kayttoliittyma = kayttis;
    }

    /**
     * Palauttaa laudan 1, jos numero = 1, muussa tapauksessa palauttaa laudan 2
     *
     * @param numero laudan numero
     * @return Lauta
     */
    public Lauta getLauta(int numero) {
        if (numero == 1) {
            return lautaVasen;
        } else {
            return lautaOikea;
        }
    }

    /**
     * Palauttaa pelaajan 1 jos numero = 1, muuten palauttaa pelaajan 2
     *
     * @param numero pelaajan numero
     * @return Pelaaja
     */
    public Pelaaja getPelaaja(int numero) {
        if (numero == 1) {
            return p1;
        } else {
            return p2;
        }
    }

    /**
     * Kutsuu jokaisen olion paint metodia
     *
     * @param graphics
     */
    public void maalaa(Graphics graphics) {
        pallo.paint(graphics);
        lautaVasen.piirra(graphics);
        lautaOikea.piirra(graphics);
        p1.paint(graphics);
        p2.paint(graphics);
    }

    /**
     * Asettaa yhden pisteen pelaajalle 1, jos pelaajaNumero = 1, muussa
     * tapauksessa asettaa pisteen pelaajalle 2
     *
     * @param pelaajanNumero
     */
    public void asetaPistePelaajalle(int pelaajanNumero) {
        if (pelaajanNumero == 1) {
            p1.setPiste();
        } else {
            p2.setPiste();
        }
    }

    public Pallo getPallo() {
        return pallo;
    }
    
    public Tallentaja getTallentaja() {
        return tallentaja;
    }
}
