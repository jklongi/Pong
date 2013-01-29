package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class NappaimistonKuuntelija implements KeyListener{
    private Lauta lautaVasen;
    private Lauta lautaOikea;

    
    public NappaimistonKuuntelija(Lauta lautaVasen,Lauta lautaOikea){
        this.lautaVasen = lautaVasen;
        this.lautaOikea = lautaOikea;

    }


    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_W){
            lautaVasen.setYlos(true);
            lautaVasen.setAlas(false);
        } 
        if(ke.getKeyCode() == KeyEvent.VK_S){
            lautaVasen.setYlos(false);
            lautaVasen.setAlas(true);
        }
        if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            lautaOikea.setYlos(false);
            lautaOikea.setAlas(true);
        }
        if(ke.getKeyCode() == KeyEvent.VK_UP){
            lautaOikea.setYlos(true);
            lautaOikea.setAlas(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_W){
            lautaVasen.setYlos(false);
            
        } 
        if(ke.getKeyCode() == KeyEvent.VK_S){
            
            lautaVasen.setAlas(false);
        }
        if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            
            lautaOikea.setAlas(false);
        }
        if(ke.getKeyCode() == KeyEvent.VK_UP){
            lautaOikea.setYlos(false);
            
        }

    }
    
}
