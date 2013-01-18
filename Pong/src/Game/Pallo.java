package Game;


import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.Random;

public class Pallo extends Thread{
    
    private int x;
    private int y;
    
    private int xSuunta;
    private int ySuunta;
    
    private LautaVasen vasen;
    private LautaOikea oikea;
            
    private Component component;
    private Random random;
    
    public Pallo(int x, int y, Component component, LautaVasen vasen, LautaOikea oikea){
        this.x = x;
        this.y = y;
        
        this.vasen = vasen;
        this.oikea = oikea;
        
        this.component = component;
        this.random = new Random();
        
        while(true){
            
            this.xSuunta = random.nextInt(3) -1;
            this.ySuunta = random.nextInt(3) -1;
            if(this.xSuunta != 0 || this.ySuunta != 0){
                break;
            }
     
        }

    }

    public void liiku(){
        this.x += xSuunta;
        this.y += ySuunta;
        while(true){

            this.x += xSuunta;
            this.y += ySuunta;
            if(x <= 0){
                this.xSuunta = 1;
            }
            if(x >= 585){
                this.xSuunta = -1;
            }
            if( y <= 0){
                this.ySuunta = 1;
            }
            if(y >= 415){
                this.ySuunta = -1;
            }
            if(this.x == oikea.getX()){
                
            }
            
            try{
                Thread.sleep(6);

            } catch (Exception e){
                System.out.println(e);
            }
            
        }
        
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
    
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public void setxSuunta(int suunta) {
        this.xSuunta = suunta;
    }
    public void setySuunta(int suunta){
        this.ySuunta = suunta;
    }
    public int getxSuunta(){
       return this.xSuunta; 
    }
    public int getySuunta(){
        return this.ySuunta;
    }
    

}
