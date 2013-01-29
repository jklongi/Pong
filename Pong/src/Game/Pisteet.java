
package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Pisteet {
    
    private int pisteet;
    private int x;
    private int y;
    
    public Pisteet(int x, int y){
        this.pisteet = 0;
        this.x = x;
        this.y = y;
        
    }
    
    public void setPiste(){
        this.pisteet++;
    }
    
    public int getPisteet(){
        return this.pisteet;
    }
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        Font f = new Font(null, Font.ITALIC, 18);
        g.setFont(f);
        g.drawString("" + this.pisteet, x, y);
    }
    
    @Override
    public String toString(){
        return this.x + ", " + this.y + ", " + this.pisteet;
    }
}
