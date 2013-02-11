
package Game;



import Tulokset.Tallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Luokka kuuntelee nappien klikkauksen ja asettaa
 * niille toiminnot 
 */

public class NapinKuuntelija implements ActionListener {
    
    private JButton lopeta;
    private JFrame frame;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private Tallentaja tallentaja;
    
    public NapinKuuntelija(JButton lopeta,Pelaaja pelaaja1, Pelaaja pelaaja2, JFrame frame, Tallentaja tallentaja){
        this.tallentaja = tallentaja;
        this.lopeta = lopeta;
        this.frame = frame;
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }
    
    /**
     * Lopeta nappia painettaessa kirjoitetaan tallentajan avulla
     * score.txt tiedostoon tulokset, sekä suljetaan JFrame
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == lopeta){
            frame.dispose();
            try{
                tallentaja.kirjoitaTulokset(pelaaja1, pelaaja2);
            } catch(Exception e){
                System.out.println("ErroriTallentajassa" + e);
            }
            
        }
        
    }
    
}
