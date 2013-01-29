package Game;


import java.awt.Color;
import java.awt.Graphics;

public class Lauta {
    private int x;
    private int y;
    
    private boolean ylos;
    private boolean alas;
    
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
    public void piirra(Graphics graphics){
        graphics.setColor(new Color(56, 199, 229));
        graphics.fill3DRect(this.x, this.y, 15, 55, true);
    }
    public void liiku(int yMuutos){
        if(this.y > 2 && this.y < 378){
            this.y += yMuutos; 
        }
        if(this.y <= 2){
            this.ylos = false;
            this.y = 5;
        }
        if(this.y >= 378){
            this.alas = false;
            this.y = 375;
        }
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
