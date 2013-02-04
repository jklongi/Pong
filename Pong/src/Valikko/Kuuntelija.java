
package Valikko;


import Game.Pong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Luokka kuuntelee nappien klikkauksen ja asettaa
 * niille toiminnot 
 */

public class Kuuntelija implements ActionListener {
    
    private JButton aloita;
    private JButton lopeta;
    private JFrame frame;
    
    public Kuuntelija(JButton aloita, JButton lopeta, JFrame frame){
        this.aloita = aloita;
        this.lopeta = lopeta;
        this.frame = frame;
    }
    
    /**
     * Lopeta napista koko frame sulkeutuu
     * Aloita napista itse pong-peli alkaa
     * 
     * @param ae 
     */
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == aloita){
            Pong pong = new Pong();
            pong.run();
            
        }
        if(ae.getSource() == lopeta){
            frame.dispose();
        }
        
    
        

        
    }
    
}
