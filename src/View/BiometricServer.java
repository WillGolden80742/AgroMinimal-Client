/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ConnectionFactory.Server;
import com.formdev.flatlaf.FlatDarkLaf;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author William
 */
public class BiometricServer {

    private ServerSocket serverSocket;
    private static int portAdress = 2534;
    private int i;
    private static Login login;

    public void setServerSocket(int porta) throws IOException {
        serverSocket = new ServerSocket(porta);
    }

    public static int getPortAdress() {
        return portAdress;
    }

    public static void setMainServer() {
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
        new Server(host,port);
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

    public Socket waitConnection() throws IOException {
        System.out.println("Sessão : " + i++ + "\nWait connection...");
        Socket socket = serverSocket.accept();
        return socket;
    }

    public static void main(String[] args) {
        setMainServer();
        login = new Login();
        new Propriedades().setVisible(true);
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        try {
            BiometricServer server = new BiometricServer();
            System.out.println("Starting socket...\n");
            server.setServerSocket(portAdress);
            while (true) {
                Socket socket = server.waitConnection();
                System.out.println("Cliente conectado!");
                TreatAuthentication treatConnection = new TreatAuthentication(socket, login);
                Thread t = new Thread(treatConnection);
                t.start();
                System.out.println("Cliente finalizado\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(TreatAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
