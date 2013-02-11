
package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

    /**Luokasta luodaan pisteet-olio, jolla on int pisteiden arvo,
     * sekä draw String metodi.
     */

public class Pelaaja {
    
    private int pisteet;
    private int x;
    private int y;
    private String nimi;
    
    /**
     * Pelaajalla on nimi ja pisteet, pisteet ovat alussa 0
     * x ja y koordinantit kertovat mihin nimi ja tulos piirretään
     * @param nimi
     * @param x
     * @param y 
     */
    
    public Pelaaja(String nimi, int x, int y){
        this.nimi = nimi;
        this.pisteet = 0;
        this.x = x;
        this.y = y;
        
    }
    public String getNimi(){
        return this.nimi;
    }
    
    public void setPiste(){
        this.pisteet++;
    }
    
    public int getPisteet(){
        return this.pisteet;
    }
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        Font f = new Font(null, Font.ITALIC, 16);
        g.setFont(f);
        g.drawString(""+ this.nimi + " " + this.pisteet, x, y);
        
    }
    
    @Override
    public String toString(){
        return this.x + ", " + this.y + ", " + this.pisteet;
    }
}
