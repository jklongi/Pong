package Game;


import Tulokset.Tallentaja;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**Luokka alustaa pong pelin, luo laudat, pallon, pelaajat,
 * piirtoalusta, käyttöliittymän, näppäimistönkuuntelijan,
 * sekä käynnistää itse pelin
 * 
 * @author joonaslongi
 */



public class Pong extends JFrame implements Runnable{
    
    private PongPiirto piirtoalusta;
    private JFrame frame;
    private Pallo pallo;
    private Lauta lautaVasen;
    private Lauta lautaOikea;
    private PongLiikkuja liikkuja;
    private PongLogiikka pong;
    private Tallentaja tallentaja;

    private Pelaaja p1;
    private Pelaaja p2;
    private String p1Nimi;
    private String p2Nimi;
    
    public Pong(String nimi1, String nimi2) {
        this.p1Nimi = nimi1;
        this.p2Nimi = nimi2;
    }
    /**
     * Luo uuden Jpanelin, johon luodaan GridLayoutilla kaksi nappia
     * "aloita" ja "lopeta"
     * @return JPanel
     */
    private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        
        JButton aloita = new JButton("Aloita");
        aloita.setForeground(new Color(254, 49, 167));
        aloita.setBackground(Color.yellow);
        panel.add(aloita);
        
        JButton lopeta = new JButton("Lopeta");
        panel.add(lopeta);
        lopeta.setForeground(new Color(56, 199, 229));
        
        
        NapinKuuntelija kuuntelija = new NapinKuuntelija(lopeta, p1, p2, frame, tallentaja);
        lopeta.addActionListener(kuuntelija);
        
        return panel;
    }
    /**
     * Lisää piirtoalistan, sekä valikon ja näppäimistönkuuntelijan containeriin 
     * @param container 
     */
    private void luoKomponentit(Container container){
        this.piirtoalusta = new PongPiirto(pallo, lautaVasen, lautaOikea, p1, p2);
        container.add(piirtoalusta);
        container.add(luoValikko(), BorderLayout.SOUTH);
        frame.addKeyListener(new NappaimistonKuuntelija(lautaVasen, lautaOikea));
        
    }
    /**
     * Luo kaikki oliot, käyttöliittymän, sekä aloittaa pelin
     */
    @Override
    public void run() {
        this.lautaVasen = new Lauta(10, 185);
        this.lautaOikea = new Lauta(575, 185);
        this.pallo = new Pallo();
        this.p1 = new Pelaaja(this.p1Nimi, 50, 30);
        this.p2 = new Pelaaja(this.p2Nimi, 480, 30);
        this.liikkuja = new PongLiikkuja(pallo, lautaOikea, lautaVasen, piirtoalusta, p1 , p2);
        this.pong = new PongLogiikka(liikkuja);
        luoTallentaja();
        
        frame = new JFrame("Pong");
        frame.setPreferredSize(new Dimension(600,450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setResizable(false);
        frame.setBackground(Color.GRAY);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.paint(frame.getGraphics());
        
        pong.aloita(); 

    }
    
    public void luoTallentaja(){
        try{
            this.tallentaja = new Tallentaja();
        } catch(Exception e){
            System.out.println("Error: " +e);
        }
        
    }
    
}
