package Game;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Pong extends JFrame implements Runnable{
    
    private PongPiirto piirtoalusta;
    private JFrame frame;
    private Pallo pallo;
    private Lauta lautaVasen;
    private Lauta lautaOikea;

    public Pong() {
        
    }

    private void luoKomponentit(Container container){
        this.piirtoalusta = new PongPiirto(pallo, lautaVasen, lautaOikea);
        container.add(piirtoalusta);
        frame.addKeyListener(new NappaimistonKuuntelija(lautaVasen, lautaOikea, piirtoalusta));
        
    }

    @Override
    public void run() {
        this.lautaVasen = new Lauta(10, 185);
        this.lautaOikea = new Lauta(575, 185);
        this.pallo = new Pallo();
        
        
        
        
        frame = new JFrame("Pong");
        frame.setPreferredSize(new Dimension(600,450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.paint(frame.getGraphics());
        PongLogiikka pong = new PongLogiikka(pallo, lautaOikea, lautaVasen, piirtoalusta);

        pong.aloita();

    }
    
}
