package Game;


import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class NappaimistonKuuntelija2 implements KeyListener{
    private LautaOikea lautaOikea;
    private Component component;
    public NappaimistonKuuntelija2(LautaOikea lautaOikea, Component component){
        this.lautaOikea = lautaOikea;
        this.component = component;
    }
    @Override
    public void keyTyped(KeyEvent ke) {    
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            lautaOikea.liiku(0,10);
        }
        if(ke.getKeyCode() == KeyEvent.VK_UP){
            lautaOikea.liiku(0,-10);
        }
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {    
    }
    
}
