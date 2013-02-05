package Valikko;


import java.awt.Component;
import sun.audio.*;
import java.io.*;
import javax.media.j3d.Clip;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.swing.JFileChooser;


public class Musiikki {
    
    public void play(){

        try{
            InputStream in = new FileInputStream("src/Valikko/PongBeat.wav");
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as); 
            in.reset();
            
        }
        catch (Exception e) {
            System.out.println( "errori: " + e );
        }
        
                  
    }
}