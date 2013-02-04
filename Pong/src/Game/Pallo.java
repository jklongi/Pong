package Game;


import java.awt.Color;
import java.awt.Graphics;

    /**Luokasta luodaan pallo-olio, jolla on x ja y koordinantit, 
    * joita voi muuttaa. Liikut metodi siirtää pallon x ja y koordinantteja
    * x ja y muutoksen verran.
    * 
    */

public class Pallo{
    
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



    public void paint(Graphics g){
        g.setColor(new Color(254, 49, 167));
        g.fill3DRect(this.x, this.y, 15, 15, true);
        
    }    
   

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

}
