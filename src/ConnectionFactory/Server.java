/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionFactory;

import Model.bean.Encrypt;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import util.Communication;

/**
 *
 * @author William
 */
public class Server {

    private Socket socket;
    private ObjectOutputStream outPut;
    private ObjectInputStream input;
    private static String host;
    private static int port;
    private Encrypt rsa = new Encrypt();

    public Server(String host, int port) {          
        this.host = host;
        this.port = port;
    }

    public Server() {
    }

    public Communication outPut_inPut(Communication m) {
        Communication communication = null;   
        try {
            socket = new Socket(host, port);
            outPut = new ObjectOutputStream(socket.getOutputStream());
            outPut.writeObject(m);
            outPut.flush();
            input = new ObjectInputStream(socket.getInputStream());
            communication = (Communication) input.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n");
            System.exit(0);
        } finally {
            close();
        }     
        return communication;
    }

    public void outPut(Communication m) {
        try {
            socket = new Socket(host, port);
            outPut = new ObjectOutputStream(socket.getOutputStream());
            outPut.writeObject(m);
            outPut.flush();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n");
            System.exit(0);
        } 
    }

    public Communication inPut(Communication m) {
        Communication communication = null;
        try {
            input = new ObjectInputStream(socket.getInputStream());
            communication = (Communication) input.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n");
            System.exit(0);
        } finally {
            close();
        }
        return communication;
    }

    public void close() {
        try {
            outPut.close();
            input.close();
            socket.close();
        } catch (IOException | NullPointerException x) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n");
            System.exit(0);
        }
    }
}
