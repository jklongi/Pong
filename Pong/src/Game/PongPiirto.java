package Game;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class PongPiirto extends JPanel {
    
    private Pallo pallo;
    private LautaVasen lautaVasen;
    private LautaOikea lautaOikea;
    
    public PongPiirto(Pallo pallo, LautaVasen lautaVasen, LautaOikea lautaOikea){
        super.setBackground(Color.GRAY);
        this.pallo = pallo;
        this.lautaVasen = lautaVasen;
        this.lautaOikea = lautaOikea;
        
    }
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        pallo.piirra(graphics);
        lautaVasen.piirra(graphics);
        lautaOikea.piirra(graphics);
        repaint();
    }
    
}
