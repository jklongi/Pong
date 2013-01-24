package Game;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class PongPiirto extends JPanel {
    
    private Pallo pallo;
    private Lauta vasen;
    private Lauta oikea;
    
    public PongPiirto(Pallo pallo, Lauta vasen, Lauta oikea){
        super.setBackground(Color.GRAY);
        this.pallo = pallo;
        this.vasen = vasen;
        this.oikea = oikea;    
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        pallo.paint(graphics);
        vasen.piirra(graphics);
        oikea.piirra(graphics);
        repaint();
        
    }
    
}
