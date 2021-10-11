/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import ConnectionFactory.Server;
import Model.bean.ProfilePic;
import Model.bean.TreatFiles;
import View.Chat;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import util.Communication;

/**
 *
 * @author William
 */
public class SaveProfileImage implements Runnable {

    private TreatFiles currentFile;
    private final String nickName;
    private int size = 50;
    private String sizeFolder = "Small";
    
    public SaveProfileImage(String nickName) {
        this.nickName = nickName;
    }
    
    public SaveProfileImage(String nickName, int size, String sizeFolder) {
        this.nickName = nickName;
        this.size = size;
        this.sizeFolder = sizeFolder;
    }    

    @Override
    public void run() {
        try {
            ProfilePic profilepic;
            Server server = new Server();
            Communication communication = new Communication("PROFILEIMAGE");
            communication.setParam("nickName", nickName);
            communication = server.outPut_inPut(communication);
            profilepic = (ProfilePic) communication.getParam("PROFILEIMAGEREPLY");
            // Arquivo
            try {
                byte[] pic = profilepic.getPicture();
                InputStream is = new ByteArrayInputStream(pic);
                BufferedImage bi = ImageIO.read(is);
                bi = currentFile.resizeImage(bi,size);
                new File("Files").mkdir();
                new File("Files/Contacts").mkdir();
                new File("Files/Contacts/ProfilePic").mkdir();
                new File("Files/Contacts/ProfilePic/"+sizeFolder+"/").mkdir();
                new File("Files/Contacts/ProfilePic/"+sizeFolder+"/" + nickName).mkdir();
                Path path = Paths.get("Files/Contacts/ProfilePic/"+sizeFolder+"/" + nickName + "/" + nickName + ".jpg");
                ImageIO.write(bi, "jpg", new File(path.toString()));
            } catch (NullPointerException | FileNotFoundException ex) {

            }
        } catch (IOException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
