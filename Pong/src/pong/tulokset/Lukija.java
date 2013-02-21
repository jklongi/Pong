package pong.tulokset;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Lukija {
    
    public static final int MAKSIMIKOKO = 15;
    private ArrayList<String> tulos;
    
    public Lukija(){
        this.tulos = new ArrayList<String>();
    }
    
    /**
     * Lukee tiedodsosta tulokset ja palauttaa ne String muuttujassa
     * @return 
     */
    
    public ArrayList<String> lue(){
        
        try{
            File tiedosto = new File("src/pong/tulokset/score.txt");
            Scanner lukija = new Scanner(tiedosto);
            while(lukija.hasNextLine()){
                String rivi = lukija.nextLine();
                tulos.add(0, rivi);
                
            }
            
        } catch(Exception e){
            System.out.println("Filreader: " + e);
        }
        
        siisti();
        
        return tulos;
        
    }
    public void siisti(){
        if(tulos.size() <= MAKSIMIKOKO){
            return;
        }
        if(this.tulos.size() > MAKSIMIKOKO){
            tulos.remove(tulos.size()-1);
        }
        siisti();
    }
    
    public String makeString(){
        String tulokset = "";
        for (String rivi: tulos) {
            tulokset = tulokset + rivi+"\n";
        }
        return tulokset;
    }
    
}