/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ConnectionFactory.Server;
import Model.bean.Endereco;
import Model.bean.Propriedade;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import util.Communication;

/**
 *
 * @author William
 */
public class Adress extends javax.swing.JFrame implements ChangeListener {

    private String enderecoInicial = "Av.+Paulista,+São+Paulo+-+SP";
    private String enderecoFinal;
    private String[] values;
    private static String apiKey;
    private String mapHtml = "<html style=\"height: 100%;\"><head><meta name=\"viewport\" content=\"width=device-width, minimum-scale=0.1\"><title>staticmap (600×300)</title></head><body style=\"margin: 0px; height: 100%\"><img style=\"-webkit-user-select: none;margin: auto;background-color: hsl(0, 0%, 90%);transition: background-color 300ms;\" src=\"#img\"></body></html>";
    private boolean selectSizeInit = false;
    private boolean isExec;
    private int propriedadeId;

    public Adress() {
        initComponents();
        setIconTop();
        setKeyAPI();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        setLocation(400, 200);
        setDefaulMap();
        size.addChangeListener(this);
        size.setValue(77);
        size.setEnabled(false);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (selectSizeInit) {
            new Thread(searchZoom).start();
        } else {
            selectSizeInit = true;
        }
    }

    private final Runnable searchZoom = new Runnable() {
        @Override
        public void run() {
            if (!isExec) {
                isExec = true;
                searchMap();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {

                }
                isExec = false;
            }
        }
    };

    public void endereco(int proprID, Endereco end) {
        try {
            logradouro.setText(end.getEndereco());
            referencia.setText(end.getReferencia());
            complemento.setText(end.getComplemento());
            search();
        } catch (NullPointerException ex) {

        }
        this.propriedadeId = proprID;
    }

    private void setDefaulMap() {
        String path = new File("src/Images/cityBackground.png").getAbsoluteFile().toURI().toString();
        this.mapHtml = mapHtml.replace("#img", path);
        mapView.setText(mapHtml);

    }

    private void setKeyAPI() {
        File myObj = new File("apiKey.txt");
        Scanner myReader;
        String apiKey = "";
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                apiKey = myReader.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Adress.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.apiKey = apiKey;
    }

    private void setIconTop() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/city.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        logradouro = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        referencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        complemento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        saveAdress = new javax.swing.JButton();
        mapView = new javax.swing.JEditorPane();
        size = new javax.swing.JSlider();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");

