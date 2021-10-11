/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import ConnectionFactory.Server;
import Model.bean.Encrypt;
import javax.swing.JOptionPane;
import util.Communication;

/**
 *
 * @author William
 */
public class EditAccount implements Runnable {

    private Server server;
    private String replyLogin = "";
    private final byte[] picture;
    private final String format;
    private final String name;
    private final String nickName;
    private final String password;

    public EditAccount(byte[] picture, String format, String name, String nickName, String password) {
        this.picture = picture;
        this.format = format;
        this.name = name;
        this.nickName = nickName;
        this.password = password;
    }



    @Override
    public void run() {
        String hashPassword;
        server = new Server();
        hashPassword = new Encrypt(nickName + password).getHashMd5();
        Communication message = new Communication("EDITACCOUNT");
        try {
            message.setParam("nickName", nickName);
            message.setParam("picture", picture);
            message.setParam("format", format);

        } catch (NullPointerException ex) {
            System.out.print("Sem foto :" + ex);
        }
        if (!password.equals("")) {
            message.setParam("password",hashPassword);
        }
        message.setParam("name", name);
        replyLogin = (String) server.outPut_inPut(message).getParam("EDITACCOUNTREPLY");
        JOptionPane.showMessageDialog(null, "\n" + replyLogin);

    }

}
