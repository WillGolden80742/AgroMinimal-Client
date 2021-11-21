package View;

import ConnectionFactory.TreatAuthentication;
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

    public static Login getLogin() {
        return login;
    }

    public static void setLogin(Login login) {
        BiometricServer.login = login;
    }

    public Socket waitConnection() throws IOException {
        System.out.println("Sessão : " + i++ + "\nWait connection...");
        Socket socket = serverSocket.accept();
        return socket;
    }

    public static void main(String[] args) {
        login = new Login();
        login.setVisible(true);
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
                TreatAuthentication treatConnection = new TreatAuthentication(socket);
                Thread t = new Thread(treatConnection);
                t.start();
                System.out.println("Cliente finalizado\n");
            }
        } catch (IOException ex) {

            Logger.getLogger(TreatAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
