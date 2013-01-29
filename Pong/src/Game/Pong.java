package Game;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Pong extends JFrame implements Runnable{
    
    private PongPiirto piirtoalusta;
    private JFrame frame;
    private Pallo pallo;
    private Lauta lautaVasen;
    private Lauta lautaOikea;
    private PongLiikkuja liikkuja;
    private PongLogiikka pong;

    private Pisteet p1;
    private Pisteet p2;

    public Pong() {
        
    }

    private void luoKomponentit(Container container){
        this.piirtoalusta = new PongPiirto(pallo, lautaVasen, lautaOikea, p1, p2);
        container.add(piirtoalusta);
        frame.addKeyListener(new NappaimistonKuuntelija(lautaVasen, lautaOikea));    
    }

    @Override
    public void run() {
        this.lautaVasen = new Lauta(10, 185);
        this.lautaOikea = new Lauta(575, 185);
        this.pallo = new Pallo();
        this.p1 = new Pisteet(50, 30);
        this.p2 = new Pisteet(550, 30);
        this.liikkuja = new PongLiikkuja(pallo, lautaOikea, lautaVasen, piirtoalusta, p1 , p2);
        this.pong = new PongLogiikka(liikkuja);
        

        frame = new JFrame("Pong");
        frame.setPreferredSize(new Dimension(600,450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.paint(frame.getGraphics());
        
        pong.aloita();

        

    }
    
}
