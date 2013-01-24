package Game;

import java.awt.Component;

public class PongLiikkuja {
    private Pallo pallo;
    private Lauta oikea;
    private Lauta vasen;
    
    private Component component;
    
    private int xSuunta;
    private int ySuunta;
    
    public PongLiikkuja(Pallo pallo, Lauta oikea, Lauta vasen, Component component){
        this.pallo = pallo;
        this.oikea = oikea;
        this.vasen = vasen;
        this.component = component;

        
        ArvoSuunta();
    }    
    
    private void ArvoSuunta(){
        this.xSuunta = 1;
        this.ySuunta = 1;
        
    }
    
    public void osuukoSeinaan(){
        if( pallo.getX() <= 0){
            this.xSuunta = 1;
        }
        if(pallo.getX() >= 585){
            this.xSuunta = -1;
        }
        if( pallo.getY() <= 0){
            this.ySuunta = 1;
        }
        if(pallo.getY() >= 415){
            this.ySuunta = -1;
        }
    }
     
    public void osuukoLautaan(){

        
    } 
    
    public void liikutaPalloa(){
        pallo.liiku(this.xSuunta,this.ySuunta);
    }
}
