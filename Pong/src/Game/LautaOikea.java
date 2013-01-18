package Game;


import java.awt.Color;
import java.awt.Graphics;

public class LautaOikea {
    private int x;
    private int y;
    
    public LautaOikea(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void piirra(Graphics graphics){
        graphics.setColor(new Color(255, 140, 0));
        graphics.fill3DRect(this.x, this.y, 15, 45, true);
    }
    public void liiku(int xMuutos, int yMuutos){
        if(this.y > 2 && this.y < 378){
            this.y += yMuutos; 
        }
        if(this.y < 2){
            this.y = 3;
        }
        if(this.y > 378){
            this.y = 377;
        }
    }
}