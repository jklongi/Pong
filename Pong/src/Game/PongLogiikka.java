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
        
        int delay = 6;
        ActionListener taskPerformer = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                liikkuja.liikutaPalloa();
                liikkuja.osuukoSeinaan();
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
