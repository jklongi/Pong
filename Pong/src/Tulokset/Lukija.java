package Tulokset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class Lukija {
    
    private String tulokset;
    
    public Lukija(){
        this.tulokset = "\n Viimeisimmät pelit: \n\n";
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
                tulokset += " " + rivi + "\n";
                
            }
            
        } catch(Exception e){
            System.out.println("Filreader: " + e);
        }
        
        
        
        return tulokset;
        
    }
    
}
