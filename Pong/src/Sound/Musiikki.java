package Sound;



import java.io.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Musiikki {
    
    /**
     * Toistaa wav tiedoston 
     */
    
    public void play(){

        try{
            InputStream in = new FileInputStream("src/Sound/PongBeat.wav");
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as); 
            
            
        }
        catch (Exception e) {
            System.out.println( "errori: " + e );
        }
        
                  
    }
}