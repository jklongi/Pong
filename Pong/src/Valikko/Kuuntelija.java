
package Valikko;

import Game.Game;
import Game.Pong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kuuntelija implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Pong pong = new Pong();
        pong.run();
        
    }
    
}
