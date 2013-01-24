package Game;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Pallo extends JPanel{
    
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

    @Override
    public void paint(Graphics g){
        g.setColor(new Color(255, 140, 0));
        g.fill3DRect(this.x, this.y, 15, 15, true);
        
    }    
    @Override
    public int getX(){
        return this.x;
    }
    @Override
    public int getY(){
        return this.y;
    }

}
