/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ConnectionFactory.Server;
import LookAndFeel.LAF;
import Model.bean.Contact;
import Model.bean.ProfilePic;
import Model.bean.TreatFiles;
import Threads.EditAccount;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import util.Communication;

/**
 *
 * @author William
 */
public class EditProfile extends javax.swing.JFrame {

    private SelectorFile sf = new SelectorFile();
    TreatFiles treatFile = new TreatFiles();
    private TreatFiles currentFile = new TreatFiles();
    private BufferedImage bi;
    private String nickName;
    private boolean imageCheck;
    private boolean passwordFieldsEnable;
    private String theme;
    private final Component component;
    private LAF laf;

    public EditProfile(String nickName, Component c) {
        initComponents();
        setIconTop();
        this.component = c;
        this.nickName = nickName;
        nickNameLabel.setText(" " + nickName);
        setProfilePic();
        searchContact();
        togglePasswordFields(false);
        setSize(getWidth(), 484);
        setLaf();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectPicButton = new javax.swing.JButton();
        singUp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        profilePicLabel = new javax.swing.JLabel();
        messageLogin = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        nameIcon = new javax.swing.JLabel();
        changePassword = new javax.swing.JButton();
        nickNameLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        password1 = new javax.swing.JPasswordField();
        senhaLabel1 = new javax.swing.JLabel();
        senhaLabel = new javax.swing.JLabel();
        themeLabel = new javax.swing.JLabel();

        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        selectPicButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        selectPicButton.setText("SELECIONAR FOTO");
        selectPicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPicButtonActionPerformed(evt);
            }
        });

        singUp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        singUp.setText("ATUALIZAR");
        singUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singUpActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("@");
        jLabel1.setToolTipText("nickname do usuário");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("EDITAR PERFIL");

        profilePicLabel.setBackground(new java.awt.Color(255, 255, 255));
        profilePicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilePicLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profileLarge.png"))); // NOI18N
        profilePicLabel.setAlignmentX(0.5F);
        profilePicLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127), 2));

        messageLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        messageLogin.setForeground(new java.awt.Color(255, 51, 0));
        messageLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        name.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        name.setToolTipText("nome");
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
        });

        nameIcon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nameIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nameIcon.png"))); // NOI18N
        nameIcon.setToolTipText("nome do usuário");

        changePassword.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        changePassword.setText("ALTERAR SENHA");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });

        nickNameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nickNameLabel.setText(" nickName");
        nickNameLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        password.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password.setToolTipText("senha");
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordKeyReleased(evt);
            }
        });

        password1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password1.setToolTipText("senha repetida");
        password1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                password1KeyReleased(evt);
            }
        });

        senhaLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        senhaLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/passwordIcon.png"))); // NOI18N
        senhaLabel1.setToolTipText("repetir senha");

        senhaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        senhaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/passwordIcon.png"))); // NOI18N
        senhaLabel.setToolTipText("senha");

        themeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dark.png"))); // NOI18N
        themeLabel.setToolTipText("mudar tema");
        themeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themeLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(senhaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(senhaLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(nameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(themeLabel)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(singUp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(password1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(79, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(profilePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectPicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(name)
                            .addComponent(nickNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(changePassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(themeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profilePicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(selectPicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(password)
                            .addComponent(senhaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(senhaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(singUp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setLaf(String theme) {
        if (theme.equals("")) {
            laf = new LAF();
        } else {
            laf = new LAF(theme);
        }
        laf.setLAF(this);
        if (laf.getTheme().equals("dark")) {
            nameIcon.setIcon(new ImageIcon(getClass().getResource("/Images/nameIcon.png")));
            senhaLabel.setIcon(new ImageIcon(getClass().getResource("/Images/passwordIcon.png")));
            senhaLabel1.setIcon(new ImageIcon(getClass().getResource("/Images/passwordIcon.png")));
            themeLabel.setIcon(new ImageIcon(getClass().getResource("/Images/dark.png")));
            this.theme = "dark";
            themeLabel.setToolTipText("Mudar para tema claro");
        } else {
            nameIcon.setIcon(new ImageIcon(getClass().getResource("/Images/nameIcon-dark.png")));
            senhaLabel.setIcon(new ImageIcon(getClass().getResource("/Images/passwordIcon-dark.png")));
            senhaLabel1.setIcon(new ImageIcon(getClass().getResource("/Images/passwordIcon-dark.png")));
            themeLabel.setIcon(new ImageIcon(getClass().getResource("/Images/light.png")));
            this.theme = "light";
            themeLabel.setToolTipText("Mudar para tema escuro");
        }
    }

    private void setLaf() {
        setLaf("");
    }

    private void togglePasswordFields(boolean b) {
        messageLogin.setVisible(b);
        password.setVisible(b);
        password1.setVisible(b);
        senhaLabel.setVisible(b);
        senhaLabel1.setVisible(b);
        this.passwordFieldsEnable = b;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    private void selectPicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPicButtonActionPerformed
        sf.setVisible(true);
        imageCheck = true;
    }//GEN-LAST:event_selectPicButtonActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if (imageCheck) {
            try {
                InputStream is = new ByteArrayInputStream(sf.getBytes());
                bi = ImageIO.read(is);
                bi = currentFile.resizeImage(bi, 200);
                profilePicLabel.setIcon(new ImageIcon(bi));
                this.currentFile = sf.getCurrentFile();
                this.currentFile.setBytes(currentFile.toByteArray(bi, currentFile.getFileFormat()));
            } catch (Exception ex) {
                this.currentFile = null;
                setProfilePic();
            }
        }
    }//GEN-LAST:event_formWindowGainedFocus


    private void singUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singUpActionPerformed
        if (passwordFieldsEnable) {
            editarPassword();
        } else {
            editar();
        }
    }//GEN-LAST:event_singUpActionPerformed

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        name.setText(limitText(name.getText()));
    }//GEN-LAST:event_nameKeyReleased

    private void passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyReleased

    }//GEN-LAST:event_passwordKeyReleased

    private void password1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password1KeyReleased
        if (evt.getKeyChar() == 10 && passwordFieldsEnable) {
            editarPassword();
        } else if (evt.getKeyChar() == 10 && !passwordFieldsEnable) {
            editar();
        }
    }//GEN-LAST:event_password1KeyReleased

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        if (passwordFieldsEnable) {
            togglePasswordFields(!passwordFieldsEnable);
            setSize(getWidth(), 484);
        } else {
            togglePasswordFields(!passwordFieldsEnable);
            setSize(getWidth(), 594);
        }
    }//GEN-LAST:event_changePasswordActionPerformed

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        name.setEnabled(true);
    }//GEN-LAST:event_nameMouseClicked

    private void themeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themeLabelMouseClicked
        if (theme.equals("dark")) {
            setLaf("light");
            laf.setLAF(component);
        } else {
            setLaf("dark");
            laf.setLAF(component);
        }
    }//GEN-LAST:event_themeLabelMouseClicked

    private void editarPassword() {
        if (password1.getText().equals(password.getText())) {
            messageLogin.setText("");
            if (password1.getText().length() < 8) {
                messageLogin.setText("Sua senha não pode ter menos de 8 caracteres");
            } else {
                editar();
            }
        } else {
            messageLogin.setText("As senhas não são iguais!");
        }
    }

    private void editar() {
        EditAccount editProfile;
        String pass = password.getText();
        if (passwordFieldsEnable == false) {
            pass = "";
        }
        try {
            editProfile = new EditAccount(currentFile.getBytes(), currentFile.getFileFormat(), name.getText(), nickName, pass);
        } catch (NullPointerException ex) {
            editProfile = new EditAccount(null, null, name.getText(), nickName, pass);
        }
        Thread t = new Thread(editProfile);
        t.start();
        setVisible(false);
    }

    private String limitText(String text) {
        return (text.length() > 20) ? text.substring(0, 20) : text;
    }

    private void searchContact() {
        Server server;
        server = new Server();
        Communication message = new Communication("SEARCHCONTACT");
        message.setParam("nickName", nickName);
        Contact c;
        try {
            c = (Contact) server.outPut_inPut(message).getParam("SEARCHCONTACTREPLY");
            name.setEnabled(false);
            name.setText(c.getNome());
        } catch (NullPointerException ex) {
            name.setText("");
        }
        setProfilePic();
    }

    private void setProfilePic() {
        ProfilePic profilepic;
        Server server;
        try {
            server = new Server();
            Communication communication = new Communication("PROFILEIMAGE");
            communication.setParam("nickName", nickName);
            communication = server.outPut_inPut(communication);
            profilepic = (ProfilePic) communication.getParam("PROFILEIMAGEREPLY");
            InputStream is = new ByteArrayInputStream(profilepic.getPicture());
            bi = ImageIO.read(is);
            bi = treatFile.resizeImage(bi, 200);
            profilePicLabel.setIcon(new ImageIcon(bi));
        } catch (NullPointerException | IOException ex) {
            profilePicLabel.setIcon(new ImageIcon(getClass().getResource("/Images/profileLarge.png")));
        }
    }

    private void setIconTop() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/AddCLient.png")));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel messageLogin;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameIcon;
    private javax.swing.JLabel nickNameLabel;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password1;
    private javax.swing.JLabel profilePicLabel;
    private javax.swing.JButton selectPicButton;
    private javax.swing.JLabel senhaLabel;
    private javax.swing.JLabel senhaLabel1;
    private javax.swing.JButton singUp;
    private javax.swing.JLabel themeLabel;
    // End of variables declaration//GEN-END:variables
}
