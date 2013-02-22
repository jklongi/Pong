package pong.domain;


import java.awt.Color;
import java.awt.Graphics;


/**
* Luokasta luodaan Lauta-olio, jolla on x ja y koordinantti, 
* sekä metodit piirrä ja liiku. Olio liikkuu suuntaan jonka
* arvo on true 
*/

public class Lauta {
    private int x;
    private int y;
    
    /**
     * Muuttuja ylös on true, mikäli laudan halutaan liikkuvan
     * ylös, muuten false.
     */
    private boolean ylos;
    /**
     * Muuttuja alas on true, mikäli laudan halutaan liikkuvan
     * alas, muuten false.
     */
    private boolean alas;
    
    /**
     * Laudalla on x ja y koordinaatit, sekä boolean muuttuja
     * joka kertoo mihin suuntaan lauta on menossa
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Lauta(int x, int y){
        this.x = x;
        this.y = y;
        this.ylos = false;
        this.alas = false;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    /**
     * Piirtää laudan this.x, this.y kohtaan
     * @param graphics 
     */
    public void piirra(Graphics graphics){
        graphics.setColor(new Color(56, 199, 229));
        graphics.fill3DRect(this.x, this.y, 15, 55, true);
    }
    /**
     * Liikuttaa lautaa yMuutoksen mukaisesti tarkistaen samalla ettei
     * lauta jää jumiin ääriarvokohdissa
     * @param yMuutos 
     */
    public void liiku(int yMuutos){
        if(this.y > 0 && this.y < 343){
            this.y += yMuutos; 
        }
        if(this.y <= 0){
            this.ylos = false;
            this.y = 1;
        }
        if(this.y >= 343){
            this.alas = false;
            this.y = 342;
        }
    }
    /**
     * Resetoi laudan sijainnin, muuttujina
     * annettuihin arvoihin.
     * @param x
     * @param y 
     */
    public void reset(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public boolean ylos(){
        return this.ylos;
    }
    public boolean alas(){
        return this.alas;
    }
    public void setAlas(boolean arvo){
        this.alas = arvo;
    }
    public void setYlos(boolean arvo){
        this.ylos = arvo;
    }
}
