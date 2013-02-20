package Valikko;


import Sound.Musiikki;
import Tulokset.Lukija;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Aloituskäyttöliittymä joka käynnistää tai lopettaa pelin 
 * nappia painamalla
 * 
 */

public class Kayttoliittyma extends JFrame implements Runnable{
    
    
    private JFrame frame;
    private JTextField pelaaja1;
    private JTextField pelaaja2;

    public Kayttoliittyma() {
        
    }
    
    /**
     * Metodi lisää napit ja nimikentät, sekä tekstikentän käyttöliittymän
     * container-olioon
     * 
     * @param container 
     */
    
    private void luoKomponentit(Container container) {
        Lukija lukija = new Lukija();
        JTextArea ohjeet = new JTextArea(lukija.lue());
        Font fontti = new Font("Helvetica", Font.ITALIC, 16);
        ohjeet.setFont(fontti);
        ohjeet.setEditable(false);
        
        ohjeet.setForeground(new Color(216, 179, 42));
        ohjeet.setBackground(Color.DARK_GRAY);
        container.add(ohjeet);
        container.add(luoNimikentta(), BorderLayout.NORTH);
        container.add(luoValikko(), BorderLayout.SOUTH);
        
        
    }
    
    /**
     * Luo uuden JPanelin, jossa on kaksi nimikenttää pelaajien nimille
     * @return JPanel
     */
    private JPanel luoNimikentta(){
        JPanel panel = new JPanel(new GridLayout(2,2));
        JLabel nimiKentta1 = new JLabel("Pelaaja 1: ");
        nimiKentta1.setForeground(Color.WHITE);
        this.pelaaja1 = new JTextField();
        JLabel nimiKentta2 = new JLabel("Pelaaja 2: ");
        nimiKentta2.setForeground(Color.WHITE);
        this.pelaaja2 = new JTextField();
        
        panel.add(nimiKentta1);
        panel.add(pelaaja1);
        panel.add(nimiKentta2);
        panel.add(pelaaja2);
        
        return panel;
        
    }
    /**
     * Luo uuden JPanelin, johon lisätään aloita ja lopeta nappi, sekä kuuntelija
     * @return JPanel
     */
    private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        
        JButton aloita = new JButton("Aloita");
        aloita.setForeground(new Color(254, 49, 167));
        panel.add(aloita);
        
        JButton lopeta = new JButton("Lopeta");
        panel.add(lopeta);
        lopeta.setForeground(new Color(56, 199, 229));
        
        JButton ohjeet = new JButton("Ohjeet");
        panel.add(ohjeet);
        ohjeet.setForeground(new Color(56, 199, 229));
        
        
        Kuuntelija kuuntelija = new Kuuntelija(aloita, lopeta, ohjeet, pelaaja1, pelaaja2, frame);
        aloita.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);
        ohjeet.addActionListener(kuuntelija);
        
        return panel;
    }
    /**
     * Luo musiikin, sekä käynnistää JFramen 
     */
    @Override
    public void run() {

        Musiikki musiikki = new Musiikki();
        musiikki.play();

        frame = new JFrame("Valikko");
        frame.setPreferredSize(new Dimension(600,450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setResizable(false);
        frame.setBackground(Color.GRAY);
        frame.setVisible(true);
        frame.paint(frame.getGraphics());
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
}