        setTitle("Endereço");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        logradouro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logradouro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        logradouro.setToolTipText("Endereço");
        logradouro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        logradouro.setCaretColor(new java.awt.Color(0, 0, 0));
        logradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                logradouroKeyReleased(evt);
            }
        });

        search.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        search.setText("PESQUISAR");
        search.setToolTipText("Pesquisar");
        search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        search.setContentAreaFilled(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        referencia.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        referencia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        referencia.setToolTipText("Referência");
        referencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        referencia.setCaretColor(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Endereço :");

        complemento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        complemento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        complemento.setToolTipText("Complemento");
        complemento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        complemento.setCaretColor(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Compl : ");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Ref : ");

        saveAdress.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        saveAdress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        saveAdress.setText("SALVAR");
        saveAdress.setToolTipText("Salvar");
        saveAdress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        saveAdress.setContentAreaFilled(false);
        saveAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAdressActionPerformed(evt);
            }
        });

        mapView.setEditable(false);
        mapView.setContentType("text/html"); // NOI18N
        mapView.setText("<html>   <head>    </head>   <body styles=\"background-image: url('https://images.unsplash.com/photo-1579546929518-9e396f3cc809?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MXx8fGVufDB8fHx8&w=1000&q=80'); background-size: 100%;\">     <p style=\"margin-top: 0\">            </p>   </body> </html> ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logradouro)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(referencia, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(saveAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(complemento)
                                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(size, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mapView))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapView, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(referencia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        search();
    }//GEN-LAST:event_searchActionPerformed

    private void logradouroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_logradouroKeyReleased
        if (evt.getKeyCode() == 10) {
            search();
        }
    }//GEN-LAST:event_logradouroKeyReleased

    private void saveAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAdressActionPerformed
        Endereco end = new Endereco();
        end.setEndereco(logradouro.getText());
        end.setComplemento(complemento.getText());
        end.setReferencia(referencia.getText());
        Server server = new Server();
        Communication communication = new Communication("ENDERECOUPDATE");
        communication.setParam("endereco", end);
        communication.setParam("propriedadeId", propriedadeId);
        communication = server.outPut_inPut(communication);
        JOptionPane.showMessageDialog(null, communication.getParam("ENDERECOUPDATEREPLY"));
        setVisible(false);
    }//GEN-LAST:event_saveAdressActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

    }//GEN-LAST:event_formWindowGainedFocus

    private String endercoTratado() {
        String[] endereçoArray = logradouro.getText().split(" ");
        String endereco = "";
        for (String l : endereçoArray) {
            endereco += l + "%20";
        }
        return endereco;
    }

    private void searchMap() {
        enderecoFinal = endercoTratado();
        new Thread(downloadMap).start();
    }

    private void search() {
        enderecoFinal = endercoTratado();
        new Thread(endereco).start();
        new Thread(downloadMap).start();
    }

    private final Runnable downloadMap = new Runnable() {
        @Override
        public void run() {
            String x = String.valueOf((int) (size.getValue() / 4.545454545));
            mapHtml = "<html style=\"height: 100%;\"><head><meta name=\"viewport\" content=\"width=device-width, minimum-scale=0.1\"><title>staticmap (600×300)</title></head><body style=\"margin: 0px; background:white; height: 100%\"><img style=\"-webkit-user-select: none;margin: auto;background-color: hsl(0, 0%, 90%);transition: background-color 300ms;\" src=\"#img\"></body></html>";
            String url = "https://maps.googleapis.com/maps/api/staticmap?size=512x256&maptype=roadmap&markers=size:mid%7Ccolor:red%7C" + endercoTratado() + "&zoom=" + x + "&size=512x256&maptype=roadmap&key=" + apiKey;
            mapHtml = mapHtml.replace("#img", url);
            try {
                mapView.setText(mapHtml);
            } catch (NullPointerException ex) {
            } catch (RuntimeException ex) {
            }
            size.setEnabled(true);
            // faz o preload da imagem
        }
    };

    private final Runnable endereco = new Runnable() {
        @Override
        public void run() {
            String urlString = "https://maps.googleapis.com/maps/api/distancematrix/xml?origins=" + enderecoInicial + "&destinations=" + enderecoFinal + "&key=" + apiKey + "&mode=driving&language=pt-BR&sensor=false";
            try {

                URL urlGoogleDirService = new URL(urlString);
                HttpURLConnection urlGoogleDirCon = (HttpURLConnection) urlGoogleDirService.openConnection();
                urlGoogleDirCon.setAllowUserInteraction(false);
                urlGoogleDirCon.setDoInput(true);
                urlGoogleDirCon.setDoOutput(false);
                urlGoogleDirCon.setUseCaches(true);
                urlGoogleDirCon.setRequestMethod("GET");
                urlGoogleDirCon.connect();

                DocumentBuilderFactory factoryDir = DocumentBuilderFactory.newInstance();
                DocumentBuilder parserDirInfo = factoryDir.newDocumentBuilder();
                Document docDir = parserDirInfo.parse(urlGoogleDirCon.getInputStream());
                urlGoogleDirCon.disconnect();
                String resultado = docDir.getDocumentElement().getTextContent();
                String[] value = resultado.split("\n");
                values = new String[2];
                int i = 0;
                for (String s : value) {
                    if (i == 3) {
                        values[0] = s;
                    }
                    if (s.contains("km")) {
                        values[1] = s;
                    }
                    i++;
                }
                logradouro.setText(values[0]);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField complemento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField logradouro;
    private javax.swing.JEditorPane mapView;
    private javax.swing.JTextField referencia;
    private javax.swing.JButton saveAdress;
    private javax.swing.JButton search;
    private javax.swing.JSlider size;
    // End of variables declaration//GEN-END:variables
}
