/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.peli;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import pong.domain.Lauta;
import pong.domain.Pallo;
import pong.domain.Pelaaja;
import pong.gui.Kayttoliittyma;
import pong.gui.Piirtoalusta;
import pong.tulokset.Tallentaja;

/**
 *
 * @author Joonas
 */
public class Peli {
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
    
    public Peli() {
        this.lautaVasen = new Lauta(5, 185);
        this.lautaOikea = new Lauta(575, 185);
        this.pallo = new Pallo();
        this.liikkuja = new PongLiikkuja(this);
        ajanKuuntelija = new AjanKuuntelija(liikkuja);
        timer = new Timer(4, ajanKuuntelija);
    }
    
    public void uusiPeli(String p1Nimi, String p2Nimi) {
        luoPelaajat(p1Nimi, p2Nimi);
        pallo.reset();
        lautaVasen.reset(5, 185);
        lautaOikea.reset(575, 185);
        piirtoalusta.repaint();
        kaynnissa = true;
        kayttoliittyma.paivita();
        liikkuja.arvoSuunta();
        timer.start();

    }
    
    public void luoPelaajat(String p1Nimi, String p2Nimi) {
        this.p1 = new Pelaaja(p1Nimi, 50, 30);
        this.p2 = new Pelaaja(p2Nimi, 480, 30);
    }
    
    public void lopeta() {
        kaynnissa = false;
        timer.stop();
        tallentaja = new Tallentaja();
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
    
    public Lauta getLauta(int numero) {
        if (numero == 1){
            return lautaVasen;
        } else {
            return lautaOikea;
        }
    }
        
    public Pelaaja getPelaaja(int numero) {
        if (numero == 1){
            return p1;
        } else {
            return p2;
        }
    }

    public void maalaa(Graphics graphics) {
        pallo.paint(graphics);
        lautaVasen.piirra(graphics);
        lautaOikea.piirra(graphics);
        p1.paint(graphics);
        p2.paint(graphics);
    }
    public void asetaPistePelaajalle(int pelaajanNumero){
        if(pelaajanNumero == 1){
            p1.setPiste();
        } else{
            p2.setPiste();
        }
    }
    public Pallo getPallo() {
        return pallo;
    }
}
