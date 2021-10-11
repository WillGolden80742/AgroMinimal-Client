/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author William
 */
public final class PlayAudio implements Runnable {

    private final String path;

    public PlayAudio(String path) {
        this.path = path;
    }

    @Override
    public void run() {
  
        try {
            Player player = new Player(new FileInputStream(path));
            player.play();
        } catch (FileNotFoundException | JavaLayerException ex) {
            Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
}
