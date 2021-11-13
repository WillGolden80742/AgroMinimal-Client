/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ConnectionFactory.Server;
import Model.bean.Authenticated;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Communication;
import util.States;

/**
 *
 * @author William
 */
public class TreatAuthentication implements Runnable {

    private Socket socket;
    private States states = States.CONNECTED;
    private static Login login;
    private static boolean auth;
    private static String welcome;

    public TreatAuthentication(Socket socket, Login login) {
        this.socket = socket;
        this.login = login;
    }

    public void treatConnection(Socket socket) {
        try {

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outPut = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("Tratando...");

            while (states != States.EXIT) {
                Communication communication = (Communication) input.readObject();
                String operation = communication.getOperation();
                Communication reply = null;
                reply = executeOperation(operation, communication);
                outPut.writeObject(reply);
                outPut.flush();
            }
            input.close();
            outPut.close();
        } catch (Exception ex) {
            System.out.println("Problema no tratamento da conexão com o cliente: " + socket.getInetAddress());
            System.out.println("Erro: " + ex.getMessage());
            //Logger.getLogger(TreatAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("!!!Finalizando!!!");
            try {
                closeSocket(socket);
            } catch (IOException ex) {
                Logger.getLogger(TreatAuthentication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Communication executeOperation(String op, Communication communication) {
        Communication reply = new Communication(op + "REPLY");
        String loginReply;
        String code = new CodePanel().codeAuth;
        String codeMobile = (String) communication.getParam("CODE");
        System.out.println(code + " : " + codeMobile);
        switch (op) {
            case "BIOMETRIC":

                if (auth == false) {
                    if (!code.equals("") && codeMobile.equals(code)) {
                        String androidID = (String) communication.getParam("ANDROIDID");
                        reply = new Communication("BIOMETRIC");
                        reply.setParam("ANDROIDID", androidID);
                        Server server = new Server();
                        reply = server.outPut_inPut(reply);
                        if (((String) reply.getParam("BIOMETRICREPLY")).equals("OK")) {
                            this.welcome = (String) reply.getParam("WELCOME");
                            reply.setParam("BIOMETRICREPLY", welcome);
                            Authenticated auth = new Authenticated();
                            auth.setLogin((String) reply.getParam("NICKNAME"));
                            new Propriedades().setVisible(true);
                            login.setVisible(false);
                            this.auth = true;
                        } else {
                            loginReply = (String) reply.getParam("BIOMETRICREPLY");
                            System.out.println("login reply : " + loginReply);
                            System.out.println("code : " + new CodePanel().codeAuth);
                            login.setMessageLogin(loginReply);
                        }

                    } else if (code.equals("")) {
                        loginReply = "Clique em biometria para gerar código";
                        login.setMessageLogin(loginReply);
                        reply.setParam("BIOMETRICREPLY", loginReply);
                    } else if (!codeMobile.equals(code)) {
                        loginReply = "Código inválido";
                        login.setMessageLogin(loginReply);
                        reply.setParam("BIOMETRICREPLY", loginReply);
                    }
                } else {
                   reply.setParam("BIOMETRICREPLY", welcome);
                }
                break;
            default:
                break;
        }
        return reply;
    }

    private void closeSocket(Socket s) throws IOException {
        s.close();
        System.out.println("Encerrada conexão!");
    }

    @Override
    public void run() {
        System.out.println("Iniciando thread do cliente +" + socket.getInetAddress());
        treatConnection(socket);
    }

}
