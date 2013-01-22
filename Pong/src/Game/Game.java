package Game;


import javax.swing.SwingUtilities;


public class Game {


    public static void main(String[] args) {
        Pong peli = new Pong();
        
        SwingUtilities.invokeLater(peli);
        
    }
}
