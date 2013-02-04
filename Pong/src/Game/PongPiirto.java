package Game;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Luokka kutsuu jokaisen olion piirrä metodia
 * 
 */

public class PongPiirto extends JPanel {
    
    private Pallo pallo;
    private Lauta vasen;
    private Lauta oikea;
    private Pisteet p1;
    private Pisteet p2;
    
    public PongPiirto(Pallo pallo, Lauta vasen, Lauta oikea, Pisteet p1, Pisteet p2){
        super.setBackground(Color.DARK_GRAY);
        this.pallo = pallo;
        this.vasen = vasen;
        this.oikea = oikea; 
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        pallo.paint(graphics);
        vasen.piirra(graphics);
        oikea.piirra(graphics);
        p1.paint(graphics);
        p2.paint(graphics);
        repaint();
        revalidate();
        
    }
    
}
