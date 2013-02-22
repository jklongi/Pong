package pong.domain;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Luokasta luodaan pallo-olio, jolla on x ja y koordinaatit, joita voi muuttaa.
 * Liikut metodi siirtää pallon x ja y koordinaatteja x ja y muutoksen verran.
 *
 */
public class Pallo {

    private int x;
    private int y;

    /**
     * Konstruktori asettaa pallon aloitussijainnin.
     */
    public Pallo() {
        this.x = 280;
        this.y = 210;
    }

    /**
     * Muuttaa pallon x ja y koordinaatteja xMuutoksen ja yMuutoksen verran =>
     * pallo liikkuu
     *
     * @param xMuutos
     * @param yMuutos
     */
    public void liiku(int xMuutos, int yMuutos) {
        this.x += xMuutos;
        this.y += yMuutos;
    }

    /**
     * Piirtää neliön(Vaikka onkin pallo) this.y, this.x kohtaan
     *
     * @param g Graphics
     */
    public void paint(Graphics g) {
        g.setColor(new Color(254, 49, 167));
        g.fill3DRect(this.x, this.y, 15, 15, true);

    }

    /**
     * Asettaa pallon takaisin aloitussijaintiin.
     */
    public void reset() {
        this.x = 280;
        this.y = 210;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
