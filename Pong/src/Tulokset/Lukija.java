package Tulokset;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Lukija {
    
    private ArrayList<String> tulos;
    
    public Lukija(){
        this.tulos = new ArrayList<String>();
    }
    
    /**
     * Lukee tiedodsosta tulokset ja palauttaa ne String muuttujassa
     * @return 
     */
    
    public String lue(){
        
        try{
            File tiedosto = new File("src/Tulokset/score.txt");
            Scanner lukija = new Scanner(tiedosto);
            while(lukija.hasNextLine()){
                String rivi = lukija.nextLine();
                tulos.add(0, rivi);
                
            }
            
        } catch(Exception e){
            System.out.println("Filreader: " + e);
        }
        
        siisti();
        
        return makeString();
        
    }
    public void siisti(){
        if(tulos.size() <= 16){
            return;
        }
        if(this.tulos.size() > 16){
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
