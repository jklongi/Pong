
package Valikko;


import Game.Pong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Luokka kuuntelee nappien klikkauksen ja asettaa
 * niille toiminnot 
 */

public class Kuuntelija implements ActionListener {
    
    private JButton aloita;
    private JButton lopeta;
    private JButton ohjeet;
    private JFrame frame;
    private JTextField pelaaja1;
    private JTextField pelaaja2;
    
    public Kuuntelija(JButton aloita, JButton lopeta,JButton ohjeet, JTextField pelaaja1, JTextField pelaaja2, JFrame frame){
        this.aloita = aloita;
        this.lopeta = lopeta;
        this.frame = frame;
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
        this.ohjeet = ohjeet;
    }
    
    /**
     * Lopeta napista koko frame sulkeutuu
     * Aloita napista itse pong-peli alkaa
     * 
     * Mikäli pelaajat eivät kirjoita mitään tekstikenttään
     * nimeksi valitaan "nimetön"
     * 
     * @param ae 
     */
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == aloita){
            String p1Nimi = "";
            String p2Nimi = "";
            
            if(pelaaja1.getText().isEmpty()){
                p1Nimi = "Nimetön";
            } else{
                p1Nimi = pelaaja1.getText();
            }
            if(pelaaja2.getText().isEmpty()){
                p2Nimi = "Nimetön";
            } else{
                p2Nimi = pelaaja2.getText();
            }

            Pong pong = new Pong(p1Nimi, p2Nimi);
            pong.run();
            
        }
        if(ae.getSource() == lopeta){
            System.exit(0);
        }
        if(ae.getSource() == ohjeet){
            Ohjeet ohj = new Ohjeet();
            ohj.run();
        }
    
        

        
    }
    
}
