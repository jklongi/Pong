package Valikko;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Aloituskäyttöliittymä joka käynnistää tai lopettaa pelin 
 * nappia painamalla
 * 
 */

public class Kayttoliittyma extends JFrame implements Runnable{
    
    
    private JFrame frame;

    public Kayttoliittyma() {
        
    }
    
    /**
     * Metodi lisää napit, sekä tekstikentän käyttöliittymän
     * container-olioon
     * 
     * @param container 
     */
    
    private void luoKomponentit(Container container) {
        JTextArea ohjeet = new JTextArea("Pong kaksinpeli");
        ohjeet.setForeground(Color.WHITE);
        ohjeet.setBackground(Color.DARK_GRAY);
        container.add(ohjeet);
        container.add(luoValikko(), BorderLayout.SOUTH);
    }
    
    /**
     * Metodi luo JPanel olion ja lisää siihen kaksi nappia
     * kuuntelijalla varustettuna
     * 
     * @Return valmis JPanel
     */
    
    private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        
        JButton aloita = new JButton("Aloita");
        aloita.setForeground(new Color(254, 49, 167));
        panel.add(aloita);
        
        JButton lopeta = new JButton("Lopeta");
        panel.add(lopeta);
        lopeta.setForeground(new Color(56, 199, 229));
        
        
        Kuuntelija kuuntelija = new Kuuntelija(aloita, lopeta, frame);
        aloita.addActionListener(kuuntelija);
        lopeta.addActionListener(kuuntelija);
        
        return panel;
    }

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
        frame.setBackground(Color.DARK_GRAY);
        frame.setVisible(true);
        frame.paint(frame.getGraphics());
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
}
