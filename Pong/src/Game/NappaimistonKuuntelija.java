package Game;


import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class NappaimistonKuuntelija implements KeyListener{
    private Lauta lautaVasen;
    private Lauta lautaOikea;
    private Component component;
    
    public NappaimistonKuuntelija(Lauta lautaVasen,Lauta lautaOikea, Component component){
        this.lautaVasen = lautaVasen;
        this.lautaOikea = lautaOikea;
        this.component = component;
    }
    @Override
    public void keyTyped(KeyEvent ke) {    
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_W){
            lautaVasen.liiku(-20);
        } 
        if(ke.getKeyCode() == KeyEvent.VK_S){
            lautaVasen.liiku(20);
        }
        if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            lautaOikea.liiku(20);
        }
        if(ke.getKeyCode() == KeyEvent.VK_UP){
            lautaOikea.liiku(-20);
        }
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {    
    }
    
}
