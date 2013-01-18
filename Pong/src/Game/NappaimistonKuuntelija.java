package Game;


import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class NappaimistonKuuntelija implements KeyListener{
    private LautaVasen lautaVasen;
    private Component component;
    public NappaimistonKuuntelija(LautaVasen lautaVasen,  Component component){
        this.lautaVasen = lautaVasen;
        this.component = component;
    }
    @Override
    public void keyTyped(KeyEvent ke) {    
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_W){
            lautaVasen.liiku(0, -10);
        } 
        
        if(ke.getKeyCode() == KeyEvent.VK_S){
            lautaVasen.liiku(0,10);
        }
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {    
    }
    
}
