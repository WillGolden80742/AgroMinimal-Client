/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LookAndFeel;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author William
 */
public class LAF {

    private static String theme = "";

    public LAF() {

    }

    public LAF(String theme) {
        this.theme = theme;
    }

    public static String getTheme() {
        return theme;
    }

    public static void setTheme(String theme) {
        LAF.theme = theme;
    }


    public void setLAF(Component c) {
        String t = "";
        if (theme.equals("")) {
            try {
                File myObj = new File("config.ini");
                Scanner myReader;
                myReader = new Scanner(myObj);
                int cont = 0;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if (cont == 0) {
                        try {
                            data = data.replaceAll(" ", "").split(":")[1];
                        } catch (ArrayIndexOutOfBoundsException ex) {
                        }
                        t = data;
                    }
                    cont++;
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LAF.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            t = theme;
        }
        switch (t.toLowerCase()) {
            case "dark":
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                SwingUtilities.updateComponentTreeUI(c);
            } catch (UnsupportedLookAndFeelException ex) {
                System.err.println("Failed to initialize LaF");
            }
            theme = "dark";
            break;
            default:
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                SwingUtilities.updateComponentTreeUI(c);
            } catch (UnsupportedLookAndFeelException ex) {
                System.err.println("Failed to initialize LaF");
            }
            theme = "light";
            break;
        }
        try {
            try (FileWriter fw = new FileWriter("config.ini"); BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write("theme : " + theme);
            } catch (FileNotFoundException ex) {
                System.out.print("Definido light como tema default");
            }
        } catch (IOException ex) {
            Logger.getLogger(LAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
