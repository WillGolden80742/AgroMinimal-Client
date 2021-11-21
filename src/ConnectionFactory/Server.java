/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionFactory;

import Model.bean.Cripto;
import View.Login;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Server(String host, int port) {
        this.host = host;
        this.port = port;
        try (FileWriter fw = new FileWriter("server.ini"); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Host : " + host + "\n"
                    + "Port : " + port);
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Server() {
        File myObj = new File("server.ini");
        Scanner myReader;
        String host = "";
        int port = 0;
        try {
            myReader = new Scanner(myObj);
            int cont = 0;
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                if (cont == 0) {
                    data = data.replaceAll(" ", "").split(":")[1];
                    host = data;
                } else if (cont == 1) {
                    data = data.replaceAll(" ", "").split(":")[1];
                    port = Integer.parseInt(data);
                }
                cont++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Server(host, port);
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
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n");
            ConnectServer connectServer = new ConnectServer();
            connectServer.setLocation(400, 400);
            connectServer.setVisible(true);
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

    public static String getHostAdress() {
        String ip = "000.000.0.000";
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp()) {
                    continue;
                }

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    ip = addr.getHostAddress();
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        return ip;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        Server.host = host;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Server.port = port;
    }

    public void close() {
        try {
            outPut.close();
            input.close();
            socket.close();
        } catch (IOException | NullPointerException x) {
            System.out.println("Erro de conexão!");

        }
    }

}
