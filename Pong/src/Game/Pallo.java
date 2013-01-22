package Game;


import java.awt.Color;
import java.awt.Graphics;


public class Pallo extends Thread{
    
    private int x;
    private int y;
    
    public Pallo(){
        this.x = 280;
        this.y = 210;
    }

    public void liiku(int xMuutos, int yMuutos){
        this.x += xMuutos;
        this.y += yMuutos;
    }

    public void piirra(Graphics g){
        g.setColor(new Color(255, 140, 0));
        g.fill3DRect(this.x, this.y, 15, 15, true);
        
    }    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

}
