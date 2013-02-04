package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/** Luokka hallinnoi kaikkia olioita, sekä aikaa
 * 
 *  @author joonaslongi
 */

public class PongLogiikka{

    private PongLiikkuja liikkuja;
   
    public PongLogiikka(PongLiikkuja liikkuja){
        this.liikkuja = liikkuja;
    }
    
    /**
     * Metodi kutsuu kaikkia liikkujan metodeja
     * 4 ms viiveellä
     */
    
    
    public void aloita(){
        
        liikkuja.arvoSuunta();
        
        int delay = 4;
        ActionListener taskPerformer = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                liikkuja.liikutaLautaa();
                liikkuja.liikutaPalloa();
                liikkuja.osuukoSeinaan();
                liikkuja.osuukoLautaan();
            }
            
        };
        new Timer(delay, taskPerformer).start();
    }  
}
