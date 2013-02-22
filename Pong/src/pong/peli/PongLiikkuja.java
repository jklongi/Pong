package pong.peli;

import java.util.Random;
import pong.domain.Lauta;
import pong.domain.Pallo;

/** Luokka on tietoinen kaikkien pong-pelin olioiden sijainnista ja 
 * liikuttaa niitä 
 * 
 * @author joonaslongi
 */

public class PongLiikkuja {
    private Pallo pallo;
    private Lauta oikea;
    private Lauta vasen;
    private Peli peli;
    private int xSuunta;
    private int ySuunta;
    private Random random;
    /**
     * Konstruktori saa parametrinaan pelin.
     * @param peli 
     */
    public PongLiikkuja(Peli peli){
        this.peli = peli;
        this.pallo = peli.getPallo();
        this.oikea = peli.getLauta(2);
        this.vasen = peli.getLauta(1);
        this.random = new Random();
        
    }    
    
    /**
     * Metodi arpoo aloitussuunnan neljästä vaihtoehdosta
     */
    
    public void arvoSuunta(){
        int a = random.nextInt(4); 
        if(a == 0){
            setSuunnat(1,1);
        }
        else if(a == 1){
            setSuunnat(-1,-1);
        }
        else if(a == 2){
            setSuunnat(-1,1);
        }
        else {
            setSuunnat(1,-1);
        }       
    }
    public void setSuunnat(int x, int y){
        this.xSuunta = x;
        this.ySuunta = y;
    }
    /**
     * Metodi tarkistaa, mikäli pallo osuu seinään
     * Jos osuu, se vaihtaa sen x tai y suunnan 
     * simuloiden "kimpoamista"
     */
    
    public void osuukoSeinaan(){
        
        if(pallo.getX() <= 0){
            this.xSuunta = 1;
            peli.asetaPistePelaajalle(2);
        }
        if(pallo.getX() >= 585){
            this.xSuunta = -1;
            peli.asetaPistePelaajalle(1);
        }
        if( pallo.getY() <= 0){
            this.ySuunta = 1;
        }
        if(pallo.getY() >= 385){
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
        // Pallon leveys on 15
        if(vasen.getX() + 15 == pallo.getX() ){
            //Laudan pituus on 55
            //Tämä tarkistaa osuuko pallon yläkulma lautaan
            if(vasen.getY() <= pallo.getY() && vasen.getY() +55 >= pallo.getY()){    
                this.xSuunta = 1;
            } 
            //Tämä tarkistaa osuuko pallon alakulma lautaan
            if(vasen.getY() <= pallo.getY() +15 && vasen.getY() +55 >= pallo.getY()){    
                this.xSuunta = 1;
            }  
        }
        
        if(oikea.getX() == pallo.getX() +15 ){
            if(oikea.getY() <= pallo.getY() && oikea.getY() +55 >= pallo.getY()){    
                this.xSuunta = -1;
            }
            if(oikea.getY() <= pallo.getY() +15 && oikea.getY() +55 >= pallo.getY()){    
                this.xSuunta = -1;
            } 
        }
    } 
    
    /**
     * Tarkistaa osuuko laudan reunaan.
     * osuessa vaihtaa y suunnan.
     */
    
    public void osuukoLaudanReunaan(){
        if(vasen.getY() == pallo.getY() + 15){
            if(pallo.getX() <= vasen.getX() + 15){
                this.ySuunta = -1;  
            }
        }
        
        if(vasen.getY() + 55 == pallo.getY()){
            if(pallo.getX() <= vasen.getX() +15){
                this.ySuunta = 1;
            }
        }
        
        if(oikea.getY() == pallo.getY() + 15){
            if(pallo.getX() +15 >= oikea.getX()){
                this.ySuunta = -1;
            }
        }
        
        if(oikea.getY() + 55 == pallo.getY()){
            if(pallo.getX()+15 >= oikea.getX()){
                this.ySuunta = 1;
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
