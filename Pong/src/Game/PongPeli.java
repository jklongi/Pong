package Game;


import java.awt.Component;
import java.util.Random;

public class PongPeli {
    
    private int xSuunta;
    private int ySuunta;
    private Component component;
    private Pallo pallo;
    private LautaOikea oikea;
    private LautaVasen vasen;
    private Random random;
            
    
    public PongPeli(Pallo pallo, LautaOikea oikea, LautaVasen vasen, Component component){
        this.pallo = pallo;
        this.oikea = oikea;
        this.vasen = vasen;
        this.component = component;
        
        this.xSuunta = 1;
        this.ySuunta = 1;
        
//        while(true){
//            
//            this.xSuunta = random.nextInt(3) -1;
//            this.ySuunta = random.nextInt(3) -1;
//            if(this.xSuunta != 0 || this.ySuunta != 0){
//                pallo.setxSuunta(this.xSuunta);
//                pallo.setySuunta(this.ySuunta);
//                break;
//            }
//     
//        }
        
    }
    
    public void Aloita(){
        while(true){
            component.repaint();
            pallo.liiku();
            
            if( pallo.getX() <= 0){
                pallo.setxSuunta(1);
            }
            if(pallo.getX() >= 585){
                pallo.setxSuunta(-1);
            }
            if( pallo.getY() <= 0){
                pallo.setySuunta(1);
            }
            if(pallo.getY() >= 415){
                pallo.setySuunta(-1);
            }
            
            try{
                Thread.sleep(6);

            } catch (Exception e){
                System.out.println("errori:" +e);
            } 
        }
    }  
}
