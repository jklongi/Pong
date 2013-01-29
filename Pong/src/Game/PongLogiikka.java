package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PongLogiikka{

    private PongLiikkuja liikkuja;
   
    public PongLogiikka(PongLiikkuja liikkuja){
        this.liikkuja = liikkuja;
    }

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

//        while(true){
//            liikkuja.liikutaPalloa();
//            liikkuja.osuukoSeinaan();
//                    
//            try{
//                Thread.sleep(6);
//
//            } catch (Exception e){
//                System.out.println("errori:" +e);
//            }
//        }
    }  
}
