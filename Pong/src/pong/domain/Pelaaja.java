package pong.domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Luokka luo pelaaja-olion, jolla on nimi, pisteet, sekä koordinaatit johon
 * tulokset piirretään pelin aikana
 *
 * @author Joonas
 */
public class Pelaaja {

    /**
     * Pelaajan pisteet.
     */
    private int pisteet;
    /**
     * Kohta johon pelaajan nimi piirretään x-koordinaatti.
     */
    private int x;
    /**
     * Kohta johon pelaajan nimi piirretään y-koodinaatti.
     */
    private int y;
    /**
     * Pelaajan nimi.
     */
    private String nimi;

    /**
     * Pelaajalla on nimi ja pisteet, pisteet ovat alussa 0 x ja y koordinaatit
     * kertovat mihin nimi ja tulos piirretään
     *
     * @param nimi
     * @param x
     * @param y
     */
    public Pelaaja(String nimi, int x, int y) {
        this.nimi = nimi;
        this.pisteet = 0;
        this.x = x;
        this.y = y;

    }

    public String getNimi() {
        return this.nimi;
    }

    public void setPiste() {
        this.pisteet++;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    /**
     * Piirtää Stringinä nimen + pisteet this.x, this.y kohdalle
     *
     * @param g
     */
    public void paint(Graphics g) {
        g.setColor(new Color(56, 199, 229));
        Font f = new Font("Helvetica", Font.ITALIC, 14);
        g.setFont(f);
        g.drawString("" + this.nimi + " " + this.pisteet, x, y);

    }

    @Override
    public String toString() {
        return this.x + ", " + this.y + ", " + this.pisteet;
    }
}
