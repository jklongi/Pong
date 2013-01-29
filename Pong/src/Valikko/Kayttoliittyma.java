package Valikko;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Kayttoliittyma extends JFrame implements Runnable{
    
    
    private JFrame frame;

    public Kayttoliittyma() {
        
    }
    
    

    private void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        
        JTextArea ohjeet = new JTextArea("Pong kaksinpeli");
        ohjeet.setForeground(Color.ORANGE);
        ohjeet.setBackground(Color.DARK_GRAY);
        
        JTextArea tekstikentta = new JTextArea();
        tekstikentta.setBackground(Color.DARK_GRAY);
        
        JButton aloita = new JButton("Aloita");
        aloita.setBackground(new Color(254, 49, 167));
        aloita.addActionListener(new Kuuntelija());

        container.add(ohjeet);
        container.add(tekstikentta);
        container.add(aloita);
        
            
    }

    @Override
    public void run() {

        

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
