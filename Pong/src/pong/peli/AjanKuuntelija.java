/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka käyttää liikkujan metodeja luoden
 * pelin liikkeen
 * @author Joonas
 */
public class AjanKuuntelija implements ActionListener {

    private PongLiikkuja liikkuja;

    public AjanKuuntelija(PongLiikkuja liikkuja) {
        this.liikkuja = liikkuja;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        liikkuja.liikutaLautaa();
        liikkuja.liikutaPalloa();
        liikkuja.osuukoSeinaan();
        liikkuja.osuukoLautaan();
        liikkuja.osuukoLaudanReunaan();
    }
}
