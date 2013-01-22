package Game;

import java.awt.Component;
import java.util.Random;

public class PongLogiikka{
    
    private int xSuunta;
    private int ySuunta;
    
    private Component component;
    private Random random;
    
    private Pallo pallo;
    private Lauta oikea;
    private Lauta vasen;
   
    public PongLogiikka(Pallo pallo, Lauta oikea, Lauta vasen, Component component){
        this.pallo = pallo;
        this.oikea = oikea;
        this.vasen = vasen;
        
        this.component = component;
        
        ArvoSuunta();
    }
    
    public void ArvoSuunta(){
        this.xSuunta = 1;
        this.ySuunta = 1;
    }
    
    public void osuukoSeinaan(){
        
        if( pallo.getX() <= 0){
            this.xSuunta = 1;
        }
        if(pallo.getX() >= 585){
            this.ySuunta = -1;
        }
        if( pallo.getY() <= 0){
            this.ySuunta = 1;
        }
        if(pallo.getY() >= 415){
            this.ySuunta = -1;
        }
        
    }
    
    public void aloita(){
        while(true){
            
            pallo.liiku(this.xSuunta, this.ySuunta);
            osuukoSeinaan();
            component.repaint();
//            Antaa NullPointerExceptionin?
            
            try{
                Thread.sleep(6);

            } catch (Exception e){
                System.out.println("errori:" +e);
            } 
        }
    }  


}
