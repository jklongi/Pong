package Game;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;



public class Pong extends JFrame implements Runnable{
    
    private PongPiirto piirtoalusta;
    private JFrame frame;
    private Pallo pallo;
    private LautaVasen lautaVasen;
    private LautaOikea lautaOikea;

    public Pong() {
        
    }
    
    
    private void luoKomponentit(Container container){
        this.piirtoalusta = new PongPiirto(pallo, lautaVasen, lautaOikea);
        container.add(piirtoalusta);
        frame.addKeyListener(new NappaimistonKuuntelija(lautaVasen, piirtoalusta));
        frame.addKeyListener(new NappaimistonKuuntelija2(lautaOikea, piirtoalusta));
        
    }

    @Override
    public void run() {
        
        lautaVasen = new LautaVasen(10, 185);
        lautaOikea = new LautaOikea(575 ,185);
        
        pallo = new Pallo(285,210, piirtoalusta, lautaVasen, lautaOikea);
        
        frame = new JFrame("Pong");
        frame.setPreferredSize(new Dimension(600,450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true); 

        pallo.liiku();

    }
    
}
