package Game;

import java.awt.Component;
import java.util.Random;

/** Luokka on tietoinen kaikkien pong-pelin olioiden sijainnista ja 
 * liikuttaa niitä 
 * 
 * @author joonaslongi
 */

public class PongLiikkuja {
    private Pallo pallo;
    private Lauta oikea;
    private Lauta vasen;
    private Pisteet p1;
    private Pisteet p2;
    
    private Component component;
    
    private int xSuunta;
    private int ySuunta;
    
    private Random random;
    
    public PongLiikkuja(Pallo pallo, Lauta oikea, Lauta vasen, Component component, Pisteet p1, Pisteet p2){
        this.pallo = pallo;
        this.oikea = oikea;
        this.vasen = vasen;
        this.component = component;
        this.random = new Random(); 
    }    
    
    /**
     * Metodi arpoo aloitussuunnan neljästä vaihtoehdosta
     */
    
    public void arvoSuunta(){
        int a = random.nextInt(4); 
        if(a == 0){
            this.xSuunta = 1;
            this.ySuunta = 1;
        }
        if(a == 1){
            this.xSuunta = -1;
            this.ySuunta = -1;
        }
        if(a == 2){
            this.xSuunta = -1;
            this.ySuunta = 1;
        }
        if(a == 3){
            this.xSuunta = 1;
            this.ySuunta = -1;
        }

        
    }
    /**
     * Metodi tarkistaa, mikäli pallo osuu seinään
     * Jos osuu, se vaihtaa sen x tai y suunnan 
     * simuloiden "kimpoamista"
     */
    
    public void osuukoSeinaan(){
        if(pallo.getX() <= 0){
            this.xSuunta = 1;
        }
        if(pallo.getX() >= 585){
            this.xSuunta = -1;
            p1.setPiste();
        }
        if( pallo.getY() <= 0){
            this.ySuunta = 1;
        }
        if(pallo.getY() >= 415){
            this.ySuunta = -1;
        }
    }
    
    /**
     * Liikuttaa lautaa suuntaan, jonka arvo on true
     * 
     */
    
    public void liikutaLautaa(){
        if(this.vasen.ylos() == true){
            this.vasen.liiku(-1);
        }
        if(this.vasen.alas() == true){
            this.vasen.liiku(1);
        }
        if(this.oikea.ylos() == true){
            this.oikea.liiku(-1);
        }
        if(this.oikea.alas() == true){
            this.oikea.liiku(1);
        }
    }
    
    /**
     * Tarkistaa osuuko pallo lautaan
     * Jos jokin kohta pallon reunasta osuu lautaan,
     * metodi muuttaa sen x suunnan vastakkaiseksi
     */
     
    public void osuukoLautaan(){
        if(vasen.getX() + 12 == pallo.getX() ){
            if(vasen.getY() < pallo.getY() && vasen.getY() +55 > pallo.getY()){    
                this.xSuunta = 1;
            } 
            if(vasen.getY() < pallo.getY() +15 && vasen.getY() +55 > pallo.getY()){    
                this.xSuunta = 1;
            }  
        }
        
        if(oikea.getX() == pallo.getX() +12 ){
            if(oikea.getY() < pallo.getY() && oikea.getY() +55 > pallo.getY()){    
                this.xSuunta = -1;
            }
            if(oikea.getY() < pallo.getY() +15 && oikea.getY() +55 > pallo.getY()){    
                this.xSuunta = -1;
            } 
        }
    } 
    
    /**
     * Metodi liikuttaa palloa x ja y suuntien arvojen mukaan
     * muut metodit määräävät suunnan
     */
    
    public void liikutaPalloa(){
        pallo.liiku(this.xSuunta,this.ySuunta);
    }
    
    public void setxSuunta(int x){
        this.xSuunta = x;
    }
    public void setySuunta(int y){
        this.ySuunta = y;
    }
    public int getxSuunta(){
        return this.xSuunta;
    }
    public int getySuunta(){
        return this.ySuunta;
    }
}
